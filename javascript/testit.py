# Why can't I run Rhino using os.system()??

import os
import os.path
import sys

DEBUG = False

testinit = """
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
    prettyClose(u.getX(), v.getX());
    prettyClose(u.getY(), v.getY());
    prettyClose(u.getZ(), v.getZ());
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

"""

edir = os.environ["HOME"] + "/eurydice"
ejar = edir + "/eurydice.jar"

outf = open('tmp.js', 'w')

outf.write(testinit)

# Decide whether to test Java or Javascript
# Same tests in either case
testingJava = 'java' in sys.argv[1:]
if testingJava:
    # Java: build the jar if necessary
    if not os.path.exists(ejar):
        os.system("(cd %s; ant clean; ant jar)" % edir)
    # Use java objects
    outf.write("importPackage(Packages.net.willware.eurydice.core);\n")
    outf.write("importPackage(Packages.net.willware.eurydice.db);\n")
    outf.write("importPackage(Packages.net.willware.eurydice.elements);\n")
    outf.write("importPackage(Packages.net.willware.eurydice.forcefields);\n")
    outf.write("importPackage(Packages.net.willware.eurydice.elements);\n")
    outf.write("importPackage(Packages.net.willware.eurydice.library);\n")
    outf.write("importPackage(Packages.net.willware.eurydice.math);\n")
else:
    # Use JavaScript objects
    outf.write(open('eurydice.js').read())

outf.write('\n\n')
testLines = False
for L in open('eurydice.js').readlines():
    if L.startswith(' * TESTS'):
        testLines = True
    elif L.startswith(' */') and testLines:
        testLines = False
    elif testLines:
        if (L.startswith(' * ') or
            (L.startswith(' + ') and testingJava) or
            (L.startswith(' - ') and not testingJava)):
            L = L[3:]
            if DEBUG:
                outf.write(("print(\"%s\");\n" % L.replace("\"", "\\\"").rstrip()))
            outf.write(("_N = \"%s\";\n" % L.replace("\"", "\\\"").rstrip()) + L)

outf.close()
