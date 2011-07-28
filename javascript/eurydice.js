/*
 * * * * * * * * * * * * * * INHERITANCE * * * * * * * * * * * * * *
 */

var pixelAtomHash;  // keyed by coarse (x,y) screen location
var atomBuckets;
var scalar;
var orientation;
var hydrogenCovalentRadius = 0.3;  // angstroms

// The atomBuckets data structure helps to speed up bond inference. For very large
// structures, an octree might do better, but this will do for now.
var BUCKET_LINEAR_DIMENSION = 3;   // angstroms

function extend(base,additional) {
    var r = { }
    for (key in base) {
        r[key] = base[key];
    }
    for (key in additional) {
        r[key] = additional[key];
    }
    return r;
}

/*
 * * * * * * * * * * * * * * VECTORS IN 3-SPACE * * * * * * * * * * * * * *
 * TESTS
 * var v = Vector(1.2, -0.3, 0.78);
 * prettyClose(v.length(), 1.4623269);
 * prettyClose(v.lensq(), 2.1384);
 * prettyClose(v.dotProduct(v), 2.1384);
 * vmatch(v.negate(), Vector(-1.2, 0.3, -0.78));
 * vmatch(v.scale(5), Vector(6, -1.5, 3.9));
 * vmatch(v.crossProduct(Vector(2, 3, 5)), Vector(-3.84, -4.44, 4.2));
 * prettyClose(v.dotProduct(Vector(2, 3, 5)), 5.4);
 * prettyClose(v.distsq(Vector(2, 3, 5)), 29.3384);
 */

var vectorPrototype = {
    toString: function() {
        return "(" + this.getX() + " " + this.getY() + " " + this.getZ() + ")";
    },
    copy: function(other) {
        return Vector(this.getX(), this.getY(), this.getZ());
    },
    add: function(other) {
        return Vector(this.getX() + other.getX(),
                      this.getY() + other.getY(),
                      this.getZ() + other.getZ());
    },
    subtract: function(other) {
        return Vector(this.getX() - other.getX(),
                      this.getY() - other.getY(),
                      this.getZ() - other.getZ());
    },
    negate: function() {
        return Vector(-this.getX(), -this.getY(), -this.getZ());
    },
    scale: function(factor) {
        return Vector(this.getX() * factor,
                      this.getY() * factor,
                      this.getZ() * factor);
    },
    dotProduct: function(other) {
        return this.getX() * other.getX() +
        this.getY() * other.getY() +
        this.getZ() * other.getZ();
    },
    crossProduct: function(other) {
        return Vector(this.getY() * other.getZ() - other.getY() * this.getZ(),
                      this.getZ() * other.getX() - other.getZ() * this.getX(),
                      this.getX() * other.getY() - other.getX() * this.getY());
    },
    multiplyQuaternion: function(other) {
        return Quaternion(0.0, this).multiply(other);
    },
    distsq: function(other) {
        var dx = this.getX() - other.getX();
        var dy = this.getY() - other.getY();
        var dz = this.getZ() - other.getZ();
        return dx * dx + dy * dy + dz * dz;
    },
    lensq: function() {
        var x = this.getX();
        var y = this.getY();
        var z = this.getZ();
        return x * x + y * y + z * z;
    },
    length: function() {
        return Math.sqrt(this.lensq());
    }
};

function Vector(x,y,z) {
    function v() {
        this.getX = function() {
            return x;
        };
        this.getY = function() {
            return y;
        };
        this.getZ = function() {
            return z;
        };
    }
    v.prototype = vectorPrototype;
    return new v();
}

/*
 * * * * * * * * * * * * * * QUATERNIONS * * * * * * * * * * * * * *
 * TESTS
 * var v = Vector(1.2, -0.3, 0.78);
 * var q1 = Quaternion(1, Vector(2, 3, 4));
 * var q2 = Quaternion(3, Vector(-4, 0, 5));
 * qmatch(q1.add(q2), Quaternion(4, Vector(-2, 3, 9)));
 * qmatch(q1.subtract(q2), Quaternion(-2, Vector(6, 3, -1)));
 * qmatch(q1.multiply(q2), Quaternion(-9, Vector(17, -17, 29)));
 * qmatch(q1.divide(q2), Quaternion(0.3, Vector(-0.1, 0.7, -0.1)));
 * qmatch(q1.inverse(), Quaternion(0.033333, Vector(-0.0666667, -0.1, -0.1333333)));
 * qmatch(q1.multiply(q1.inverse()), Quaternion(1, Vector(0, 0, 0)));
 * qmatch(q1.add(q1.negate()), Quaternion(0, Vector(0, 0, 0)));
 * qmatch(q1.scale(5), Quaternion(5, Vector(10, 15, 20)));
 * prettyClose(q1.absoluteValue(), 5.4772255);
 * qmatch(q1.multiplyVector(v), Quaternion(-4.62, Vector(4.74, 2.94, -3.42)));
 * vmatch(q1.rotate(v), Vector(-0.268, 1.42, 0.224));
 * qmatch(q1.normalize(), Quaternion(0.182574, Vector(0.365148, 0.547722, 0.7302967)));
 * qmatch(v.multiplyQuaternion(q1), Quaternion(-4.62, Vector(-2.34, -3.54, 4.98)));
 */

