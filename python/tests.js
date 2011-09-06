var _N;
var testsOK = true;

function testfail() {
    testsOK = false;
    throw _N;
}

function test(expr) {
    _N = expr;
    eval(expr);
}

function prettyClose(x, y) {
    var z = x - y;
    if (z < 0) z = -z;
    if (z > 1.0e-6) testfail();
}

function equal(x, y) {
    if (x != y) testfail();
}

// compare two vectors, works for both Java and JavaScript
function vmatch(u, v) {
    prettyClose(u.x, v.x);
    prettyClose(u.y, v.y);
    prettyClose(u.z, v.z);
}

// compare two quaternions, works for both Java and JavaScript
function qmatch(q1, q2) {
    prettyClose(q1.getReal(), q2.getReal());
    vmatch(q1.getImaginary(), q2.getImaginary());
}

function colorMatch(c1, c2) {
    if (c1.getRed() != c2.getRed() ||
        c1.getGreen() != c2.getGreen() ||
        c1.getBlue() != c2.getBlue())
        testfail();
}

/*
 * * * * * * * * * * * * * * VECTORS IN 3-SPACE * * * * * * * * * * * * * *
 */
var v = Vector(1.2, -0.3, 0.78);
test("prettyClose(v.length(), 1.4623269)");
test("prettyClose(v.lensq(), 2.1384)");
test("prettyClose(v.dotProduct(v), 2.1384)");
test("vmatch(v.negate(), Vector(-1.2, 0.3, -0.78))");
test("vmatch(v.scale(5), Vector(6, -1.5, 3.9))");
test("vmatch(v.crossProduct(Vector(2, 3, 5)), Vector(-3.84, -4.44, 4.2))");
test("prettyClose(v.dotProduct(Vector(2, 3, 5)), 5.4)");
test("prettyClose(v.distsq(Vector(2, 3, 5)), 29.3384)");

/*
 * * * * * * * * * * * * * * QUATERNIONS * * * * * * * * * * * * * *
 */

var v = Vector(1.2, -0.3, 0.78);
var q1 = Quaternion(1, Vector(2, 3, 4));
var q2 = Quaternion(3, Vector(-4, 0, 5));
test("qmatch(q1.add(q2), Quaternion(4, Vector(-2, 3, 9)))");
test("qmatch(q1.subtract(q2), Quaternion(-2, Vector(6, 3, -1)))");
test("qmatch(q1.multiply(q2), Quaternion(-9, Vector(17, -17, 29)))");
test("qmatch(q1.divide(q2), Quaternion(0.3, Vector(-0.1, 0.7, -0.1)))");
test("qmatch(q1.inverse(), Quaternion(0.033333, Vector(-0.0666667, -0.1, -0.1333333)))");
test("qmatch(q1.multiply(q1.inverse()), Quaternion(1, Vector(0, 0, 0)))");
test("qmatch(q1.add(q1.negate()), Quaternion(0, Vector(0, 0, 0)))");
test("qmatch(q1.scale(5), Quaternion(5, Vector(10, 15, 20)))");
test("prettyClose(q1.absoluteValue(), 5.4772255)");
test("qmatch(q1.multiplyVector(v), Quaternion(-4.62, Vector(4.74, 2.94, -3.42)))");
test("vmatch(q1.rotate(v), Vector(-0.268, 1.42, 0.224))");
test("qmatch(q1.normalize(), Quaternion(0.182574, Vector(0.365148, 0.547722, 0.7302967)))");
test("qmatch(v.multiplyQuaternion(q1), Quaternion(-4.62, Vector(-2.34, -3.54, 4.98)))");

/*
 * * * * * * * * * * * * * * ATOMS AND ELEMENTS * * * * * * * * * * * * * *
 */
test("equal(Atom.NONE, 0)");
test("equal(Atom.SP, 1)");
test("equal(Atom.SP2, 2)");
test("equal(Atom.SP3, 3)");

