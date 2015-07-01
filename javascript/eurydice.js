/*
 * * * * * * * * * * * * * * PRELIMINARIES * * * * * * * * * * * * * *
 */

var pixelAtomHash;  // keyed by coarse (x,y) screen location
var atomBuckets;   // may NOT be an ivar of structure
var orientation;   // must become an ivar of structure
var hydrogenCovalentRadius = 0.3e-10;  // angstroms

var stepsBetweenRedraws = 10;
var timeStep = 0.2e-15;
var verletDelay = 1000;

// The atomBuckets data structure helps to speed up bond inference. For very large
// structures, an octree might do better, but this will do for now.
var BUCKET_LINEAR_DIMENSION = 3e-10;

// a hook to permit modifying redrawing behavior
// var redrawPreamble;

var dynamicsPaused = false;
var damping = false;

/*
 * Fundamental units:
 * Times are in seconds
 * Distances are in meters
 * Masses are in kilograms
 *
 * Derived units:
 * Energy is in joules (1 aJ = 1.0e-18 joules).
 * Force is in units of newtons.
 * Spring constants have units of newtons per meter.
 */
var BoltzmannsConstant = 1.3806488e-23;

function toString(obj) {
    var str;
    try {
        return obj._toString();
    }
    catch (e) { }
    if ((typeof obj) === 'string')
        // TODO: escape all internal double-quotes with backslashes
        return '"' + obj + '"';
    if (obj instanceof Array) {
        str = "[";
        var first = true;
        for (var i in obj) {
            if (first) {
                first = false;
            } else {
                str += ",";
            }
            var x = "" + toString(obj[i]);
            str += x;
        }
        return str + "]";
    }
    if (obj instanceof Object) {
        str = "{";
        var first = true;
        for (key in obj) {
            if (first) {
                first = false;
            } else {
                str += ",";
            }
            var x = toString(key);
            var y = toString(obj[key]);
            str += x + ":" + y;
        }
        return str + "}";
    }
    try {
        return '' + obj;
    }
    catch (e) { }
    return "" + obj;
}

function extend(base,additional) {
    var r = { };
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
    _toString: function() {
        return "(" + this.x + " " + this.y + " " + this.z + ")";
    },
    copy: function(other) {
        return Vector(this.x, this.y, this.z);
    },
    add: function(other) {
        return Vector(this.x + other.x,
                      this.y + other.y,
                      this.z + other.z);
    },
    subtract: function(other) {
        return Vector(this.x - other.x,
                      this.y - other.y,
                      this.z - other.z);
    },
    negate: function() {
        return Vector(-this.x, -this.y, -this.z);
    },
    scale: function(factor) {
        return Vector(this.x * factor,
                      this.y * factor,
                      this.z * factor);
    },
    normalize: function(factor) {
        return this.scale(1.0 / this.length());
    },
    dotProduct: function(other) {
        return this.x * other.x +
        this.y * other.y +
        this.z * other.z;
    },
    crossProduct: function(other) {
        return Vector(this.y * other.z - other.y * this.z,
                      this.z * other.x - other.z * this.x,
                      this.x * other.y - other.x * this.y);
    },
    multiplyQuaternion: function(other) {
        return Quaternion(0.0, this).multiply(other);
    },
    distsq: function(other) {
        var dx = this.x - other.x;
        var dy = this.y - other.y;
        var dz = this.z - other.z;
        return dx * dx + dy * dy + dz * dz;
    },
    lensq: function() {
        var x = this.x;
        var y = this.y;
        var z = this.z;
        return x * x + y * y + z * z;
    },
    length: function() {
        return Math.sqrt(this.lensq());
    }
};

function vectorConstructor() { }
vectorConstructor.prototype = vectorPrototype;