var quaternionPrototype = {
    toString: function() {
        return "(Quat " + this.getReal() + " " + this.getImaginary() + ")";
    },
    add: function(other) {
        return Quaternion(this.getReal() + other.getReal(),
                          this.getImaginary().add(other.getImaginary()));
    },
    subtract: function(other) {
        return Quaternion(this.getReal() - other.getReal(),
                          this.getImaginary().subtract(other.getImaginary()));
    },
    multiply: function(other) {
        var a = this.getReal();
        var im = this.getImaginary();
        var b = im.getX(), c = im.getY(), d = im.getZ();
        var e = other.getReal();
        im = other.getImaginary();
        var f = im.getX(), g = im.getY(), h = im.getZ();
        return Quaternion(a*e - b*f - c*g - d*h,
                          Vector(a*f + b*e + c*h - d*g,
                                 a*g - b*h + c*e + d*f,
                                 a*h + b*g - c*f + d*e));
    },
    multiplyVector: function(other) {
        return this.multiply(Quaternion(0.0, other));
    },
    inverse: function() {
        var k = 1.0 / this.absoluteValueSquared();
        return Quaternion(k * this.getReal(), this.getImaginary().scale(-k));
    },
    conjugate: function() {
        return Quaternion(this.getReal(), this.getImaginary().scale(-1));
    },
    divide: function(other) {
        return this.multiply(other.inverse());
    },
    absoluteValueSquared: function() {
        var re = this.getReal();
        var imlensq = this.getImaginary().lensq();
        return re * re + imlensq;
    },
    absoluteValue: function() {
        return Math.sqrt(this.absoluteValueSquared());
    },
    scale: function(k) {
        return Quaternion(k * this.getReal(), this.getImaginary().scale(k));
    },
    negate: function() {
        return this.scale(-1);
    },
    normalize: function() {
        return this.scale(1.0 / this.absoluteValue());
    },
    rotate: function(v) {  // rotate a vector
        var h = 1.0e-6;
        var avs = this.absoluteValueSquared();
        var q = this;
        if (avs < 1.0 - h || avs > 1.0 + h) {
            q = q.scale(1 / Math.sqrt(avs));
        }
        return q.multiplyVector(v).multiply(q.inverse()).getImaginary();
    }
};

function Quaternion(re,im) {
    function q() {
        this.getReal = function() {
            return re;
        };
        this.getImaginary = function() {
            return im;
        };
    }
    q.prototype = quaternionPrototype;
    return new q();
}

function makeRotator(theta, axis) {
    return Quaternion(Math.cos(0.5 * theta),
                      axis.scale(Math.sin(0.5 * theta) / axis.length()));
}

/*
 * * * * * * * * * * * * * * ATOMS AND ELEMENTS * * * * * * * * * * * * * *
 * Stuff I'm not going to implement immediately:
 *   Unique IDs for atoms (probably never in the JS code)
 *   Integer charge
 *   Fractional charge
 *   rehybridize method
 *
 * TESTS
 * equal(Atom.NONE, 0);
 * equal(Atom.SP, 1);
 * equal(Atom.SP2, 2);
 * equal(Atom.SP3, 3);
 *
 * var atom = Carbon();
 * equal(atom.getName(), "Carbon");
 * equal(atom.getSymbol(), "C");
 * equal(atom.getHybridization(), Atom.SP3);
 * equal(atom.getAtomicNumber(), 6);
 * prettyClose(atom.getMass(), 12);
 * colorMatch(atom.getColor(), Color.getColor("gray30"));
 * prettyClose(atom.getCovalentRadius(), 0.77);
 * prettyClose(atom.getVdwEnergy(), 0.357);
 * prettyClose(atom.getVdwRadius(), 1.85);
 * atom.setHybridization(Atom.SP2);
 * prettyClose(atom.getCovalentRadius(), 0.67);
 * atom.setHybridization(Atom.SP);
 * prettyClose(atom.getCovalentRadius(), 0.6);
 * equal(atom.getCorrectNumBonds(), 4);
 * atom.setPosition(Vector(31, 14, 16));
 * atom.move(Vector(27, 18, 28));
 * vmatch(atom.getPosition(), Vector(58, 32, 44));
 * atom.setPreviousPosition(Vector(1, 2, 3));
 * vmatch(atom.getPreviousPosition(), Vector(1, 2, 3));
 * atom.setPreviousPosition(Vector(4, 5, 6));
 * vmatch(atom.getPreviousPosition(), Vector(4, 5, 6));
 * atom.zeroForce();
 * vmatch(atom.getForce(), Vector(0, 0, 0));
 * atom.setForce(Vector(1, 3, 5));
 * atom.addForce(Vector(7, 6, 5));
 * vmatch(atom.getForce(), Vector(8, 9, 10));
 *
 * atom = Hydrogen();
 * equal(atom.getName(), "Hydrogen");
 * equal(atom.getSymbol(), "H");
 * equal(atom.getHybridization(), Atom.NONE);
 * equal(atom.getAtomicNumber(), 1);
 * prettyClose(atom.getMass(), 1);
 * colorMatch(atom.getColor(), Color.getColor("white"));
 * prettyClose(atom.getCovalentRadius(), 0.3);
 * prettyClose(atom.getVdwEnergy(), 0.382);
 * prettyClose(atom.getVdwRadius(), 1.2);
 * equal(atom.getCorrectNumBonds(), 1);
 * atom.setPosition(Vector(31, 14, 16));
 * atom.move(Vector(27, 18, 28));
 * vmatch(atom.getPosition(), Vector(58, 32, 44));
 * atom.setPreviousPosition(Vector(1, 2, 3));
 * vmatch(atom.getPreviousPosition(), Vector(1, 2, 3));
 * atom.setPreviousPosition(Vector(4, 5, 6));
 * vmatch(atom.getPreviousPosition(), Vector(4, 5, 6));
 * atom.zeroForce();
 * vmatch(atom.getForce(), Vector(0, 0, 0));
 * atom.setForce(Vector(1, 3, 5));
 * atom.addForce(Vector(7, 6, 5));
 * vmatch(atom.getForce(), Vector(8, 9, 10));
 * 
 * atom = Oxygen();
 * equal(atom.getName(), "Oxygen");
 * equal(atom.getSymbol(), "O");
 * equal(atom.getHybridization(), Atom.SP3);
 * equal(atom.getAtomicNumber(), 8);
 * prettyClose(atom.getMass(), 16);
 * colorMatch(atom.getColor(), Color.getColor("red"));
 * prettyClose(atom.getCovalentRadius(), 0.74);
 * prettyClose(atom.getVdwEnergy(), 0.406);
 * prettyClose(atom.getVdwRadius(), 1.4);
 * atom.setHybridization(Atom.SP2);
 * prettyClose(atom.getCovalentRadius(), 0.62);
 * prettyClose(atom.getVdwEnergy(), 0.536);
 * atom.setHybridization(Atom.SP);
 * prettyClose(atom.getCovalentRadius(), 0.55);
 * prettyClose(atom.getVdwEnergy(), 0.536);
 * equal(atom.getCorrectNumBonds(), 2);
 * atom.setPosition(Vector(31, 14, 16));
 * atom.move(Vector(27, 18, 28));
 * vmatch(atom.getPosition(), Vector(58, 32, 44));
 * atom.setPreviousPosition(Vector(1, 2, 3));
 * vmatch(atom.getPreviousPosition(), Vector(1, 2, 3));
 * atom.setPreviousPosition(Vector(4, 5, 6));
 * vmatch(atom.getPreviousPosition(), Vector(4, 5, 6));
 * atom.zeroForce();
 * vmatch(atom.getForce(), Vector(0, 0, 0));
 * atom.setForce(Vector(1, 3, 5));
 * atom.addForce(Vector(7, 6, 5));
 * vmatch(atom.getForce(), Vector(8, 9, 10));
 * 
 * atom = Nitrogen();
 * equal(atom.getName(), "Nitrogen");
 * equal(atom.getSymbol(), "N");
 * equal(atom.getHybridization(), Atom.SP3);
 * equal(atom.getAtomicNumber(), 7);
 * prettyClose(atom.getMass(), 14);
 * colorMatch(atom.getColor(), Color.getColor("blue"));
 * prettyClose(atom.getCovalentRadius(), 0.74);  // IDENTICAL to oxygen???
 * prettyClose(atom.getVdwEnergy(), 0.447);
 * prettyClose(atom.getVdwRadius(), 1.5);
 * atom.setHybridization(Atom.SP2);
 * prettyClose(atom.getCovalentRadius(), 0.62); // ? ?
 * atom.setHybridization(Atom.SP);
 * prettyClose(atom.getCovalentRadius(), 0.55); // ? ?
 * equal(atom.getCorrectNumBonds(), 3);
 * atom.setPosition(Vector(31, 14, 16));
 * atom.move(Vector(27, 18, 28));
 * vmatch(atom.getPosition(), Vector(58, 32, 44));
 * atom.setPreviousPosition(Vector(1, 2, 3));
 * vmatch(atom.getPreviousPosition(), Vector(1, 2, 3));
 * atom.setPreviousPosition(Vector(4, 5, 6));
 * vmatch(atom.getPreviousPosition(), Vector(4, 5, 6));
 * atom.zeroForce();
 * vmatch(atom.getForce(), Vector(0, 0, 0));
 * atom.setForce(Vector(1, 3, 5));
 * atom.addForce(Vector(7, 6, 5));
 * vmatch(atom.getForce(), Vector(8, 9, 10));
 */