var protonMass = 1.67262158e-27;
var atom = Carbon();
test("equal(atom.getName(), 'Carbon')");
test("equal(atom.getSymbol(), 'C')");
test("equal(atom.getHybridization(), Atom.SP3)");
test("equal(atom.getAtomicNumber(), 6)");
test("prettyClose(atom.getMass(), 12*protonMass)");
test("colorMatch(atom.getColor(), Color.getColor('gray30'))");
test("prettyClose(atom.getCovalentRadius(), 0.77e-10)");
test("prettyClose(atom.getVdwEnergy(), 0.357e-11)");
test("prettyClose(atom.getVdwRadius(), 1.85e-10)");
test("atom.setHybridization(Atom.SP2)");
test("prettyClose(atom.getCovalentRadius(), 0.67e-10)");
test("atom.setHybridization(Atom.SP)");
test("prettyClose(atom.getCovalentRadius(), 0.6e-10)");
test("equal(atom.getCorrectNumBonds(), 4)");
test("atom.setPosition(Vector(31, 14, 16))");
test("atom.move(Vector(27, 18, 28))");
test("vmatch(atom.getPosition(), Vector(58, 32, 44))");
test("atom.setPreviousPosition(Vector(1, 2, 3))");
test("vmatch(atom.getPreviousPosition(), Vector(1, 2, 3))");
test("atom.setPreviousPosition(Vector(4, 5, 6))");
test("vmatch(atom.getPreviousPosition(), Vector(4, 5, 6))");
test("atom.zeroForce()");
test("vmatch(atom.getForce(), Vector(0, 0, 0))");
test("atom.setForce(Vector(1, 3, 5))");
test("atom.addForce(Vector(7, 6, 5))");
test("vmatch(atom.getForce(), Vector(8, 9, 10))");

atom = Hydrogen();
test("equal(atom.getName(), 'Hydrogen')");
test("equal(atom.getSymbol(), 'H')");
test("equal(atom.getHybridization(), Atom.NONE)");
test("equal(atom.getAtomicNumber(), 1)");
test("prettyClose(atom.getMass(), protonMass)");
test("colorMatch(atom.getColor(), Color.getColor('white'))");
test("prettyClose(atom.getCovalentRadius(), 0.3e-10)");
test("prettyClose(atom.getVdwEnergy(), 0.382e-11)");
test("prettyClose(atom.getVdwRadius(), 1.2e-10)");
test("equal(atom.getCorrectNumBonds(), 1)");
test("atom.setPosition(Vector(31, 14, 16))");
test("atom.move(Vector(27, 18, 28))");
test("vmatch(atom.getPosition(), Vector(58, 32, 44))");
test("atom.setPreviousPosition(Vector(1, 2, 3))");
test("vmatch(atom.getPreviousPosition(), Vector(1, 2, 3))");
test("atom.setPreviousPosition(Vector(4, 5, 6))");
test("vmatch(atom.getPreviousPosition(), Vector(4, 5, 6))");
test("atom.zeroForce()");
test("vmatch(atom.getForce(), Vector(0, 0, 0))");
test("atom.setForce(Vector(1, 3, 5))");
test("atom.addForce(Vector(7, 6, 5))");
test("vmatch(atom.getForce(), Vector(8, 9, 10))");

