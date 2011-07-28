Why bother duplicating functionality in JavaScript?
===================================================

I knew I wanted dynamics in the browser, and that had to be done in
JavaScript, and I'd already written all that code in Java.

At first I planned to use GWT's Java-to-JavaScript compiler. I soon discovered
that its coverage of Java isn't large, like you can't include anything from
java.io.* or java.io.* or java.util.* without headaches. So I started
patiently sorting and refactoring the Eurydice code into GWT-safe and
GWT-unsafe areas, and wrote a Python script to bring them into a GWT project,
dividing them among the canonical server, client, and shared directories. I
got it all working, and discovered that GWT-generated JavaScript was running
much slower than what I was writing by hand. So I gave up on GWT.

My reason for favoring GWT had been to avoid redundant source to avoid
functional divergence between the Java and JavaScript. But I can prevent
functional divergence with comprehensive regression tests. Rhino is an Apache
project that lets you call Java code from JavaScript. So yes, I *will* write
redundant code, but *theoretically* comprehensive regression testing will keep
me out of trouble. We'll see.