function Color(r,g,b) {
    function c() { };
    c.prototype = {
        toString: function() {
            return "(Color " + r + " " + g + " " + b + ")";
        },
        getRed: function() {
            return r;
        },
        getGreen: function() {
            return g;
        },
        getBlue: function() {
            return b;
        },
    };
    return new c();
}

Color.getColor = function(colorname) {
    if ("Black" == colorname || "black" == colorname)
        return Color(0, 0, 0);
    else if ("Gray10" == colorname || "gray10" == colorname)
        return Color(26, 26, 26);
    else if ("Gray20" == colorname || "gray20" == colorname)
        return Color(51, 51, 51);
    else if ("Gray30" == colorname || "gray30" == colorname)
        return Color(77, 77, 77);
    else if ("Gray40" == colorname || "gray40" == colorname)
        return Color(102, 102, 102);
    else if ("Gray50" == colorname || "gray50" == colorname)
        return Color(128, 128, 128);
    else if ("Gray60" == colorname || "gray60" == colorname)
        return Color(154, 154, 154);
    else if ("Gray70" == colorname || "gray70" == colorname)
        return Color(179, 179, 179);
    else if ("Gray80" == colorname || "gray80" == colorname)
        return Color(204, 204, 204);
    else if ("Gray90" == colorname || "gray90" == colorname)
        return Color(230, 230, 230);
    else if ("White" == colorname || "white" == colorname)
        return Color(255, 255, 255);

    else if ("Red" == colorname || "red" == colorname)
        return Color(255, 0, 0);
    else if ("Green" == colorname || "green" == colorname)
        return Color(0, 255, 0);
    else if ("Blue" == colorname || "blue" == colorname)
        return Color(0, 0, 255);
    else if ("Cyan" == colorname || "cyan" == colorname)
        return Color(0, 255, 255);
    else if ("Magenta" == colorname || "magenta" == colorname)
        return Color(255, 0, 255);
    else if ("Yellow" == colorname || "yellow" == colorname)
        return Color(255, 255, 0);

    else if ("Orange" == colorname || "orange" == colorname)
        return Color(255, 132, 0);
    else if ("Purple" == colorname || "purple" == colorname)
        return Color(162, 0, 255);

    return null;
};

var Atom = {
    NONE: 0,
    SP: 1,
    SP2: 2,
    SP3: 3
};