atom = Oxygen();
test("equal(atom.getName(), 'Oxygen')");
test("equal(atom.getSymbol(), 'O')");
test("equal(atom.getHybridization(), Atom.SP3)");
test("equal(atom.getAtomicNumber(), 8)");
test("prettyClose(atom.getMass(), 16*protonMass)");
test("colorMatch(atom.getColor(), Color.getColor('red'))");
test("prettyClose(atom.getCovalentRadius(), 0.74e-10)");
test("prettyClose(atom.getVdwEnergy(), 0.406e-11)");
test("prettyClose(atom.getVdwRadius(), 1.4e-10)");
test("atom.setHybridization(Atom.SP2)");
test("prettyClose(atom.getCovalentRadius(), 0.62e-10)");
test("prettyClose(atom.getVdwEnergy(), 0.536e-11)");
test("atom.setHybridization(Atom.SP)");
test("prettyClose(atom.getCovalentRadius(), 0.55e-10)");
test("prettyClose(atom.getVdwEnergy(), 0.536e-11)");
test("equal(atom.getCorrectNumBonds(), 2)");
test("atom.setPosition(Vector(31, 14, 16))");
test("atom.move(Vector(27, 18, 28))");
test("vmatch(atom.getPosition(), Vector(58, 32, 44))");
test("atom.setPreviousPosition(Vector(1, 2, 3))");
test("vmatch(atom.getPreviousPosition(), Vector(1, 2, 3))");
test("atom.setPreviousPosition(Vector(4, 5, 6))");
test("vmatch(atom.getPreviousPosition(), Vector(4, 5, 6))");
test("atom.zeroForce()");
test("vmatch(atom.getForce(), Vector(0, 0, 0))");
test("atom.setForce(Vector(1, 3, 5))");
test("atom.addForce(Vector(7, 6, 5))");
test("vmatch(atom.getForce(), Vector(8, 9, 10))");

atom = Nitrogen();
test("equal(atom.getName(), 'Nitrogen')");
test("equal(atom.getSymbol(), 'N')");
test("equal(atom.getHybridization(), Atom.SP3)");
test("equal(atom.getAtomicNumber(), 7)");
test("prettyClose(atom.getMass(), 14*protonMass)");
test("colorMatch(atom.getColor(), Color.getColor('blue'))");
test("prettyClose(atom.getCovalentRadius(), 0.74e-10)");  // IDENTICAL to oxygen??
test("prettyClose(atom.getVdwEnergy(), 0.447e-11)");
test("prettyClose(atom.getVdwRadius(), 1.5e-10)");
test("atom.setHybridization(Atom.SP2)");
test("prettyClose(atom.getCovalentRadius(), 0.62e-10)"); // ? ?
test("atom.setHybridization(Atom.SP)");
test("prettyClose(atom.getCovalentRadius(), 0.55e-10)"); // ? ?
test("equal(atom.getCorrectNumBonds(), 3)");
test("atom.setPosition(Vector(31, 14, 16))");
test("atom.move(Vector(27, 18, 28))");
test("vmatch(atom.getPosition(), Vector(58, 32, 44))");
test("atom.setPreviousPosition(Vector(1, 2, 3))");
test("vmatch(atom.getPreviousPosition(), Vector(1, 2, 3))");
test("atom.setPreviousPosition(Vector(4, 5, 6))");
test("vmatch(atom.getPreviousPosition(), Vector(4, 5, 6))");
test("atom.zeroForce()");
test("vmatch(atom.getForce(), Vector(0, 0, 0))");
test("atom.setForce(Vector(1, 3, 5))");
test("atom.addForce(Vector(7, 6, 5))");
test("vmatch(atom.getForce(), Vector(8, 9, 10))");

/*
 * * * * * * * * * * * * * * STRUCTURE STUFF * * * * * * * * * * * * * *
 */

var s = Structure();
s.buildFromArray([['C', 1.101, -0.054, 0.774],   // benzene
                  ['C', 0.460, -1.178, 0.427],
                  ['C', -0.480, -1.142, -0.527],
                  ['C', -0.907, 0.039, -0.995],
                  ['C', -0.400, 1.174, -0.496],
                  ['C', 0.659, 1.128, 0.325],
                  ['H', -0.912, 1.994, -0.565],
                  ['H', 0.953, 1.941, 0.764],
                  ['H', 1.724, -0.075, 1.518],
                  ['H', 0.530, -1.961, 0.996],
                  ['H', -1.002, -1.940, -0.707],
                  ['H', -1.726, 0.074, -1.513]]);


/*
 * * * * * * * * * * ORIENTATION and DRAWING * * * * * * * * * * *
 */

/*
 * * * * * * * * * * Dynamics (MM2) stuff * * * * * * * * * * *
 */
