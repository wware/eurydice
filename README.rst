Eurydice is a Java codebase that attempts to make computational chemistry
easier to work with, so that professional chemists can spend less time
functioning as software engineers, and people who are new to computational
chemistry face a shallower learning curve.

Eurydice is also designed to handle large structures that don't fit in a
machine's RAM all at once. The entire structure lives in a database and can
be worked with in pieces gracefully.

A lot of this code came from the NanoCAD Java applet that I wrote in 1997, at
a time when my Java chops were less fully developed, and my understanding of
molecular modeling was shallower than it is now. Since that time, we've seen
`Google architectures`_ like GFS, BigTable, and MapReduce, and we all know a
little more now about scaling for large problems.

.. _`Google architectures`: http://www.cis.temple.edu/~ingargio/cis307/readings/MapReduce/MapReduce.html

NanoCAD worked great for tiny little structures, but even at the time I knew
it wouldn't scale to a thousand atoms nicely. To build a structure the user
needed to use the mouse to draw bonds from one atom to another. The
structure-building GUI in NanoEngineer-1, a later program developed by Nanorex
Inc., was vastly superior.

A structure in Eurydice consists of a list of atoms, each with a type
(consisting of an element and a hybridization) and a position in 3-space. The
atom also has a couple more slots for a force vector and a previous position
vector (anticipating the use of Verlet integration when I get to that). Like
version tracking in Git, molecular structures come in trees, so they have
ancestors unless they are roots. As you follow out a branch of a tree, the
nodes could represent design changes, or they could represent sequential steps
in a simulation.

The system provides regional fetches. The database splits a position list into
chunks by applying a cubical tiling to 3-space. Each atom includes an 64-bit
index. Then you present those in a single Iterator. It goes something like
this::

 def regionQuery(x1, y1, z1, x2, y2, z2):
     region = new Region(x1, y1, z1, x2, y2, z2)
     for (tile: all cubical tiles with non-zero overlap with region):
         for (atom: all atoms in tile):
             if atom.position in region:
                 store atom in FIFO
     store "END" in FIFO

The client's access to the FIFO contents is basically the Iterator interface,
with next() and hasNext(). If things are running slow, either of those methods
may block for a while.

For small structures you can suck everything into RAM and deal with it there.
For larger structures you pull in a piece at a time, and you build a new
position list incrementally, by first building a force list, and then doing
arithmetic operations (Verlet integration) on these lists.

DB chunk
--------

I've spent several days banging on the database interface and I've gotten it
to a point of being pretty simple. Except that now I'm realizing I've got an
incremental fetch but no incremental store. I'm going to need that. So, still
a work in progress::

 public interface IStructureDatabase {
     public boolean store(Structure s);
     public Structure fetch(UUID uuid);
     public Structure fetchByRegion(UUID uuid, Region r);
 }

I'd like to test it with `MySQL`_, `MongoDB`_, `HBase`_, and the `Google
AppEngine Datastore`_. I want to test it with large structures with more than
four billion atoms so any limitations of a 32-bit index are made apparent. Not
that I'm using a 32-bit index, but I just want to make sure nothing breaks.
That will also force me to confront any issues resulting from not being able
to pull the whole structure into RAM.

.. _MySQL: http://www.mysql.com/
.. _MongoDB: http://www.mongodb.org/
.. _HBase: http://hbase.apache.org/
.. _Google AppEngine Datastore: http://code.google.com/appengine/docs/java/datastore/overview.html

Simulation chunk
----------------

There needs to be a simulation abstraction layer that hides whether the
simulation is being done with an MM2-style simulator (like NanoCAD 97) or with
GROMACS, and whether the simulation is being done in your browser, or
elsewhere on the same machine, or on one remote machine, or on some distant
cluster. Also it needs to say whether the trajectory is to be returned in one
big package, or is dribbled back to the client one frame at a time for
real-time animation display.

1. Get the NanoCAD MM2 simulator working. Add electrostatic charges and forces.
2. Get GROMACS working, write a simulation abstraction layer. Also run GROMACS
   on a VM and running a proxy on the local machine.
3. Clustered GROMACS test: how will I do that?

One can imagine a marketplace for simulation services. Offhand I don't see
that impacting the simulation abstraction layer, but it's something to keep in
mind.

GUI chunk
---------

How to present it prettily, how to build structures in the GUI, arrangement of
controls and buttons on screen. Lots of esthetics here, this will be more art
than science.