var atomPrototype = {
    init: function() {
        // default behavior is to do nothing
    },
    toString: function() {
        return "(" + this.getSymbol() + " " + this.getUniqueId() + ")";
    },
    setUniqueId: function(v) {
        this._uniqueid = v;
    },
    getUniqueId: function() {
        return this._uniqueid;
    },
    setPosition: function(v) {
        this._position = v;
    },
    getPosition: function() {
        return this._position;
    },
    move: function(v) {
        this._position = this._position.add(v);
    },
    setForce: function(v) {
        this._force = v;
    },
    getForce: function() {
        return this._force;
    },
    addForce: function(v) {
        this._force = this._force.add(v);
    },
    zeroForce: function(v) {
        this._force = Vector(0, 0, 0);
    },
    setPreviousPosition: function(v) {
        this._previous = v;
    },
    getPreviousPosition: function(v) {
        return this._previous;
    },
    setHybridization: function(h) {
        // check valid hybridization for this element??
        this._h = h;
    },
    getHybridization: function() {
        return this._h;
    },
    getHybridizationString: function() {
        switch (this.getHybridization()) {
            default:
            case Atom.SP3: return "SP3";
            case Atom.SP2: return "SP2";
            case Atom.SP: return "SP";
            case Atom.NONE: return "NONE";
        }
    },
    reorient: function() {
        var newpos = orientation.transform(this.getPosition().scale(scalar));
        var r = 0.9 * scalar * orientation.P * this.getCovalentRadius();
        function atomConstructor() { };
        atomConstructor.prototype = this.getPrototype();
        var a = new atomConstructor();
        a.setPosition(newpos);
        a.getCovalentRadius = function() {
            return r;
        };
        a.original = this;
        return a;
    },
    getNeighbors: function() {
        // return an array of atoms bonded directly to this guy
        var neighbors = [ ];
        var bondLengthTolerance = 0.4;
        var covR = this.getCovalentRadius();
        var xi = Math.floor(this._position.getX() / BUCKET_LINEAR_DIMENSION);
        var yi = Math.floor(this._position.getY() / BUCKET_LINEAR_DIMENSION);
        var zi = Math.floor(this._position.getZ() / BUCKET_LINEAR_DIMENSION);
        for (var x = xi - 1; x <= xi + 1; x++)
            for (var y = yi - 1; y <= yi + 1; y++)
                for (var z = zi - 1; z <= zi + 1; z++) {
                    var bucket = atomBuckets[x + ":" + y + ":" + z];
                    if (bucket !== null && bucket !== undefined) {
                        for (var i in bucket) {
                            var a2 = bucket[i];
                            var dx = a2._position.subtract(this._position).length();
                            if (dx > covR &&
                                dx < covR + a2.getCovalentRadius() + bondLengthTolerance) {
                                neighbors.push(a2);
                            }
                        }
                    }
                }
        return neighbors;
    },
    draw: function() {
        var canvas = document.getElementById("canvas");
        var context = canvas.getContext("2d");
        var pos = this.getPosition();
        var w = canvas.width;
        var h = canvas.height;
        var K = 0.8 * ((w < h) ? w : h);
        var x = K * pos.getX() + w/2;
        var y = K * pos.getY() + h/2;
        var z = pos.getZ();
        var r = K * this.getCovalentRadius();
        this.containsMouse = function(xmouse, ymouse) {
            var dx = xmouse - x;
            var dy = ymouse - y;
            return (dx * dx + dy * dy) < (r * r);
        }
        this.getScreenDepth = function() {
            return z;
        }
        var xmin = Math.floor((x - r) / 50);
        var xmax = Math.floor((x + r) / 50) + 1;
        var ymin = Math.floor((y - r) / 50);
        var ymax = Math.floor((y + r) / 50) + 1;
        for (var xi = xmin; xi <= xmax; xi++)
            for (var yi = ymin; yi <= ymax; yi++) {
                var key = 4000 * xi + yi;
                if (!(key in pixelAtomHash) )
                    pixelAtomHash[key] = [ ];
                pixelAtomHash[key].push(this);
            }
        context.drawImage(this.getImage(), x-r, y-r, 2*r, 2*r);
    },
};

var carbonPrototype =
    extend(atomPrototype, {
            init: function() {
                this.setHybridization(Atom.SP3);
            },
            getName: function() {
                return "Carbon";
            },
            getImage: function() {
                return document.getElementById("carbon");
            },
            getSymbol: function() {
                return "C";
            },
            getAtomicNumber: function() {
                return 6;
            },
            getMass: function() {
                return 12;
            },
            getColor: function() {
                return Color.getColor("gray30");
            },
            getCovalentRadius: function() {
                if (this._h === Atom.SP2)
                    return 0.67;
                if (this._h === Atom.SP)
                    return 0.6;
                return 0.77;
            },
            getVdwEnergy: function() {
                return 0.357;
            },
            getVdwRadius: function() {
                return 1.85;
            },
            getCorrectNumBonds: function() {
                return 4;
            },
            getPrototype: function() {
                return carbonPrototype;
            },
        });

function Carbon() {
    function c() { }
    c.prototype = carbonPrototype;
    var atom = new c();
    atom.init();
    return atom;
}

var hydrogenPrototype =
    extend(atomPrototype, {
            getImage: function() {
                return document.getElementById("hydrogen");
            },
            getName: function() {
                return "Hydrogen";
            },
            getSymbol: function() {
                return "H";
            },
            getAtomicNumber: function() {
                return 1;
            },
            getMass: function() {
                return 1;
            },
            getColor: function() {
                return Color.getColor("white");
            },
            getCovalentRadius: function() {
                return hydrogenCovalentRadius;
            },
            getVdwEnergy: function() {
                return 0.382;
            },
            getVdwRadius: function() {
                return 1.2;
            },
            getCorrectNumBonds: function() {
                return 1;
            },
            setHybridization: function(h) {
                // never rehybridize
            },
            getHybridization: function() {
                return Atom.NONE;   // never rehybridize
            },
            getPrototype: function() {
                return hydrogenPrototype;
            },
        });

function Hydrogen() {
    function h() { }
    h.prototype = hydrogenPrototype;
    var atom = new h();
    atom.init();
    return atom;
}

