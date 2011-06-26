# Having compiled a jar file, we can use it in Jython.

import sys
sys.path.append('eurydice.jar')

from net.willware.eurydice import *

print "Do a little energy minimization on propane"
propane = library.Propane()
pdb = serialization.PdbFile()
pdb.dump(sys.stdout, propane)

step = 0.1
for i in range(5):
    propane.energyMinimizeStep(step)
    pdb.dump(sys.stdout, propane)
    step *= 0.5

# Physical units
# distances are in angstroms (10^-10 m)
# forces are in ???
# times are in femtoseconds? (10^-15 s)

print
print "Now a little molecular dynamics"
# lame: the only force is residual Emin force

step = 0.1
propane.verletPrep()
for i in range(5):
    propane.computeInternalForces();
    propane.verletStep(step)
    pdb.dump(sys.stdout, propane)
    step *= 0.5

#
# Let's make sure load and save aren't too broken.
#
xyz = serialization.XyzFile()
x = xyz.dumps(propane)
print x
y = xyz.loads(x)
pdb.dump(sys.stdout, y)