function Vector(x,y,z) {
    inst = new vectorConstructor();
    inst.x = x;
    inst.y = y;
    inst.z = z;
    return inst;
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
    _toString: function() {
        return "(Quat " + this.getReal() + " " + this.getImaginary() + ")";
    },
    add: function(other) {
        return Quaternion(this.getReal() + other.getReal(),
                          this.getImaginary().add(other.getImaginary()));
    },
    subtract: function(other) {
        return Quaternion(this.getReal() - other.getReal(),
                          this.getImaginary()
                          .subtract(other.getImaginary()));
    },
    multiply: function(other) {
        var a = this.getReal();
        var im = this.getImaginary();
        var b = im.x, c = im.y, d = im.z;
        var e = other.getReal();
        im = other.getImaginary();
        var f = im.x, g = im.y, h = im.z;
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
        return Quaternion(this.getReal(), this.getImaginary().negate());
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
 * prettyClose(atom.getMass(), 12 * protonMass);
 * colorMatch(atom.getColor(), Color.getColor("gray30"));
 * prettyClose(atom.getCovalentRadius(), 0.77 * angstrom);
 * prettyClose(atom.getVdwEnergy(), 0.357 * attojoule);
 * prettyClose(atom.getVdwRadius(), 1.85 * angstrom);
 * atom.setHybridization(Atom.SP2);
 * prettyClose(atom.getCovalentRadius(), 0.67 * angstrom);
 * atom.setHybridization(Atom.SP);
 * prettyClose(atom.getCovalentRadius(), 0.6 * angstrom);
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
 * prettyClose(atom.getMass(), protonMass);
 * colorMatch(atom.getColor(), Color.getColor("white"));
 * prettyClose(atom.getCovalentRadius(), 0.3 * angstrom);
 * prettyClose(atom.getVdwEnergy(), 0.382 * attojoule);
 * prettyClose(atom.getVdwRadius(), 1.2 * angstrom);
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
 * prettyClose(atom.getMass(), 16 * protonMass);
 * colorMatch(atom.getColor(), Color.getColor("red"));
 * prettyClose(atom.getCovalentRadius(), 0.74 * angstrom);
 * prettyClose(atom.getVdwEnergy(), 0.406 * attojoule);
 * prettyClose(atom.getVdwRadius(), 1.4 * angstrom);
 * atom.setHybridization(Atom.SP2);
 * prettyClose(atom.getCovalentRadius(), 0.62 * angstrom);
 * prettyClose(atom.getVdwEnergy(), 0.536 * attojoule);
 * atom.setHybridization(Atom.SP);
 * prettyClose(atom.getCovalentRadius(), 0.55 * angstrom);
 * prettyClose(atom.getVdwEnergy(), 0.536 * attojoule);
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
 * prettyClose(atom.getMass(), 14 * protonMass);
 * colorMatch(atom.getColor(), Color.getColor("blue"));
 * prettyClose(atom.getCovalentRadius(), 0.74 * angstrom);  // IDENTICAL to oxygen???
 * prettyClose(atom.getVdwEnergy(), 0.447 * attojoule);
 * prettyClose(atom.getVdwRadius(), 1.5 * angstrom);
 * atom.setHybridization(Atom.SP2);
 * prettyClose(atom.getCovalentRadius(), 0.62 * angstrom); // ? ?
 * atom.setHybridization(Atom.SP);
 * prettyClose(atom.getCovalentRadius(), 0.55 * angstrom); // ? ?
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
        _toString: function() {
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
    if ("Black" === colorname || "black" === colorname)
        return Color(0, 0, 0);
    else if ("Gray10" === colorname || "gray10" === colorname)
        return Color(26, 26, 26);
    else if ("Gray20" === colorname || "gray20" === colorname)
        return Color(51, 51, 51);
    else if ("Gray30" === colorname || "gray30" === colorname)
        return Color(77, 77, 77);
    else if ("Gray40" === colorname || "gray40" === colorname)
        return Color(102, 102, 102);
    else if ("Gray50" === colorname || "gray50" === colorname)
        return Color(128, 128, 128);
    else if ("Gray60" === colorname || "gray60" === colorname)
        return Color(154, 154, 154);
    else if ("Gray70" === colorname || "gray70" === colorname)
        return Color(179, 179, 179);
    else if ("Gray80" === colorname || "gray80" === colorname)
        return Color(204, 204, 204);
    else if ("Gray90" === colorname || "gray90" === colorname)
        return Color(230, 230, 230);
    else if ("White" === colorname || "white" === colorname)
        return Color(255, 255, 255);

    else if ("Red" === colorname || "red" === colorname)
        return Color(255, 0, 0);
    else if ("Green" === colorname || "green" === colorname)
        return Color(0, 255, 0);
    else if ("Blue" === colorname || "blue" === colorname)
        return Color(0, 0, 255);
    else if ("Cyan" === colorname || "cyan" === colorname)
        return Color(0, 255, 255);
    else if ("Magenta" === colorname || "magenta" === colorname)
        return Color(255, 0, 255);
    else if ("Yellow" === colorname || "yellow" === colorname)
        return Color(255, 255, 0);

    else if ("Orange" === colorname || "orange" === colorname)
        return Color(255, 132, 0);
    else if ("Purple" === colorname || "purple" === colorname)
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

    _toString: function() {
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
        if (this._force === undefined)
            this._force = v;
        else {
            this._force.x += v.x;
            this._force.y += v.y;
            this._force.z += v.z;
        }
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

    verletStep: function(dt, dampingCoeff) {
        // http://en.wikipedia.org/wiki/Verlet_integration
        var pos = this._position, prev = this._previous;
        // dampingCoeff negative: colder, positive: hotter
        var x = pos.x + (1.0 + dampingCoeff) * (pos.x - prev.x);
        var y = pos.y + (1.0 + dampingCoeff) * (pos.y - prev.y);
        var z = pos.z + (1.0 + dampingCoeff) * (pos.z - prev.z);
        var a = dt * dt / this.getMass();
        var f = this._force;
        this._position = Vector(x + a * f.x,
                                y + a * f.y,
                                z + a * f.z);
        this._previous = pos;
    },

    kineticEnergy: function(dt) {
        var pos = this._position, prev = this._previous;
        var dx = pos.x - prev.x;
        var dy = pos.y - prev.y;
        var dz = pos.z - prev.z;
        return 0.5 * this.getMass() * (dx*dx + dy*dy + dz*dz) / (dt*dt);
    },

    getNeighbors: function() {
        // return an array of atoms bonded directly to this guy
        var neighbors = [ ];
        var bondLengthTolerance = 0.4e-10;
        var covR = this.getCovalentRadius();
        var xi = Math.floor(this._position.x / BUCKET_LINEAR_DIMENSION);
        var yi = Math.floor(this._position.y / BUCKET_LINEAR_DIMENSION);
        var zi = Math.floor(this._position.z / BUCKET_LINEAR_DIMENSION);
        for (var x = xi - 1; x <= xi + 1; x++)
            for (var y = yi - 1; y <= yi + 1; y++)
                for (var z = zi - 1; z <= zi + 1; z++) {
                    var bucket = atomBuckets[x + ":" + y + ":" + z];
                    if (bucket !== null && bucket !== undefined) {
                        for (var i in bucket) {
                            var a2 = bucket[i];
                            var dx = a2._position
                                .subtract(this._position).length();
                            if (a2 !== this &&
                                dx < covR + a2.getCovalentRadius()
                                + bondLengthTolerance) {
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
        var x = K * pos.x + w/2;
        var y = K * pos.y + h/2;
        var z = pos.z;
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

var carbonPrototype = extend(atomPrototype, {
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
            // 12 * proton mass, in kilograms
            return 2.0071458959999998e-26;
        },

        getColor: function() {
            return Color.getColor("gray30");
        },

        getCovalentRadius: function() {
            if (this._h === Atom.SP2)
                return 0.67e-10;
            if (this._h === Atom.SP)
                return 0.6e-10;
            return 0.77e-10;
        },

        getVdwEnergy: function() {
            return 0.357e-21;
        },

        getVdwRadius: function() {
            return 1.85e-10;
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
                // 1 * proton mass
                return 1.67262158e-27;
            },
            getColor: function() {
                return Color.getColor("white");
            },
            getCovalentRadius: function() {
                return hydrogenCovalentRadius;
            },
            getVdwEnergy: function() {
                return 0.382e-21;
            },
            getVdwRadius: function() {
                return 1.2e-10;
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
                // 16 * proton mass
                return 2.676194528e-26;
            },
            getColor: function() {
                return Color.getColor("red");
            },
            getCovalentRadius: function() {
                if (this._h === Atom.SP2)
                    return 0.62e-10;
                if (this._h === Atom.SP)
                    return 0.55e-10;
                return 0.74e-10;
            },
            getVdwEnergy: function() {
                if (this._h === Atom.SP2 || this._h === Atom.SP)
                    return 0.536e-21;
                return 0.406e-21;
            },
            getVdwRadius: function() {
                return 1.4e-10;
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
                // 14 * proton mass
                return 2.341670212e-26;
            },
            getColor: function() {
                return Color.getColor("blue");
            },
            getCovalentRadius: function() {
                // IDENTICAL to oxygen? is that right???
                if (this._h === Atom.SP2)
                    return 0.62e-10;
                if (this._h === Atom.SP)
                    return 0.55e-10;
                return 0.74e-10;
            },
            getVdwEnergy: function() {
                return 0.447e-21;
            },
            getVdwRadius: function() {
                return 1.5e-10;
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
                // 19 * proton mass
                return 3.177981002e-26;
            },
            getColor: function() {
                return Color.getColor("green");
            },
            getCovalentRadius: function() {
                return 0.6e-10;
            },
            getVdwEnergy: function() {
                return 0.447e-21;  // TODO - correct value
            },
            getVdwRadius: function() {
                return 1.47e-10;
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
                // 32.065 * proton mass
                return 5.36326109627e-26;
            },
            getColor: function() {
                return Color.getColor("yellow");
            },
            getCovalentRadius: function() {
                return 1.05e-10;
            },
            getVdwEnergy: function() {
                return 0.447e-21;  // TODO - correct value?
            },
            getVdwRadius: function() {
                return 1.8e-10;
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
                // 28.0855 * proton mass
                return 4.697641338509e-26;
            },
            getColor: function() {
                return Color.getColor("Gray70");
            },
            getCovalentRadius: function() {
                return 1.11e-10;
            },
            getVdwEnergy: function() {
                return 0.447e-21; // TODO - correct value?
            },
            getVdwRadius: function() {
                return 2.1e-10;
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
                // 35.543 * proton mass
                return 5.944998881794e-26;
            },
            getColor: function() {
                return Color.getColor("orange");
            },
            getCovalentRadius: function() {
                return 1.02e-10;
            },
            getVdwEnergy: function() {
                return 0.447e-21;  // TODO - correct value
            },
            getVdwRadius: function() {
                return 1.75e-10;
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
                // 30.97 * proton mass
                return 5.18010903326e-26;
            },
            getColor: function() {
                return Color.getColor("purple");
            },
            getCovalentRadius: function() {
                return 1.07e-10;
            },
            getVdwEnergy: function() {
                return 0.447e-21;  // TODO - correct value
            },
            getVdwRadius: function() {
                return 1.8e-10;
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
 * * * * * * * * * * ORIENTATION * * * * * * * * * * *
 */

var orientationPrototype = {
    _toString: function() {
        return "(orientation " + this.quat._toString() + ")";
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
        this.P = perspectiveDistance / (perspectiveDistance - vec.z);
        return Vector(this.P * vec.x, this.P * vec.y, vec.z);
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

/*
 * * * * * * * * * * * * * * STRUCTURE * * * * * * * * * * * * * *
 */

function Structure() {
    function structureConstructor() { }
    structureConstructor.prototype = {
        init: function() {
            this.atomArray;
            this.rotArray;  // used for pretty drawing when mouse is up,
                            // reused for tooltip
            this.bondsByAtom = { };  // bidirectional hashmap:
                                     // atom -> [atom, atom, atom...]
            this.termList = [ ];
            this.temperature = 0.0;   // in degrees Kelvin
            this.targetTemperature = 0.0;   // in degrees Kelvin
            this.termListOutdated = true;
            this.largestIdThusfar = 0;
            this.scalar = 1.0;
        },

        _toString: function() {
            return "(structure)";
        },

        // the array is a list of lists, each inner list is four things
        // [["C", 2.430, 2.038, -1.932],
        //  ["C", 0.947, 2.377, -1.909],
        //  ["C", 2.602, 0.523, -1.966]...]
        // Given such a list, we 
        buildFromArray: function(struc) {
            this.largestIdThusfar = 0;
            this.atomArray = { };
            var atom, id;
            var b = 1.0e-10;  // convert angstroms to meters
            for (var i in struc) {
                var a = struc[i];
                switch (a[0]) {
                    case "C":
                        atom = Carbon();
                        break;
                    case "H":
                        atom = Hydrogen();
                        break;
                    case "O":
                        atom = Oxygen();
                        break;
                    case "N":
                        atom = Nitrogen();
                        break;
                    case "S":
                        atom = Sulfur();
                        break;
                    case "F":
                        atom = Fluorine();
                        break;
                    case "Si":
                        atom = Silicon();
                        break;
                    case "Cl":
                        atom = Chlorine();
                        break;
                    case "P":
                        atom = Phosphorus();
                        break;
                }
                atom.setPosition(Vector(a[1]*b, a[2]*b, a[3]*b));
                id = ++this.largestIdThusfar;
                atom.setUniqueId(id);
                this.atomArray[id] = atom;
            }
            this.recenterAtoms();
            this.buildBondInfo();
            // fix hybridization
            for (var i in this.atomArray) {
                var atom = this.atomArray[i];
                if (atom.getSymbol() !== "H") {
                    var bondDeficit = atom.getCorrectNumBonds()
                        - atom.getNeighbors().length;
                    switch (bondDeficit) {
                        default:
                        case 0:
                            atom.setHybridization(Atom.SP3);
                            break;
                        case 1:
                            atom.setHybridization(Atom.SP2);
                            break;
                        case 2:
                            atom.setHybridization(Atom.SP);
                            break;
                    }
                }
            }
            this.orientation = Orientation();
            this.termListOutdated = true;;
            this.drawAtoms();
        },

        buildBondInfo: function() {
            this.bondsByAtom = { };
            atomBuckets = { };
            for (var i in this.atomArray) {
                // add the atom to the appropriate bucket
                var pos = this.atomArray[i].getPosition();
                var xi = Math.floor(pos.x / BUCKET_LINEAR_DIMENSION);
                var yi = Math.floor(pos.y / BUCKET_LINEAR_DIMENSION);
                var zi = Math.floor(pos.z / BUCKET_LINEAR_DIMENSION);
                var key = xi + ":" + yi + ":" + zi;
                if (atomBuckets[key] === undefined)
                    atomBuckets[key] = [ ];
                atomBuckets[key].push(this.atomArray[i]);
            }
            for (var i in this.atomArray) {
                var atom = this.atomArray[i];
                this.bondsByAtom[atom.getUniqueId()] = atom.getNeighbors();
            }
        },

        recenterAtoms: function() {
            var centerOfGravity = Vector(0.0, 0.0, 0.0);
            var numAtoms = 0;
            for (var i in this.atomArray) {
                numAtoms++;
                centerOfGravity =
                    centerOfGravity.add(this.atomArray[i].getPosition());
            }
            centerOfGravity = centerOfGravity.scale(1.0 / numAtoms);
            for (var i in this.atomArray) {
                this.atomArray[i]
                    .setPosition(this.atomArray[i]
                                 .getPosition().subtract(centerOfGravity));
                var previous = this.atomArray[i].getPreviousPosition();
                if (previous === undefined)
                    this.atomArray[i]
                        .setPreviousPosition(this.atomArray[i]
                                             .getPosition());
                else
                    this.atomArray[i]
                        .setPreviousPosition(previous
                                             .subtract(centerOfGravity));
            }
        },

        deleteBondsFor: function(atom) {
            var buddies = this.bondsByAtom[atom.getUniqueId()];
            delete this.bondsByAtom[atom.getUniqueId()];
            for (var i in buddies) {
                var buddy = buddies[i];
                var hisBuddies = this.bondsByAtom[buddy.getUniqueId()];
                var n = hisBuddies.indexOf(atom);
                hisBuddies.splice(n, 1);
                this.bondsByAtom[buddy.getUniqueId()] = hisBuddies;
            }
            return buddies;
        },

        addAtomConnectedToExisting: function(atom,existing) {
            atom.setUniqueId(++this.largestIdThusfar);
            this.atomArray[atom.getUniqueId()] = atom;
            this.bondsByAtom[atom.getUniqueId()] = [ existing ];
            this.bondsByAtom[existing.getUniqueId()].push(atom);
        },

        removeAtom: function(atom) {
            if (atom.getSymbol() === "H") {
                return;
            }
            // update this.atomArray with deletion of chosen atom
            var neighborhood = deleteBondsFor(atom);
            delete this.atomArray[atom.getUniqueId()];
            // each surviving neighbor gets a hydrogen to terminate
            for (var i in neighborhood) {
                var neighbor = neighborhood[i];
                if (neighbor.getSymbol() === "H") {
                    // unless it's hydrogen, then kill it
                    deleteBondsFor(neighbor);
                    delete this.atomArray[neighbor.getUniqueId()];
                } else {
                    var direction =
                        atom.getPosition().subtract(neighbor.getPosition());
                    var distance =
                        neighbor.getCovalentRadius() +
                        hydrogenCovalentRadius;
                    direction =
                        direction.scale(distance / direction.length());
                    var h = Hydrogen();
                    h.setPosition(neighbor.getPosition().add(direction));
                    addAtomConnectedToExisting(h, neighbor);
                }
            }
        },

        replaceTwoHydrogensWithABond: function(h1,h2) {
            if (h1 === undefined || h1.getSymbol() !== "H" ||
                h2 === undefined || h2.getSymbol() !== "H") {
                return;
            }
            var other1 = deleteBondsFor(h1)[0];
            delete this.atomArray[h1.getUniqueId()];
            var other2 = deleteBondsFor(h2)[0];
            delete this.atomArray[h2.getUniqueId()];
            this.bondsByAtom[other1.getUniqueId()].push(other2);
            this.bondsByAtom[other2.getUniqueId()].push(other1);
            this.termListOutdated = true;
        },

        addAtom: function(oldH,symbol) {
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
            delete this.atomArray[oldH.getUniqueId()];
            // find correct position for new atom, add it
            var neighbor = neighborhood[0];
            var direction = (oldH.getPosition()
                             .subtract(neighbor.getPosition()));
            var distance = (neighbor.getCovalentRadius() +
                            newAtom.getCovalentRadius());
            direction = direction.scale(distance / direction.length());
            // u is a unit vector pointing from the existing neighbor
            // to the new atom
            var u = direction.scale(1.0 / direction.length());
            newAtom.setPosition(neighbor.getPosition().add(direction));
            addAtomConnectedToExisting(newAtom, neighbor);

            // are there any hydrogens that should be deleted so
            // their neighbors can be connected to the new atom?
            var otherHs = newAtom.getNeighbors().filter(
                function(x) {
                    return x !== neighbor && x.getSymbol() === "H";
                });
            var z;
            if (otherHs !== undefined) {
                for (var i in otherHs) {
                    var h = otherHs[i];
                    var hneighbors = deleteBondsFor(h);
                    if (hneighbors === undefined)
                        continue;
                    var hBuddy = hneighbors[0];
                    z = (hBuddy.getPosition()
                         .subtract(newAtom.getPosition()).crossProduct(u));
                    delete this.atomArray[h.getUniqueId()];
                    this.bondsByAtom[newAtom.getUniqueId()].push(hBuddy);
                    this.bondsByAtom[hBuddy.getUniqueId()].push(newAtom);
                    hydrogensNeeded--;
                }
            }

            var sqrt2 = Math.sqrt(2);
            var sqrt3 = Math.sqrt(3);
            var sqrt6 = Math.sqrt(6);
            // compute how far the hydrogens are from the new atom
            var hdist = (newAtom.getCovalentRadius() +
                         hydrogenCovalentRadius);
            // z is a unit vector perpendicular to u
            if (z === undefined)
                z = u.crossProduct(Vector(-u.y, u.z, u.x));
            // z -> random direction
            z = z.scale(1.0 / z.length());
            // t is a unit vector perpendicular to both u and z
            var t = u.crossProduct(z);
            // It would be great to be able to display lone pairs.
            // These would be located where there would be unused
            // sigma bonds, e.g. SP3 nitrogen has tetrahedral
            // geometry but only three bonds.
            if (geometry === LINEAR_GEOMETRY) {
                // It would be great to be able to display pi orbitals. They
                // would go at t.scale(K).add(newAtom.getPosition()) and
                // z.scale(K).add(newAtom.getPosition()) and
                // t.scale(K).add(newAtom.getPosition()) and
                // z.scale(-K).add(newAtom.getPosition()),
                // for some distance K.
                if (hydrogensNeeded === 1) {
                    var newH = Hydrogen();
                    newH.setPosition(u.scale(hdist)
                                     .add(newAtom.getPosition()));
                    addAtomConnectedToExisting(newH, newAtom);
                }
            } else if (geometry === TRIGONAL_GEOMETRY) {
                // It would be great to be able to display pi orbitals. They
                // would go at t.scale(K).add(newAtom.getPosition()) and
                // t.scale(-K).add(newAtom.getPosition()),
                // for some distance K.
                if (hydrogensNeeded >= 1) {
                    var x = u.scale(0.5).add(z.scale(sqrt3/2));
                    var newH = Hydrogen();
                    newH.setPosition(x.scale(hdist)
                                     .add(newAtom.getPosition()));
                    addAtomConnectedToExisting(newH, newAtom);
                }
                if (hydrogensNeeded === 2) {
                    var y = u.scale(0.5).add(z.scale(-sqrt3/2));
                    var newH = Hydrogen();
                    newH.setPosition(y.scale(hdist)
                                     .add(newAtom.getPosition()));
                    addAtomConnectedToExisting(newH, newAtom);
                }
            } else if (geometry === TETRAHEDRAL_GEOMETRY) {
                var w = u.scale(1.0/3).add(z.scale(2*sqrt2/3));
                // tperp is the contributions of u and z to the positions of the
                // second and third hydrogens
                var tperp = u.scale(1.0/3).add(z.scale(-sqrt2/3));
                if (hydrogensNeeded >= 1) {
                    var newH = Hydrogen();
                    newH.setPosition(w.scale(hdist)
                                     .add(newAtom.getPosition()));
                    addAtomConnectedToExisting(newH, newAtom);
                }
                if (hydrogensNeeded >= 2) {
                    var t1 = tperp.add(t.scale(sqrt6/3));
                    var newH = Hydrogen();
                    newH.setPosition(t1.scale(hdist)
                                     .add(newAtom.getPosition()));
                    addAtomConnectedToExisting(newH, newAtom);
                }
                if (hydrogensNeeded === 3) {
                    var t2 = tperp.add(t.scale(-sqrt6/3));
                    var newH = Hydrogen();
                    newH.setPosition(t2.scale(hdist)
                                     .add(newAtom.getPosition()));
                    addAtomConnectedToExisting(newH, newAtom);
                }
            }

            atomBuckets = { };
            for (var i in this.atomArray) {
                // add the atom to the appropriate bucket
                var pos = this.atomArray[i].getPosition();
                var xi = Math.floor(pos.x / BUCKET_LINEAR_DIMENSION);
                var yi = Math.floor(pos.y / BUCKET_LINEAR_DIMENSION);
                var zi = Math.floor(pos.z / BUCKET_LINEAR_DIMENSION);
                var key = xi + ":" + yi + ":" + zi;
                if (!(key in atomBuckets))
                    atomBuckets[key] = [ ];
                atomBuckets[key].push(this.atomArray[i]);
            }
        },

        selectGoodScalar: function() {
            var xmin = 1.0e20;
            var ymin = 1.0e20;
            var zmin = 1.0e20;
            var xmax = -1.0e20;
            var ymax = -1.0e20;
            var zmax = -1.0e20;
            for (var i in this.atomArray) {
                var pos = this.atomArray[i].getPosition();
                var x = pos.x;
                var y = pos.y;
                var z = pos.z;
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
            if (maxDimension < 5e-10) maxDimension = 5e-10;
            this.scalar = 1.0 / maxDimension;
        },

        reorientAtom: function(atom) {
            var newpos = (this.orientation
                          .transform(atom.getPosition().scale(this.scalar)));
            var r = (0.9 * this.scalar
                     * this.orientation.P * atom.getCovalentRadius());
            function atomConstructor() { };
            atomConstructor.prototype = atom.getPrototype();
            var a = new atomConstructor();
            a.setPosition(newpos);
            a.getCovalentRadius = function() {
                return r;
            };
            a.original = atom;
            return a;
        },

        drawAtoms: function() {
            this.selectGoodScalar();
            var canvas = document.getElementById("canvas");
            var context = canvas.getContext("2d");
            context.fillStyle = canvasBackgroundColor;
            context.fillRect(0, 0, canvas.width, canvas.height);
            this.rotArray = [ ];
            pixelAtomHash = { };
            for (var i in this.atomArray) {
                this.rotArray.push(this.reorientAtom(this.atomArray[i]));
            }
            this.rotArray.sort(function(atom1,atom2) {
                    if (atom1.getPosition().z > atom2.getPosition().z) {
                        return 1;
                    }
                    if (atom1.getPosition().z < atom2.getPosition().z) {
                        return -1;
                    }
                    return 0;
                });
            for (var i in this.rotArray) {
                this.rotArray[i].draw();
            }
        },

        quickdrawAtoms: function() {
            this.selectGoodScalar();
            var canvas = document.getElementById("canvas");
            var context = canvas.getContext("2d");
            context.fillStyle = canvasBackgroundColor;
            context.fillRect(0, 0, canvas.width, canvas.height);
            this.rotArray = [ ];
            for (var i in this.atomArray) {
                var ratom = this.reorientAtom(this.atomArray[i]);
                this.atomArray[i].rotated = ratom;
                this.rotArray.push(ratom);
            }
            var w = canvas.width;
            var h = canvas.height;
            var K = 0.8 * ((w < h) ? w : h);
            for (var i in this.rotArray) {
                var ratom = this.rotArray[i];
                var atom = ratom.original;
                var aid = atom.getUniqueId();
                var u = ratom.getPosition();
                var neighborList = this.bondsByAtom[atom.getUniqueId()];
                for (var j in neighborList) {
                    var atom2 = neighborList[j];
                    var a2id = atom2.getUniqueId();
                    if (aid < a2id) {
                        var v = atom2.rotated.getPosition();
                        // draw a line
                        // see http://diveintohtml5.org/canvas.html
                        // depth cue during quickdraw: darker lines for
                        // bonds closer to the user
                        if (u.z + v.z > 0.0)
                            context.strokeStyle = "#000";
                        else
                            context.strokeStyle = "#799";
                        context.beginPath();
                        context.moveTo(K * u.x + w/2, K * u.y + h/2);
                        context.lineTo(K * v.x + w/2, K * v.y + h/2);
                        context.stroke();
                    }
                }
            }
        },

        atomByScreenCoords: function(x,y) {
            var key = 4000 * Math.floor(x / 50) + Math.floor(y / 50);
            if (pixelAtomHash === undefined)
                pixelAtomHash = { };
            // find out if we are inside an atom
            var bucket = pixelAtomHash[key];
            if (bucket !== undefined) {
                var closestZ;  // most positive
                var found;
                for (i in bucket) {
                    var a = bucket[i];
                    if (a.containsMouse(x, y)) {
                        var depth = a.getScreenDepth();
                        if (found === undefined || depth > closestZ) {
                            found = a;
                            closestZ = depth;
                        }
                    }
                }
                if (found !== undefined) {
                    return found.original;
                }
            }
            return undefined;
        },

        enumerateTerms: function() {
            this.termList = [ ];
            // short range terms are relatively few in number
            // because they affect only atoms that are close in
            // the graph of chemical bonds
            for (var h in this.atomArray) {
                var atom1 = this.atomArray[h];
                var id1 = atom1.getUniqueId();
                for (var i in this.bondsByAtom[id1]) {
                    atom2 = this.bondsByAtom[id1][i];
                    if (atom2 === atom1)
                        continue;
                    var id2 = atom2.getUniqueId();
                    if (id2 > id1)
                        this.termList.push(makeLengthTerm(atom1, atom2));
                    for (var j in this.bondsByAtom[id2]) {
                        var atom3 = this.bondsByAtom[id2][j];
                        if (atom3 === atom1 || atom3 === atom2)
                            continue;
                        var id3 = atom3.getUniqueId();
                        if (id3 > id1)
                            this.termList
                                .push(makeAngleTerm(atom1, atom2, atom3));
                        for (var k in this.bondsByAtom[id3]) {
                            var atom4 = this.bondsByAtom[id3][k];
                            if (atom4 === atom1 || atom4 === atom2
                                || atom4 === atom3)
                                continue;
                            var id4 = atom4.getUniqueId();
                            if (id4 > id1)
                                this.termList
                                    .push(makeTorsionTerm(atom1, atom2,
                                                          atom3, atom4));
                        }
                    }
                }
            }

            // long range terms are more numerous
            var exclusions = { };
            for (var h in this.atomArray) {
                var atom1 = this.atomArray[h];
                var id1 = atom1.getUniqueId();
                for (var i in this.bondsByAtom[id1]) {
                    atom2 = this.bondsByAtom[id1][i];
                    if (atom2 === atom1)
                        continue;
                    var id2 = atom2.getUniqueId();
                    exclusions['' + id1 + ':' + id2] = 1;
                    exclusions['' + id2 + ':' + id1] = 1;
                    for (var j in this.bondsByAtom[id2]) {
                        var atom3 = this.bondsByAtom[id2][j];
                        if (atom3 === atom1 || atom3 === atom2)
                            continue;
                        var id3 = atom3.getUniqueId();
                        exclusions['' + id1 + ':' + id3] = 1;
                        exclusions['' + id3 + ':' + id1] = 1;
                        for (var k in this.bondsByAtom[id3]) {
                            var atom4 = this.bondsByAtom[id3][k];
                            if (atom4 === atom1 || atom4 === atom2
                                || atom4 === atom3)
                                continue;
                            var id4 = atom4.getUniqueId();
                            exclusions['' + id1 + ':' + id4] = 1;
                            exclusions['' + id4 + ':' + id1] = 1;
                        }
                    }
                }
            }
            for (var i in this.atomArray) {
                var atom1 = this.atomArray[i];
                for (var j in this.atomArray) {
                    var atom2 = this.atomArray[j];
                    if (atom2.getUniqueId() > atom1.getUniqueId() &&
                        exclusions[i + ':' + j] === undefined) {
                        this.termList.push(makeLongRangeTerm(atom1, atom2));
                    }
                }
            }
        },

        countAtoms: function() {
            var numAtoms = 0;
            for (var i in this.atomArray)
                numAtoms++;
            return numAtoms;
        },

        outdateTermList: function() {
            this.termListOutdated = true;
        },

        verletStep: function(dt) {
            if (this.termListOutdated && this.countAtoms() < 200) {
                this.termListOutdated = false;
                this.enumerateTerms();
            }
            var numAtoms = 0;
            var etotal = 0.0;
            for (var i in this.atomArray) {
                etotal += this.atomArray[i].kineticEnergy(dt);
                numAtoms++;
            }
            if (numAtoms === 0)
                return;
            etotal /= numAtoms;
            this.temperature = (2.0/3.0) * (etotal / BoltzmannsConstant);
            if (this.temperatureUpdate !== undefined)
                this.temperatureUpdate(this.temperature);
            var dampingCoeff;
            if (this.targetTemperature > this.temperature)
                dampingCoeff = 0.001;
            else
                dampingCoeff = -0.001;
            for (var j = 0; j < stepsBetweenRedraws; j++) {
                for (var i in this.atomArray) {
                    this.atomArray[i].zeroForce();
                }
                for (var i in this.termList) {
                    this.termList[i]();
                }
                var first = true;
                for (var i in this.atomArray) {
                    this.atomArray[i].verletStep(dt, dampingCoeff);
                }
            }
        }
    };

    var s = new structureConstructor();
    s.init();
    return s;
}

/*
 * * * * * * * * * * Dynamics (MM2) stuff * * * * * * * * * * *
 */
// http://en.wikipedia.org/wiki/Force_field_(chemistry)
// http://en.wikipedia.org/wiki/Verlet_integration
// k here in units of newtons per meter
// r is in units of angstroms

var lengthtermCoefficients = {
    "C:SP3:C:SP3": {k:440.0, r:1.523e-10},
    "C:SP3:C:SP2": {k:440.0, r:1.497e-10},
    "C:SP3:C:SP": {k:520.0, r:1.470e-10},
    "C:SP3:H:NONE": {k:460.0, r:1.113e-10},
    "C:SP3:O:SP3": {k:536.0, r:1.402e-10},
    "C:SP3:N:SP3": {k:510.0, r:1.438e-10},
    "C:SP3:N:SP2": {k:352.0, r:1.437e-10},
    "C:SP3:N:SP3": {k:510.0, r:1.499e-10},
    "C:SP3:O:SP2": {k:536.0, r:1.414e-10},
    "C:SP2:C:SP2": {k:960.0, r:1.337e-10},
    "C:SP2:C:SP": {k:990.0, r:1.313e-10},
    "C:SP2:H:NONE": {k:460.0, r:1.101e-10},
    "C:SP2:O:SP3": {k:600.0, r:1.355e-10},
    "C:SP2:N:SP3": {k:632.0, r:1.377e-10},
    "C:SP2:N:SP2": {k:500.0, r:1.410e-10},
    "C:SP2:O:SP2": {k:1000.0, r:1.225e-10},
    "C:SP:C:SP": {k:1560.0, r:1.212e-10},
    "C:SP:H:NONE": {k:590.0, r:1.090e-10},
    "C:SP:N:SP": {k:1773.0, r:1.158e-10},
    "O:SP3:O:SP3": {k:395.0, r:1.428e-10},
    "N:SP3:N:SP3": {k:560.0, r:1.381e-10},
    "N:SP3:H:NONE": {k:610.0, r:1.04e-105}
};

function makeLengthTerm(atom1,atom2) {
    var sym1 = atom1.getSymbol();
    var hyb1 = atom1.getHybridizationString();
    var sym2 = atom2.getSymbol();
    var hyb2 = atom2.getHybridizationString();
    var key = sym1 + ":" + hyb1 + ":" + sym2 + ":" + hyb2;
    var coeffs = lengthtermCoefficients[key];
    if (coeffs === undefined) {
        key = sym2 + ":" + hyb2 + ":" + sym1 + ":" + hyb1;
        coeffs = lengthtermCoefficients[key];
    }
    var k, r;
    if (coeffs !== undefined) {
        k = coeffs['k'];
        r = coeffs['r'];
    } else {
        k = 400;   // something kinda typical
        r = atom1.getCovalentRadius() + atom2.getCovalentRadius();
    }
    return function() {
        // for the moment let's just use a linear spring force
        var x = atom2.getPosition().subtract(atom1.getPosition());
        var force = k * (r - x.length());
        var df = x.scale(force / x.length());
        atom2.addForce(df);
        atom1.addForce(df.negate());
    };
}

// kth is in units of attojoules per square radian
// th0 is in units of degrees
var angletermCoefficients = {
    "C:SP3:C:SP3:C:SP3": {kth:0.450, th0:109.470},
    "C:SP3:C:SP3:C:SP2": {kth:0.450, th0:109.470},
    "C:SP3:C:SP3:C:SP": {kth:0.450, th0:109.470},
    "C:SP3:C:SP3:H:NONE": {kth:0.360, th0:109.390},
    "C:SP3:C:SP3:O:SP3": {kth:0.700, th0:107.500},
    "C:SP3:C:SP3:N:SP3": {kth:0.570, th0:109.470},
    "C:SP3:C:SP3:N:SP2": {kth:0.500, th0:109.280},
    "C:SP3:C:SP3:N:SP3": {kth:0.570, th0:103.500},
    "C:SP3:C:SP3:O:SP2": {kth:0.700, th0:107.500},
    "C:SP2:C:SP3:C:SP2": {kth:0.450, th0:109.470},
    "C:SP2:C:SP3:C:SP": {kth:0.470, th0:109.470},
    "C:SP2:C:SP3:H:NONE": {kth:0.360, th0:109.390},
    "C:SP2:C:SP3:O:SP3": {kth:0.700, th0:109.500},
    "C:SP2:C:SP3:N:SP3": {kth:1.045, th0:110.740},
    "C:SP2:C:SP3:N:SP2": {kth:0.500, th0:109.800},
    "C:SP2:C:SP3:N:SP3": {kth:1.045, th0:110.740},
    "C:SP:C:SP3:C:SP": {kth:0.470, th0:109.470},
    "C:SP:C:SP3:H:NONE": {kth:0.360, th0:109.390},
    "H:NONE:C:SP3:H:NONE": {kth:0.320, th0:109.400},
    "H:NONE:C:SP3:O:SP3": {kth:0.540, th0:106.700},
    "H:NONE:C:SP3:N:SP3": {kth:0.500, th0:108.800},
    "H:NONE:C:SP3:N:SP2": {kth:0.420, th0:109.000},
    "H:NONE:C:SP3:N:SP3": {kth:0.500, th0:108.800},
    "H:NONE:C:SP3:O:SP2": {kth:0.540, th0:106.700},
    "O:SP3:C:SP3:O:SP3": {kth:0.460, th0:99.900},
    "N:SP3:C:SP3:N:SP3": {kth:1.045, th0:110.740},
    "N:SP3:C:SP3:N:SP3": {kth:1.045, th0:110.740},
    "C:SP3:C:SP2:C:SP3": {kth:0.450, th0:117.200},
    "C:SP3:C:SP2:C:SP2": {kth:0.550, th0:121.400},
    "C:SP3:C:SP2:C:SP": {kth:0.470, th0:122.000},
    "C:SP3:C:SP2:H:NONE": {kth:0.360, th0:118.200},
    "C:SP3:C:SP2:O:SP3": {kth:0.500, th0:120.000},
    "C:SP2:C:SP2:C:SP2": {kth:0.430, th0:120.000},
    "C:SP2:C:SP2:H:NONE": {kth:0.360, th0:120.000},
    "C:SP2:C:SP2:O:SP3": {kth:0.700, th0:124.300},
    "C:SP2:C:SP2:N:SP3": {kth:0.616, th0:123.000},
    "C:SP2:C:SP2:N:SP2": {kth:0.500, th0:118.000},
    "C:SP2:C:SP2:O:SP2": {kth:0.600, th0:120.000},
    "C:SP:C:SP2:H:NONE": {kth:0.360, th0:121.100},
    "H:NONE:C:SP2:H:NONE": {kth:0.320, th0:119.000},
    "H:NONE:C:SP2:O:SP3": {kth:0.540, th0:116.400},
    "H:NONE:C:SP2:N:SP3": {kth:0.540, th0:119.000},
    "H:NONE:C:SP2:N:SP2": {kth:0.300, th0:109.000},
    "H:NONE:C:SP2:O:SP2": {kth:0.450, th0:108.000},
    "N:SP2:C:SP2:N:SP2": {kth:0.400, th0:120.000},
    "C:SP3:C:SP:C:SP": {kth:0.200, th0:180.000},
    "C:SP3:C:SP:N:SP": {kth:0.325, th0:180.000},
    "C:SP2:C:SP:C:SP2": {kth:0.400, th0:180.000},
    "C:SP2:C:SP:C:SP": {kth:0.470, th0:180.000},
    "C:SP:C:SP:H:NONE": {kth:0.360, th0:180.000},
    "C:SP:C:SP:O:SP3": {kth:0.360, th0:180.000},
    "C:SP:C:SP:O:SP2": {kth:0.360, th0:180.000},
    "C:SP:C:SP:N:SP3": {kth:0.360, th0:180.000},
    "C:SP:C:SP:N:SP2": {kth:0.360, th0:180.000},
    "C:SP:C:SP:N:SP": {kth:0.360, th0:180.000},
    "C:SP3:O:SP3:C:SP3": {kth:0.770, th0:106.800},
    "C:SP3:O:SP3:C:SP2": {kth:0.770, th0:110.800},
    "C:SP3:O:SP3:O:SP3": {kth:0.635, th0:98.700},
    "C:SP3:N:SP3:C:SP3": {kth:0.630, th0:107.700},
    "C:SP3:N:SP3:C:SP2": {kth:0.698, th0:107.000},
    "C:SP3:N:SP3:N:SP3": {kth:0.740, th0:105.500},
    "C:SP3:N:SP2:C:SP3": {kth:0.760, th0:126.000},
    "C:SP3:N:SP2:C:SP2": {kth:0.630, th0:119.900},
    "C:SP2:N:SP2:C:SP2": {kth:0.400, th0:107.000},
    "C:SP3:N:SP3:C:SP3": {kth:0.630, th0:108.600},
    "C:SP3:N:SP3:H:NONE": {kth:0.500, th0:109.470},
    "H:NONE:N:SP3:H:NONE": {kth:0.500, th0:104.500},
    "C:SP3:O:SP2:C:SP2": {kth:0.770, th0:113.600},
    "C:SP2:O:SP2:C:SP2": {kth:0.870, th0:113.95},
};

function makeAngleTerm(atom1,atom2,atom3) {
    var sym1 = atom1.getSymbol();
    var hyb1 = atom1.getHybridizationString();
    var sym2 = atom2.getSymbol();
    var hyb2 = atom2.getHybridizationString();
    var sym3 = atom3.getSymbol();
    var hyb3 = atom3.getHybridizationString();
    var key = sym1 + ":" + hyb1 + ":" + sym2 + ":" + hyb2 + ":"
        + sym3 + ":" + hyb3;
    var coeffs = angletermCoefficients[key];
    var kth, th0;
    if (coeffs === undefined) {
        key = sym3 + ":" + hyb3 + ":" + sym2 + ":" + hyb2 + ":"
            + sym1 + ":" + hyb1;
        coeffs = angletermCoefficients[key];
    }
    if (coeffs === undefined) {
        kth = 0.4;  // hope this is reasonable
        th0 = 109.47 * Math.PI / 180.0;
    } else {
        kth = coeffs.kth;
        th0 = coeffs.th0 * Math.PI / 180.0;
    }
    kth *= 1.0e-18;  // get into system units
    function vderiv(theta) {   // first derivative of v w.r.t. theta
        var ksextic = 0.754e-18;
        var thdiff = theta - th0;
        var d2 = thdiff * thdiff;
        var d4 = d2 * d2;
        return kth * thdiff + 3 * ksextic * thdiff * d4;
    };
    return function() {
        var pos2 = atom2.getPosition();
        var x = atom1.getPosition().subtract(pos2);
        var y = atom3.getPosition().subtract(pos2);
        var yx = y.crossProduct(x);        
        var xlen = x.length();
        var ylen = y.length();
        var yxlen = yx.length();
        var theta = Math.acos(x.dotProduct(y) / (xlen * ylen));
        var vdot = vderiv(theta);
        var f1 = x.crossProduct(yx).scale(vdot / (yxlen * xlen * xlen));
        var f3 = yx.crossProduct(y).scale(vdot / (yxlen * ylen * ylen));
        atom1.addForce(f1);
        atom3.addForce(f3);
        atom2.addForce(f1.add(f3).negate());
    };
}

// I think these coefficients are all in milliattojoules, not certain.
var torsiontermCoefficients = {

    //"C:SP3:C:SP3:C:SP3:C:SP3": {v1:0.200, v2:0.270, v3:0.093},
    "C:SP3:C:SP3:C:SP3:C:SP3": {v1:0.0, v2:0.0, v3:0.3},

    "C:SP3:C:SP3:C:SP3:C:SP2": {v1:0.170, v2:0.270, v3:0.093},
    "C:SP3:C:SP3:C:SP3:C:SP": {v1:0.200, v2:-0.260, v3:0.093},
    "C:SP3:C:SP3:C:SP3:H:NONE": {v1:0.000, v2:0.000, v3:0.267},
    "C:SP3:C:SP3:C:SP3:O:SP3": {v1:0.100, v2:0.100, v3:0.180},
    "C:SP3:C:SP3:C:SP3:N:SP3": {v1:0.100, v2:0.400, v3:0.500},
    "C:SP3:C:SP3:C:SP3:N:SP2": {v1:0.000, v2:0.000, v3:0.400},
    "C:SP3:C:SP3:C:SP3:N:SP3": {v1:0.100, v2:0.400, v3:0.500},
    "C:SP2:C:SP3:C:SP3:C:SP2": {v1:2.100, v2:0.270, v3:0.093},
    "C:SP2:C:SP3:C:SP3:C:SP": {v1:0.000, v2:0.000, v3:0.093},
    "C:SP2:C:SP3:C:SP3:H:NONE": {v1:0.000, v2:0.000, v3:0.500},
    "C:SP2:C:SP3:C:SP3:O:SP3": {v1:0.000, v2:0.000, v3:0.180},
    "C:SP2:C:SP3:C:SP3:N:SP3": {v1:0.000, v2:0.000, v3:0.180},
    "C:SP2:C:SP3:C:SP3:N:SP2": {v1:0.000, v2:0.000, v3:0.000},
    "C:SP2:C:SP3:C:SP3:N:SP3": {v1:0.000, v2:0.000, v3:0.180},
    "C:SP:C:SP3:C:SP3:C:SP": {v1:1.000, v2:0.000, v3:0.093},
    "C:SP:C:SP3:C:SP3:H:NONE": {v1:0.000, v2:0.000, v3:0.400},
    "C:SP:C:SP3:C:SP3:O:SP3": {v1:0.000, v2:-0.400, v3:0.180},
    "H:NONE:C:SP3:C:SP3:H:NONE": {v1:0.000, v2:0.000, v3:0.237},
    "H:NONE:C:SP3:C:SP3:O:SP3": {v1:0.000, v2:0.000, v3:0.180},
    "H:NONE:C:SP3:C:SP3:N:SP3": {v1:-0.150, v2:0.000, v3:0.150},
    "H:NONE:C:SP3:C:SP3:N:SP2": {v1:0.000, v2:0.000, v3:0.400},
    "H:NONE:C:SP3:C:SP3:N:SP3": {v1:-0.150, v2:0.000, v3:0.150},
    "H:NONE:C:SP3:C:SP3:O:SP2": {v1:0.000, v2:0.000, v3:0.180},
    "O:SP3:C:SP3:C:SP3:O:SP3": {v1:0.000, v2:-0.600, v3:0.300},
    "O:SP3:C:SP3:C:SP3:N:SP3": {v1:0.000, v2:0.000, v3:0.000},
    "O:SP3:C:SP3:C:SP3:N:SP2": {v1:0.000, v2:0.000, v3:0.000},
    "O:SP3:C:SP3:C:SP3:N:SP3": {v1:0.000, v2:-0.600, v3:0.300},
    "N:SP3:C:SP3:C:SP3:N:SP3": {v1:-0.400, v2:-1.100, v3:1.200},
    "N:SP3:C:SP3:C:SP3:N:SP2": {v1:1.170, v2:-1.263, v3:2.064},
    "N:SP2:C:SP3:C:SP3:N:SP2": {v1:0.000, v2:0.000, v3:-0.500},
    "O:SP2:C:SP3:C:SP3:O:SP2": {v1:0.000, v2:-0.600, v3:0.300},
    "C:SP3:C:SP3:C:SP2:C:SP3": {v1:0.400, v2:0.030, v3:0.500},
    "C:SP3:C:SP3:C:SP2:C:SP2": {v1:-0.440, v2:0.240, v3:0.060},
    "C:SP3:C:SP3:C:SP2:C:SP": {v1:-0.440, v2:0.240, v3:0.060},
    "C:SP3:C:SP3:C:SP2:H:NONE": {v1:0.000, v2:0.000, v3:0.010},
    "C:SP3:C:SP3:C:SP2:O:SP3": {v1:0.000, v2:0.000, v3:0.000},
    "C:SP2:C:SP3:C:SP2:C:SP3": {v1:0.000, v2:0.000, v3:0.300},
    "C:SP2:C:SP3:C:SP2:C:SP2": {v1:0.100, v2:0.000, v3:0.500},
    "C:SP2:C:SP3:C:SP2:H:NONE": {v1:0.000, v2:0.000, v3:0.600},
    "C:SP2:C:SP3:C:SP2:O:SP3": {v1:0.000, v2:0.000, v3:0.000},
    "C:SP:C:SP3:C:SP2:C:SP3": {v1:0.000, v2:0.000, v3:0.780},
    "C:SP:C:SP3:C:SP2:C:SP2": {v1:0.000, v2:0.000, v3:0.100},
    "C:SP:C:SP3:C:SP2:H:NONE": {v1:0.000, v2:0.000, v3:0.780},
    "H:NONE:C:SP3:C:SP2:C:SP3": {v1:0.000, v2:0.000, v3:0.540},
    "H:NONE:C:SP3:C:SP2:C:SP2": {v1:0.000, v2:0.000, v3:-0.240},
    "H:NONE:C:SP3:C:SP2:C:SP": {v1:0.000, v2:0.000, v3:-0.240},
    "H:NONE:C:SP3:C:SP2:H:NONE": {v1:0.000, v2:0.000, v3:0.520},
    "H:NONE:C:SP3:C:SP2:O:SP3": {v1:0.000, v2:0.000, v3:0.540},
    "O:SP3:C:SP3:C:SP2:C:SP3": {v1:0.000, v2:0.000, v3:0.000},
    "O:SP3:C:SP3:C:SP2:C:SP2": {v1:0.000, v2:0.000, v3:0.000},
    "O:SP3:C:SP3:C:SP2:H:NONE": {v1:0.000, v2:0.000, v3:0.000},
    "N:SP3:C:SP3:C:SP2:C:SP3": {v1:0.000, v2:0.000, v3:0.000},
    "N:SP3:C:SP3:C:SP2:C:SP2": {v1:0.000, v2:0.000, v3:0.000},
    "N:SP3:C:SP3:C:SP2:H:NONE": {v1:0.000, v2:0.000, v3:0.000},
    "N:SP3:C:SP3:C:SP2:C:SP2": {v1:0.000, v2:0.000, v3:0.000},
    "C:SP3:C:SP3:C:SP:C:SP": {v1:0.000, v2:0.001, v3:0.000},
    "H:NONE:C:SP3:C:SP:C:SP": {v1:0.000, v2:0.001, v3:0.000},
    "C:SP3:C:SP3:O:SP3:C:SP3": {v1:0.400, v2:0.520, v3:0.467},
    "C:SP3:C:SP3:O:SP3:C:SP2": {v1:0.000, v2:0.000, v3:0.400},
    "C:SP3:C:SP3:O:SP3:O:SP3": {v1:0.000, v2:0.000, v3:0.400},
    "C:SP2:C:SP3:O:SP3:C:SP3": {v1:0.000, v2:0.000, v3:0.403},
    "H:NONE:C:SP3:O:SP3:C:SP3": {v1:0.000, v2:0.000, v3:0.530},
    "H:NONE:C:SP3:O:SP3:C:SP2": {v1:0.000, v2:0.000, v3:0.530},
    "H:NONE:C:SP3:O:SP3:O:SP3": {v1:0.000, v2:0.000, v3:0.465},
    "O:SP3:C:SP3:O:SP3:C:SP3": {v1:-0.170, v2:-1.200, v3:0.000},
    "O:SP3:C:SP3:O:SP3:O:SP3": {v1:0.000, v2:0.000, v3:0.403},
    "C:SP3:C:SP3:N:SP3:C:SP3": {v1:-0.200, v2:0.730, v3:0.800},
    "C:SP3:C:SP3:N:SP3:N:SP3": {v1:-0.200, v2:0.730, v3:0.800},
    "C:SP2:C:SP3:N:SP3:C:SP3": {v1:0.000, v2:0.000, v3:0.000},
    "C:SP2:C:SP3:N:SP3:N:SP3": {v1:0.000, v2:0.000, v3:0.000},
    "H:NONE:C:SP3:N:SP3:C:SP3": {v1:0.000, v2:0.000, v3:0.520},
    "H:NONE:C:SP3:N:SP3:C:SP2": {v1:0.000, v2:0.000, v3:0.450},
    "H:NONE:C:SP3:N:SP3:N:SP3": {v1:0.000, v2:0.000, v3:0.520},
    "N:SP3:C:SP3:N:SP3:C:SP3": {v1:0.000, v2:0.000, v3:0.350},
    "N:SP3:C:SP3:N:SP3:N:SP3": {v1:0.000, v2:0.000, v3:0.350},
    "N:SP3:C:SP3:N:SP3:C:SP3": {v1:0.000, v2:0.000, v3:0.350},
    "C:SP3:C:SP3:N:SP2:C:SP3": {v1:0.000, v2:0.000, v3:0.910},
    "C:SP3:C:SP3:N:SP2:C:SP2": {v1:0.000, v2:0.000, v3:0.000},
    "H:NONE:C:SP3:N:SP2:C:SP3": {v1:0.000, v2:0.000, v3:-0.200},
    "H:NONE:C:SP3:N:SP2:C:SP2": {v1:0.000, v2:0.000, v3:0.000},
    "H:NONE:C:SP3:N:SP2:C:SP2": {v1:0.000, v2:0.000, v3:0.650},
    "C:SP3:C:SP3:N:SP3:C:SP3": {v1:-0.200, v2:0.730, v3:0.800},
    "C:SP3:C:SP3:N:SP3:H:NONE": {v1:0.000, v2:0.120, v3:0.100},
    "C:SP2:C:SP3:N:SP3:C:SP3": {v1:0.000, v2:0.000, v3:0.000},
    "C:SP2:C:SP3:N:SP3:H:NONE": {v1:0.000, v2:0.000, v3:0.000},
    "H:NONE:C:SP3:N:SP3:C:SP3": {v1:0.000, v2:0.000, v3:0.520},
    "H:NONE:C:SP3:N:SP3:H:NONE": {v1:0.000, v2:0.000, v3:0.250},
    "N:SP3:C:SP3:N:SP3:C:SP3": {v1:0.000, v2:0.000, v3:0.350},
    "C:SP3:C:SP3:O:SP2:C:SP2": {v1:0.000, v2:0.000, v3:0.400},
    "H:NONE:C:SP3:O:SP2:C:SP2": {v1:0.000, v2:0.000, v3:0.350},
    "C:SP3:C:SP2:C:SP2:C:SP3": {v1:-0.100, v2:10.000, v3:0.000},
    "C:SP3:C:SP2:C:SP2:C:SP2": {v1:-0.270, v2:10.000, v3:0.000},
    "C:SP3:C:SP2:C:SP2:H:NONE": {v1:0.000, v2:12.500, v3:0.000},
    "C:SP3:C:SP2:C:SP2:O:SP3": {v1:-1.200, v2:16.250, v3:0.000},

    //"C:SP2:C:SP2:C:SP2:C:SP2": {v1:-0.930, v2:8.000, v3:0.000},
    "C:SP2:C:SP2:C:SP2:C:SP2": {v1:-0.930, v2:0.000, v3:0.000},

    "C:SP2:C:SP2:C:SP2:C:SP": {v1:0.000, v2:15.000, v3:0.000},
    "C:SP2:C:SP2:C:SP2:H:NONE": {v1:0.000, v2:9.000, v3:-1.060},
    "C:SP2:C:SP2:C:SP2:O:SP3": {v1:0.000, v2:16.250, v3:0.000},
    "C:SP2:C:SP2:C:SP2:N:SP3": {v1:0.000, v2:15.000, v3:0.000},
    "C:SP2:C:SP2:C:SP2:N:SP2": {v1:0.000, v2:12.000, v3:0.000},
    "C:SP2:C:SP2:C:SP2:O:SP2": {v1:0.000, v2:15.000, v3:0.000},
    "C:SP:C:SP2:C:SP2:H:NONE": {v1:0.000, v2:15.000, v3:0.000},

    //"H:NONE:C:SP2:C:SP2:H:NONE": {v1:0.000, v2:15.000, v3:0.000},
    "H:NONE:C:SP2:C:SP2:H:NONE": {v1:-2.000, v2:0.000, v3:0.000},

    "H:NONE:C:SP2:C:SP2:O:SP3": {v1:0.000, v2:16.250, v3:0.000},
    "H:NONE:C:SP2:C:SP2:N:SP3": {v1:0.000, v2:15.000, v3:0.000},
    "H:NONE:C:SP2:C:SP2:N:SP2": {v1:0.000, v2:12.000, v3:0.000},
    "H:NONE:C:SP2:C:SP2:O:SP2": {v1:0.000, v2:15.000, v3:0.000},
    "O:SP3:C:SP2:C:SP2:O:SP3": {v1:-2.000, v2:16.250, v3:0.000},
    "O:SP2:C:SP2:C:SP2:O:SP2": {v1:-2.000, v2:15.000, v3:0.000},
    "C:SP2:C:SP2:C:SP:C:SP": {v1:0.000, v2:0.001, v3:0.000},
    "C:SP3:C:SP2:O:SP3:C:SP3": {v1:2.300, v2:4.000, v3:0.000},
    "C:SP3:C:SP2:O:SP3:C:SP2": {v1:0.000, v2:0.000, v3:0.000},
    "C:SP2:C:SP2:O:SP3:C:SP3": {v1:3.530, v2:2.300, v3:-3.530},
    "C:SP2:C:SP2:O:SP3:C:SP2": {v1:0.000, v2:0.000, v3:0.000},
    "H:NONE:C:SP2:O:SP3:C:SP3": {v1:3.000, v2:3.100, v3:0.000},
    "H:NONE:C:SP2:O:SP3:C:SP2": {v1:0.000, v2:0.000, v3:0.000},
    "C:SP2:C:SP2:N:SP3:C:SP3": {v1:-1.570, v2:3.200, v3:0.000},
    "H:NONE:C:SP2:N:SP3:C:SP3": {v1:1.570, v2:1.690, v3:0.000},
    "C:SP2:C:SP2:N:SP2:C:SP3": {v1:0.000, v2:2.000, v3:0.000},
    "C:SP2:C:SP2:N:SP2:C:SP2": {v1:0.000, v2:0.000, v3:1.490},
    "N:SP2:C:SP2:N:SP2:C:SP3": {v1:0.000, v2:0.000, v3:0.000},
    "C:SP2:C:SP2:O:SP2:C:SP3": {v1:0.000, v2:9.200, v3:0.000},
    "C:SP2:C:SP2:O:SP2:C:SP2": {v1:0.000, v2:8.300, v3:-0.800},
    "H:NONE:C:SP2:O:SP2:C:SP3": {v1:-0.820, v2:9.200, v3:3.700},
    "H:NONE:C:SP2:O:SP2:C:SP2": {v1:-0.460, v2:2.700, v3:0.700},
    "C:SP3:C:SP:C:SP:C:SP2": {v1:0.000, v2:0.001, v3:0.000},
    "C:SP3:C:SP:C:SP:C:SP": {v1:0.000, v2:0.001, v3:0.000},
    "C:SP2:C:SP:C:SP:C:SP2": {v1:0.000, v2:0.001, v3:0.000},
    "C:SP2:C:SP:C:SP:C:SP": {v1:0.000, v2:0.001, v3:0.000},
    "C:SP2:C:SP:C:SP:H:NONE": {v1:0.000, v2:0.001, v3:0.000},
    "C:SP:C:SP:C:SP:C:SP": {v1:0.000, v2:0.001, v3:0.000},
    "C:SP3:O:SP3:O:SP3:C:SP3": {v1:2.095, v2:-2.155, v3:-0.113},
    "C:SP3:N:SP3:N:SP3:C:SP3": {v1:0.900, v2:-6.800, v3:0.210},
};

function makeTorsionTerm(atom1,atom2,atom3,atom4) {
    var sym1 = atom1.getSymbol();
    var hyb1 = atom1.getHybridizationString();
    var sym2 = atom2.getSymbol();
    var hyb2 = atom2.getHybridizationString();
    var sym3 = atom3.getSymbol();
    var hyb3 = atom3.getHybridizationString();
    var sym4 = atom4.getSymbol();
    var hyb4 = atom4.getHybridizationString();
    var key = (sym1 + ":" + hyb1 + ":" + sym2 + ":" + hyb2 + ":" +
               sym3 + ":" + hyb3 + ":" + sym4 + ":" + hyb4);
    var coeffs = torsiontermCoefficients[key];
    if (coeffs === undefined) {
        key = (sym4 + ":" + hyb4 + ":" + sym3 + ":" + hyb3 + ":" +
               sym2 + ":" + hyb2 + ":" + sym1 + ":" + hyb1);
        coeffs = torsiontermCoefficients[key];
    }
    var v1, v2, v3;
    if (coeffs === undefined) {
        v1 = 0.0;
        v2 = 0.0;
        v3 = 0.0;
    } else {
        v1 = coeffs.v1;
        v2 = coeffs.v2;
        v3 = coeffs.v3;
    }
    var mv = 1.0e-21;  // convert milliattojoules to joules
    v1 *= mv;
    v2 *= mv;
    v3 *= mv;
    function vderiv(phi) {   // first derivative of v w.r.t. phi
        return 0.5 * (-v1 * Math.sin(phi)
                      -2 * v2 * Math.sin(2 * phi) +
                      -3 * v3 * Math.sin(3 * phi));
    };
    return function() {
        var pos1 = atom1.getPosition();
        var pos2 = atom2.getPosition();
        var pos3 = atom3.getPosition();
        var pos4 = atom4.getPosition();
        var u = pos1.subtract(pos2);
        var v = pos3.subtract(pos2);
        var w = pos4.subtract(pos3);
        var uv = u.crossProduct(v);
        var uvlen = uv.length();
        var wv = w.crossProduct(v);
        var wvlen = wv.length();
        var phi = Math.asin(wv.crossProduct(uv).dotProduct(v) /
                            (uvlen * wvlen * v.length()));
        var vdot = vderiv(phi);
        var h = u.dotProduct(v);
        h = u.lensq() - (h * h) / v.lensq();
        var f1 = uv.scale(vdot / (Math.sqrt(h) * uvlen));
        h = w.dotProduct(v);
        h = w.lensq() - (h * h) / v.lensq();
        var f4 = wv.scale(-vdot / (Math.sqrt(h) * wvlen));
        atom1.addForce(f1);
        atom4.addForce(f4);
        // TODO - correct forces on atoms 2 and 3
        // The actual forces on atoms 2 and 3 are a little more complicated.
        // These are approximate. Torsion forces are weak compared to the
        // other forces so these approximations aren't horrible.
        var fopp = f1.add(f4).scale(-0.5);
        atom2.addForce(fopp);
        atom3.addForce(fopp);
    };
}

/*
 * Long range terms should ideally include both Van der Waals forces
 * and electrostatic forces. For now, I'm not dealing with electric
 * charges so this is just VDW forces.
 */
function makeLongRangeTerm(atom1,atom2) {
    var rvdw = atom1.getVdwRadius() + atom2.getVdwRadius();
    var evdw = 0.5 * (atom1.getVdwEnergy() + atom2.getVdwEnergy());
    evdw *= 1.0-21;   // convert maJ to system units
    // if I were going to do electrostatics, they'd look something like this
    // var q1q2 = atom1.getCharge() * atom2.getCharge();
    return function() {
        var pos1 = atom1.getPosition();
        var pos2 = atom2.getPosition();
        var u = pos1.subtract(pos2);
        var r = u.length();
        // avoid divide-by-nearly-zero situations, they hurt numeric stability
        if (r < 0.7 * rvdw) r = 0.7 * rvdw;
        var r1 = rvdw / r;
        var r2 = r1 * r1;
        var r6 = r2 * r2 * r2;
        var m = -(evdw / r) * r6 * (r6 - 1.0);
        // m > 0 attract, m < 0 repel
        var f = u.scale(m);
        atom1.addForce(f.negate());
        atom2.addForce(f);
    };
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