var oxygenPrototype =
    extend(atomPrototype, {
            getImage: function() {
                return document.getElementById("oxygen");
            },
            init: function() {
                this.setHybridization(Atom.SP3);
            },
            getName: function() {
                return "Oxygen";
            },
            getSymbol: function() {
                return "O";
            },
            getAtomicNumber: function() {
                return 8;
            },
            getMass: function() {
                return 16;
            },
            getColor: function() {
                return Color.getColor("red");
            },
            getCovalentRadius: function() {
                if (this._h === Atom.SP2)
                    return 0.62;
                if (this._h === Atom.SP)
                    return 0.55;
                return 0.74;
            },
            getVdwEnergy: function() {
                if (this._h === Atom.SP2 || this._h === Atom.SP)
                    return 0.536;
                return 0.406;
            },
            getVdwRadius: function() {
                return 1.4;
            },
            getCorrectNumBonds: function() {
                return 2;
            },
            getPrototype: function() {
                return oxygenPrototype;
            },
        });

function Oxygen() {
    function ox() { }
    ox.prototype = oxygenPrototype;
    var atom = new ox();
    atom.init();
    return atom;
}

var nitrogenPrototype =
    extend(atomPrototype, {
            getImage: function() {
                return document.getElementById("nitrogen");
            },
            init: function() {
                this.setHybridization(Atom.SP3);
            },
            getName: function() {
                return "Nitrogen";
            },
            getSymbol: function() {
                return "N";
            },
            getAtomicNumber: function() {
                return 7;
            },
            getMass: function() {
                return 14;
            },
            getColor: function() {
                return Color.getColor("blue");
            },
            getCovalentRadius: function() {
                // IDENTICAL to oxygen? is that right???
                if (this._h === Atom.SP2)
                    return 0.62;
                if (this._h === Atom.SP)
                    return 0.55;
                return 0.74;
            },
            getVdwEnergy: function() {
                return 0.447;
            },
            getVdwRadius: function() {
                return 1.5;
            },
            getCorrectNumBonds: function() {
                return 3;
            },
            getPrototype: function() {
                return nitrogenPrototype;
            },
        });

function Nitrogen() {
    function n() { }
    n.prototype = nitrogenPrototype;
    var atom = new n();
    atom.init();
    return atom;
}

var fluorinePrototype =
    extend(atomPrototype, {
            getImage: function() {
                return document.getElementById("fluorine");
            },
            init: function() {
                this.setHybridization(Atom.SP3);
            },
            getName: function() {
                return "Fluorine";
            },
            getSymbol: function() {
                return "F";
            },
            getAtomicNumber: function() {
                return 9;
            },
            getMass: function() {
                return 19;
            },
            getColor: function() {
                return Color.getColor("green");
            },
            getCovalentRadius: function() {
                return 0.6;
            },
            getVdwEnergy: function() {
                return 0.447;  // TODO - correct value
            },
            getVdwRadius: function() {
                return 1.47;
            },
            getCorrectNumBonds: function() {
                return 1;
            },
            getPrototype: function() {
                return fluorinePrototype;
            },
        });

function Fluorine() {
    function n() { }
    n.prototype = fluorinePrototype;
    var atom = new n();
    atom.init();
    return atom;
}

var sulfurPrototype =
    extend(atomPrototype, {
            getImage: function() {
                return document.getElementById("sulfur");
            },
            init: function() {
                this.setHybridization(Atom.SP3);
            },
            getName: function() {
                return "Sulfur";
            },
            getSymbol: function() {
                return "S";
            },
            getAtomicNumber: function() {
                return 16;
            },
            getMass: function() {
                return 32.065;
            },
            getColor: function() {
                return Color.getColor("yellow");
            },
            getCovalentRadius: function() {
                return 1.05;
            },
            getVdwEnergy: function() {
                return 0.447;  // TODO - correct value?
            },
            getVdwRadius: function() {
                return 1.8;
            },
            getCorrectNumBonds: function() {
                return 2;
            },
            getPrototype: function() {
                return sulfurPrototype;
            },
        });

function Sulfur() {
    function n() { }
    n.prototype = sulfurPrototype;
    var atom = new n();
    atom.init();
    return atom;
}

var siliconPrototype =
    extend(atomPrototype, {
            getImage: function() {
                return document.getElementById("silicon");
            },
            init: function() {
                this.setHybridization(Atom.SP3);
            },
            getName: function() {
                return "Silicon";
            },
            getSymbol: function() {
                return "Si";
            },
            getAtomicNumber: function() {
                return 14;
            },
            getMass: function() {
                return 28.0855;
            },
            getColor: function() {
                return Color.getColor("Gray70");
            },
            getCovalentRadius: function() {
                return 1.11;
            },
            getVdwEnergy: function() {
                return 0.447; // TODO - correct value?
            },
            getVdwRadius: function() {
                return 2.1;
            },
            getCorrectNumBonds: function() {
                return 4;
            },
            getPrototype: function() {
                return siliconPrototype;
            },
        });

function Silicon() {
    function n() { }
    n.prototype = siliconPrototype;
    var atom = new n();
    atom.init();
    return atom;
}

var chlorinePrototype =
    extend(atomPrototype, {
            getImage: function() {
                return document.getElementById("chlorine");
            },
            init: function() {
                this.setHybridization(Atom.SP3);
            },
            getName: function() {
                return "Chlorine";
            },
            getSymbol: function() {
                return "Cl";
            },
            getAtomicNumber: function() {
                return 17;
            },
            getMass: function() {
                return 35.453;
            },
            getColor: function() {
                return Color.getColor("orange");
            },
            getCovalentRadius: function() {
                return 1.02;
            },
            getVdwEnergy: function() {
                return 0.447;  // TODO - correct value
            },
            getVdwRadius: function() {
                return 1.75;
            },
            getCorrectNumBonds: function() {
                return 1;
            },
            getPrototype: function() {
                return chlorinePrototype;
            },
        });

function Chlorine() {
    function n() { }
    n.prototype = chlorinePrototype;
    var atom = new n();
    atom.init();
    return atom;
}

var phosphorusPrototype =
    extend(atomPrototype, {
            getImage: function() {
                return document.getElementById("phosphorus");
            },
            init: function() {
                this.setHybridization(Atom.SP3);
            },
            getName: function() {
                return "Phosphorus";
            },
            getSymbol: function() {
                return "P";
            },
            getAtomicNumber: function() {
                return 15;
            },
            getMass: function() {
                return 30.97;
            },
            getColor: function() {
                return Color.getColor("purple");
            },
            getCovalentRadius: function() {
                return 1.07;
            },
            getVdwEnergy: function() {
                return 0.447;  // TODO - correct value
            },
            getVdwRadius: function() {
                return 1.8;
            },
            getCorrectNumBonds: function() {
                return 3;  // works like nitrogen
            },
            getPrototype: function() {
                return phosphorusPrototype;
            },
        });

function Phosphorus() {
    function n() { }
    n.prototype = phosphorusPrototype;
    var atom = new n();
    atom.init();
    return atom;
}

/*
 * * * * * * * * * * * * * * STRUCTURE STUFF * * * * * * * * * * * * * *
 */

var atomArray;
var rotArray;  // used for pretty drawing when mouse is up, reused for tooltip
var bondsByAtom;   // bidirectional hashmap: atom -> [atom, atom, atom...]

function buildBondInfo() {
    bondsByAtom = { };
    atomBuckets = { };
    for (var i in atomArray) {
        // add the atom to the appropriate bucket
        var pos = atomArray[i].getPosition();
        var xi = Math.floor(pos.getX() / BUCKET_LINEAR_DIMENSION);
        var yi = Math.floor(pos.getY() / BUCKET_LINEAR_DIMENSION);
        var zi = Math.floor(pos.getZ() / BUCKET_LINEAR_DIMENSION);
        var key = xi + ":" + yi + ":" + zi;
        if (!(key in atomBuckets))
            atomBuckets[key] = [ ];
        atomBuckets[key].push(atomArray[i]);
    }
    for (var i in atomArray) {
        var atom = atomArray[i];
        bondsByAtom[atom] = atom.getNeighbors();
    }
}

function recenterAtoms() {
    var centerOfGravity = Vector(0.0, 0.0, 0.0);
    var numAtoms = 0;
    for (var i in atomArray) {
        numAtoms++;
        centerOfGravity = centerOfGravity.add(atomArray[i].getPosition());
    }
    centerOfGravity = centerOfGravity.scale(1.0 / numAtoms);
    for (var i in atomArray) {
        atomArray[i].setPosition(atomArray[i].getPosition().subtract(centerOfGravity));
    }
}

function deleteBondsFor(atom) {
    var buddies = bondsByAtom[atom];
    delete bondsByAtom[atom];
    for (var i in buddies) {
        var buddy = buddies[i];
        var hisBuddies = bondsByAtom[buddy];
        var n = hisBuddies.indexOf(atom);
        hisBuddies.splice(n, 1);
        bondsByAtom[buddy] = hisBuddies;
    }
    return buddies;
}

function addAtomConnectedToExisting(atom,existing) {
    atom.setUniqueId(++largestIdThusfar);
    atomArray[atom.getUniqueId()] = atom;
    bondsByAtom[atom] = [ existing ];
    bondsByAtom[existing].push(atom);
}

function removeAtom(atom) {
    if (atom.getSymbol() === "H") {
        return;
    }
    // update atomArray with deletion of chosen atom
    var neighborhood = deleteBondsFor(atom);
    delete atomArray[atom.getUniqueId()];
    // each surviving neighbor gets a hydrogen to terminate
    for (var i in neighborhood) {
        var neighbor = neighborhood[i];
        if (neighbor.getSymbol() === "H") {
            // unless it's hydrogen, then kill it
            deleteBondsFor(neighbor);
            delete atomArray[neighbor.getUniqueId()];
        } else {
            var direction = atom.getPosition().subtract(neighbor.getPosition());
            var distance = neighbor.getCovalentRadius() + hydrogenCovalentRadius;
            direction = direction.scale(distance / direction.length());
            var h = Hydrogen();
            h.setPosition(neighbor.getPosition().add(direction));
            addAtomConnectedToExisting(h, neighbor);
        }
    }
}

function addAtom(oldH,symbol) {
    // this makes sense only if the atom is hydrogen
    if (oldH.getSymbol() !== "H") {
        return;
    }
    var newAtom = undefined;
    switch (symbol) {
        case "C":
            newAtom = Carbon();
            break;
        case "N":
            newAtom = Nitrogen();
            break;
        case "O":
            newAtom = Oxygen();
            break;
        case "F":
            newAtom = Fluorine();
            break;
        case "Si":
            newAtom = Silicon();
            break;
        case "P":
            newAtom = Phosphorus();
            break;
        case "S":
            newAtom = Sulfur();
            break;
        case "Cl":
            newAtom = Chlorine();
            break;
        default:
            return;
    }
    var TETRAHEDRAL_GEOMETRY = 0;
    var TRIGONAL_GEOMETRY = 1;
    var LINEAR_GEOMETRY = 2;
    var geometry;
    var hydrogensNeeded;
    switch (findChosenRadioButton("hybrid")) {
        case "sp3":
            newAtom.setHybridization(Atom.SP3);
            geometry = TETRAHEDRAL_GEOMETRY;
            hydrogensNeeded = newAtom.getCorrectNumBonds() - 1;
            break;
        case "sp2":
            newAtom.setHybridization(Atom.SP2);
            geometry = TRIGONAL_GEOMETRY;
            hydrogensNeeded = newAtom.getCorrectNumBonds() - 2;
            break;
        case "sp":
            newAtom.setHybridization(Atom.SP);
            geometry = LINEAR_GEOMETRY;
            hydrogensNeeded = newAtom.getCorrectNumBonds() - 3;
            break;
        default:
            return;
    }
    // update atomArray: remove old hydrogen
    var neighborhood = deleteBondsFor(oldH);
    delete atomArray[oldH.getUniqueId()];
    // find correct position for new atom, add it
    var neighbor = neighborhood[0];
    var direction = oldH.getPosition().subtract(neighbor.getPosition());
    var distance = neighbor.getCovalentRadius() + newAtom.getCovalentRadius();
    direction = direction.scale(distance / direction.length());
    newAtom.setPosition(neighbor.getPosition().add(direction));
    addAtomConnectedToExisting(newAtom, neighbor);
    var sqrt2 = Math.sqrt(2);
    var sqrt3 = Math.sqrt(3);
    var sqrt6 = Math.sqrt(6);
    // compute how far the hydrogens are from the new atom
    var hdist = newAtom.getCovalentRadius() + hydrogenCovalentRadius;
    // u is a unit vector pointing from the existing neighbor to the new atom
    var u = direction.scale(1.0 / direction.length());
    // z is a unit vector in a random direction perpendicular to u
    // TODO: determine this from neighbor geometry, not just random
    var z = u.crossProduct(Vector(u.getY(), -u.getX(), u.getZ()));
    z = z.scale(1.0 / z.length());
    // t is a unit vector perpendicular to both u and z
    var t = u.crossProduct(z);
    // It would be great to be able to display lone pairs. These would be
    // located where there would be unused sigma bonds, e.g. SP3 nitrogen
    // has tetrahedral geometry but only three bonds.
    if (geometry === LINEAR_GEOMETRY) {
        // It would be great to be able to display pi orbitals. They
        // would go at t.scale(K).add(newAtom.getPosition()) and
        // z.scale(K).add(newAtom.getPosition()) and
        // t.scale(K).add(newAtom.getPosition()) and
        // z.scale(-K).add(newAtom.getPosition()), for some distance K.
        if (hydrogensNeeded == 1) {
            var newH = Hydrogen();
            newH.setPosition(u.scale(hdist).add(newAtom.getPosition()));
            addAtomConnectedToExisting(newH, newAtom);
        }
    } else if (geometry === TRIGONAL_GEOMETRY) {
        // It would be great to be able to display pi orbitals. They
        // would go at t.scale(K).add(newAtom.getPosition()) and
        // t.scale(-K).add(newAtom.getPosition()), for some distance K.
        if (hydrogensNeeded >= 1) {
            var x = u.scale(0.5).add(z.scale(sqrt3/2));
            var newH = Hydrogen();
            newH.setPosition(x.scale(hdist).add(newAtom.getPosition()));
            addAtomConnectedToExisting(newH, newAtom);
        }
        if (hydrogensNeeded == 2) {
            var y = u.scale(0.5).add(z.scale(-sqrt3/2));
            var newH = Hydrogen();
            newH.setPosition(y.scale(hdist).add(newAtom.getPosition()));
            addAtomConnectedToExisting(newH, newAtom);
        }
    } else if (geometry === TETRAHEDRAL_GEOMETRY) {
        var w = u.scale(1.0/3).add(z.scale(2*sqrt2/3));
        // tperp is the contributions of u and z to the positions of the
        // second and third hydrogens
        var tperp = u.scale(1.0/3).add(z.scale(-sqrt2/3));
        if (hydrogensNeeded >= 1) {
            var newH = Hydrogen();
            newH.setPosition(w.scale(hdist).add(newAtom.getPosition()));
            addAtomConnectedToExisting(newH, newAtom);
        }
        if (hydrogensNeeded >= 2) {
            var t1 = tperp.add(t.scale(sqrt6/3));
            var newH = Hydrogen();
            newH.setPosition(t1.scale(hdist).add(newAtom.getPosition()));
            addAtomConnectedToExisting(newH, newAtom);
        }
        if (hydrogensNeeded == 3) {
            var t2 = tperp.add(t.scale(-sqrt6/3));
            var newH = Hydrogen();
            newH.setPosition(t2.scale(hdist).add(newAtom.getPosition()));
            addAtomConnectedToExisting(newH, newAtom);
        }
    }
}

/*
 * * * * * * * * * * ORIENTATION and DRAWING * * * * * * * * * * *
 */

var orientationPrototype = {
    toString: function() {
        return "(orientation " + this.quat.toString() + ")";
    },
    rotX: function(angle) {
        this.quat = makeRotator(angle, Vector(-1,0,0)).multiply(this.quat);
    },
    rotY: function(angle) {
        this.quat = makeRotator(angle, Vector(0,1,0)).multiply(this.quat);
    },
    // perspective factor isn't valid for a vector unless you've run
    // the transform method on that vector, and not yet run it on any other
    transform: function(vec) {
        vec = this.quat.rotate(vec);
        var perspectiveDistance = 2;
        this.P = perspectiveDistance / (perspectiveDistance - vec.getZ());
        return Vector(this.P * vec.getX(), this.P * vec.getY(), vec.getZ());
    }
};

function Orientation() {
    function n() { }
    n.prototype = orientationPrototype;
    var ort = new n();
    ort.quat = Quaternion(1, Vector(0, 0, 0));
    ort.rotcount = 0;
    ort.P = 1;
    return ort;
}

function selectGoodScalar() {
    var xmin = 1.0e20;
    var ymin = 1.0e20;
    var zmin = 1.0e20;
    var xmax = -1.0e20;
    var ymax = -1.0e20;
    var zmax = -1.0e20;
    for (var i in atomArray) {
        var pos = atomArray[i].getPosition();
        var x = pos.getX();
        var y = pos.getY();
        var z = pos.getZ();
        if (x < xmin) xmin = x;
        if (x > xmax) xmax = x;
        if (y < ymin) ymin = y;
        if (y > ymax) ymax = y;
        if (z < zmin) zmin = z;
        if (z > zmax) zmax = z;
    }
    var dx = xmax - xmin;
    var dy = ymax - ymin;
    var dz = zmax - zmin;
    var maxDimension = (dx > dy) ? dx : dy;
    maxDimension = (dz > maxDimension) ? dz : maxDimension;
    if (maxDimension < 5) maxDimension = 5;
    scalar = 1.0 / maxDimension;   // tinker with constant as needed
}

function drawAtoms() {
    var canvas = document.getElementById("canvas");
    var context = canvas.getContext("2d");
    context.fillStyle = canvasBackgroundColor;
    context.fillRect(0, 0, canvas.width, canvas.height);
    rotArray = [ ];
    pixelAtomHash = { };
    for (var i in atomArray) {
        rotArray.push(atomArray[i].reorient());
    }
    rotArray.sort(function(atom1,atom2) {
            if (atom1.getPosition().getZ() > atom2.getPosition().getZ()) {
                return 1;
            }
            if (atom1.getPosition().getZ() < atom2.getPosition().getZ()) {
                return -1;
            }
            return 0;
        });
    for (var i in rotArray) {
        rotArray[i].draw();
    }
}

function quickdrawAtoms() {
    var canvas = document.getElementById("canvas");
    var context = canvas.getContext("2d");
    context.fillStyle = canvasBackgroundColor;
    context.fillRect(0, 0, canvas.width, canvas.height);
    rotArray = [ ];
    for (var i in atomArray) {
        var ratom = atomArray[i].reorient();
        atomArray[i].rotated = ratom;
        rotArray.push(ratom);
    }
    var w = canvas.width;
    var h = canvas.height;
    var K = 0.8 * ((w < h) ? w : h);
    for (var i in rotArray) {
        var ratom = rotArray[i];
        var atom = ratom.original;
        var aid = atom.getUniqueId();
        var u = ratom.getPosition();
        var neighborList = bondsByAtom[atom];
        for (var j in neighborList) {
            var atom2 = neighborList[j];
            var a2id = atom2.getUniqueId();
            if (aid < a2id) {
                var v = atom2.rotated.getPosition();
                // draw a line, see http://diveintohtml5.org/canvas.html
                // depth cue during quickdraw: darker lines for bonds closer to the user
                if (u.getZ() + v.getZ() > 0.0)
                    context.strokeStyle = "#000";
                else
                    context.strokeStyle = "#799";
                context.beginPath();
                context.moveTo(K * u.getX() + w/2, K * u.getY() + h/2);
                context.lineTo(K * v.getX() + w/2, K * v.getY() + h/2);
                context.stroke();
            }
        }
    }
}

function redraw() {
    document.getElementById("canvas").height = canvasheight;
    var width = window.innerWidth - canvasgap;
    if (width > canvasheight * 1.5)
        width = Math.floor(canvasheight * 1.5);
    document.getElementById("canvas").width = width;
    if (atomArray === undefined)
        return;
    selectGoodScalar();
    drawAtoms();
}


/*
 * * * * * * * * * * Dynamics (MM2) stuff * * * * * * * * * * *
 */
// http://en.wikipedia.org/wiki/Force_field_(chemistry)
// http://en.wikipedia.org/wiki/Verlet_integration

var lengthtermCoefficients = {
    "C:SP3:C:SP3": {k:4.400, r:1.523},
    "C:SP3:C:SP2": {k:4.400, r:1.497},
    "C:SP3:C:SP": {k:5.200, r:1.470},
    "C:SP3:H:NONE": {k:4.600, r:1.113},
    "C:SP3:O:SP3": {k:5.360, r:1.402},
    "C:SP3:N:SP3": {k:5.100, r:1.438},
    "C:SP3:N:SP2": {k:3.520, r:1.437},
    "C:SP3:N:SP3": {k:5.100, r:1.499},
    "C:SP3:O:SP2": {k:5.360, r:1.414},
    "C:SP2:C:SP2": {k:9.600, r:1.337},
    "C:SP2:C:SP": {k:9.900, r:1.313},
    "C:SP2:H:NONE": {k:4.600, r:1.101},
    "C:SP2:O:SP3": {k:6.000, r:1.355},
    "C:SP2:N:SP3": {k:6.320, r:1.377},
    "C:SP2:N:SP2": {k:5.000, r:1.410},
    "C:SP2:O:SP2": {k:10.000, r:1.225},
    "C:SP:C:SP": {k:15.600, r:1.212},
    "C:SP:H:NONE": {k:5.900, r:1.090},
    "C:SP:N:SP": {k:17.730, r:1.158},
    "O:SP3:O:SP3": {k:3.950, r:1.428},
    "N:SP3:N:SP3": {k:5.600, r:1.381},
    "N:SP3:H:NONE": {k:6.100, r:1.045}
};

var lengthtermPrototype = {
    toString: function() {
        return ("(lengthterm " + this._atom1.toString() + " " +
                this._atom2.toString() + " " + this._k + " " + this._r + ")");
    },
    computeForces: function() {
        // for the moment let's just use a linear spring force
        var x = this._atom2.getPosition().subtract(this._atom1.getPosition());
        var force = this._k * (this._r - x.length());
        var df = x.scale(force / x.length());
        this._atom2.addForce(df);
        this._atom1.addForce(df.scale(-1));
    },
    init: function(atom1,atom2) {
        this._atom1 = atom1;
        this._atom2 = atom2;
        var sym1 = atom1.getSymbol();
        var hyb1 = atom1.getHybridizationString();
        var sym2 = atom2.getSymbol();
        var hyb2 = atom2.getHybridizationString();
        var key = sym1 + ":" + hyb1 + ":" + sym2 + ":" + hyb2;
        var coeffs = lengthtermCoefficients[key];
        if (coeffs === undefined)
            coeffs = lengthtermCoefficients["C:SP3:H:NONE"];
        this._k = coeffs.k;
        this._r = coeffs.r;
    }
};

function LengthTerm(atom1,atom2) {
    function lt() { }
    lt.prototype = lengthtermPrototype;
    var t = new lt();
    t.init(atom1, atom2);
    return t;
}

/*
 * * * * * * * * * * * * * * STRUCTURE * * * * * * * * * * * * * *
 * TESTS
 * // var p = Propane();
 * // var mm2 = JigImpl.getJig(p, "net.willware.eurydice.forcefields.mm2.MM2");
 * // mm2.computeForces();
 * // var lst = p.getAtomList();
 + // for (var i = 0; i < lst.size(); i++) print(lst.get(i).getForce());
 - // for (var i in lst) print(lst[i].getForce());
 */
