.SUFFIXES: .java .class .rst .html ;

CLASSPATH := \
	/usr/share/java/junit.jar \
	/usr/share/java/mongo-1.2.jar \
	.

# Convert spaces to colons.
EMPTY:=
SPACE:=$(EMPTY) $(EMPTY)
CLASSPATH:=$(subst $(SPACE),:,$(CLASSPATH))

JFLAGS=-cp $(CLASSPATH)

# BEGINCLASSLIST
SOURCES = \
	net/willware/eurydice/core/Atom.class \
	net/willware/eurydice/core/Bond.class \
	net/willware/eurydice/core/Jig.class \
	net/willware/eurydice/core/NanocadStyleStructure.class \
	net/willware/eurydice/core/Region.class \
	net/willware/eurydice/core/SmallStructure.class \
	net/willware/eurydice/core/Structure.class \
	net/willware/eurydice/core/Substructure.class \
	net/willware/eurydice/db/IStructureDatabase.class \
	net/willware/eurydice/db/MongoInterface.class \
	net/willware/eurydice/db/MysqlInterface.class \
	net/willware/eurydice/drawing/AWTApplet.class \
	net/willware/eurydice/drawing/AWTEngine.class \
	net/willware/eurydice/drawing/DrawingEngine.class \
	net/willware/eurydice/drawing/Entry.class \
	net/willware/eurydice/drawing/IDrawingEngine.class \
	net/willware/eurydice/drawing/Orientation.class \
	net/willware/eurydice/drawing/RasmolDrawing.class \
	net/willware/eurydice/elements/Carbon.class \
	net/willware/eurydice/elements/Hydrogen.class \
	net/willware/eurydice/elements/Nitrogen.class \
	net/willware/eurydice/elements/Oxygen.class \
	net/willware/eurydice/forcefields/ForceField.class \
	net/willware/eurydice/forcefields/mm2/AngleTerm.class \
	net/willware/eurydice/forcefields/mm2/LengthTerm.class \
	net/willware/eurydice/forcefields/mm2/LongRangeTerm.class \
	net/willware/eurydice/forcefields/mm2/NanocadStyleMM2.class \
	net/willware/eurydice/forcefields/mm2/Term.class \
	net/willware/eurydice/forcefields/mm2/TorsionTerm.class \
	net/willware/eurydice/library/Aspirin.class \
	net/willware/eurydice/library/Buckyball.class \
	net/willware/eurydice/library/Diamond.class \
	net/willware/eurydice/library/DiamondRod.class \
	net/willware/eurydice/library/Propane.class \
	net/willware/eurydice/library/TwoRings.class \
	net/willware/eurydice/library/Water.class \
	net/willware/eurydice/math/Matrix.class \
	net/willware/eurydice/math/PhysicalUnit.class \
	net/willware/eurydice/math/Quaternion.class \
	net/willware/eurydice/math/Vector.class \
	net/willware/eurydice/serialization/Filetype.class \
	net/willware/eurydice/serialization/InputStreamFromString.class \
	net/willware/eurydice/serialization/NanocadNativeFormat.class \
	net/willware/eurydice/serialization/OutputStreamToString.class \
	net/willware/eurydice/serialization/PdbFile.class \
	net/willware/eurydice/serialization/XyzFile.class \
	net/willware/eurydice/tests/DatabaseTests.class \
	net/willware/eurydice/tests/LinearAlgebraTests.class \

# ENDCLASSLIST

CLASSES = $(SOURCES:.java=.class)

JARFILE = eurydice.jar
ZIPFILE = eurydice.zip

.java.class:
	javac $(JFLAGS) $(@:.class=.java)

.rst.html:
	rst2html $< /tmp/rst.html
	head -$$(egrep -n '^</body>$$' /tmp/rst.html | sed 's/:.*//') /tmp/rst.html | \
		tail --lines=+$$(egrep -n '^<body>$$' /tmp/rst.html | sed 's/:.*//') | \
		grep -v "<div class" | grep -v "</div>" | \
		sed "s#<h1 class=\"title\">#<h1>#" > $@

jar: $(JARFILE)

# I keep needing to do this...
update-java-list:
	head -$$(grep -n BEGINCLASSLIST Makefile | head -1 | sed 's/:.*//') Makefile
	echo SOURCES = \\
	make --quiet ls-java | sed 's/\.java/.class/' | sed 's/^/\t/' | sed 's/$$/ \\/'
	echo
	tail --lines=+$$(grep -n ENDCLASSLIST Makefile | head -1 | sed 's/:.*//') Makefile

ls-java:
	git ls-files | egrep '\.java$$' | sort

zip: $(ZIPFILE)

$(ZIPFILE): $(CLASSES)
	rm -f $(ZIPFILE)
	zip $(ZIPFILE) $$(find . -name "*.class")

$(JARFILE): $(CLASSES)
	rm -f $(JARFILE)
	jar cvf $(JARFILE) $$(find . -name "*.class")

classes:
	make $(CLASSES)

indent:
	astyle -A2 $$(find * -name "*.java")

tests: $(JARFILE)
	java $(JFLAGS) net.willware.eurydice.tests.DatabaseTests
	java $(JFLAGS) net.willware.eurydice.tests.LinearAlgebraTests

run-applet: $(JARFILE)
	java $(JFLAGS) net.willware.eurydice.drawing.AWTApplet

PACKAGE_DESCRIPTIONS = net/willware/eurydice/core/package.html \
	net/willware/eurydice/db/package.html \
	net/willware/eurydice/drawing/package.html \
	net/willware/eurydice/elements/package.html \
	net/willware/eurydice/forcefields/package.html \
	net/willware/eurydice/forcefields/mm2/package.html \
	net/willware/eurydice/library/package.html \
	net/willware/eurydice/math/package.html \
	net/willware/eurydice/serialization/package.html \
	net/willware/eurydice/tests/package.html

show-doc: ../html/index.html
	x-www-browser ../html/index.html &

doc: ../html/index.html

../html/index.html: overview.html $(PACKAGE_DESCRIPTIONS)
	javadoc -overview overview.html -d ../html $$(find . -name '*.java')

doc-tarball: overview.html $(PACKAGE_DESCRIPTIONS)
	rm -rf nc2-javadoc
	javadoc -overview overview.html -d nc2-javadoc $$(find . -name '*.java')
	tar cfz ~/nc2-javadoc.tgz nc2-javadoc
	rm -rf nc2-javadoc

clean:
	rm -f *~ $$(find . -name "*.class") $(JARFILE) $(ZIPFILE)
	rm -f *~ $$(find . -name "package.html")
	rm -f *~ $$(find . -name "*.java.orig")
	rm -rf ../html overview.html $(PACKAGE_DESCRIPTIONS)

rsthtml = \
	rst2html $(2) /tmp/rst.html; \
	head -$$(egrep -n '^</body>$$' < /tmp/rst.html | sed 's/:.*//') < /tmp/rst.html | \
		tail --lines=+$$(egrep -n '^<body>$$' < /tmp/rst.html | sed 's/:.*//') | \
		grep -v '<div class' | grep -v '</div>' | \
		sed 's\#<h1 class="title">\#<h1>\#' > $(1)

net/willware/eurydice/core/package.html: net/willware/eurydice/core/README.rst
	$(call rsthtml, net/willware/eurydice/core/package.html, net/willware/eurydice/core/README.rst)
net/willware/eurydice/db/package.html: net/willware/eurydice/db/README.rst
	$(call rsthtml, net/willware/eurydice/db/package.html, net/willware/eurydice/db/README.rst)
net/willware/eurydice/drawing/package.html: net/willware/eurydice/drawing/README.rst
	$(call rsthtml, net/willware/eurydice/drawing/package.html, net/willware/eurydice/drawing/README.rst)
net/willware/eurydice/elements/package.html: net/willware/eurydice/elements/README.rst
	$(call rsthtml, net/willware/eurydice/elements/package.html, net/willware/eurydice/elements/README.rst)
net/willware/eurydice/forcefields/package.html: net/willware/eurydice/forcefields/README.rst
	$(call rsthtml, net/willware/eurydice/forcefields/package.html, net/willware/eurydice/forcefields/README.rst)
net/willware/eurydice/forcefields/mm2/package.html: net/willware/eurydice/forcefields/mm2/README.rst
	$(call rsthtml, net/willware/eurydice/forcefields/mm2/package.html, net/willware/eurydice/forcefields/mm2/README.rst)
net/willware/eurydice/library/package.html: net/willware/eurydice/library/README.rst
	$(call rsthtml, net/willware/eurydice/library/package.html, net/willware/eurydice/library/README.rst)
net/willware/eurydice/math/package.html: net/willware/eurydice/math/README.rst
	$(call rsthtml, net/willware/eurydice/math/package.html, net/willware/eurydice/math/README.rst)
net/willware/eurydice/serialization/package.html: net/willware/eurydice/serialization/README.rst
	$(call rsthtml, net/willware/eurydice/serialization/package.html, net/willware/eurydice/serialization/README.rst)
net/willware/eurydice/tests/package.html: net/willware/eurydice/tests/README.rst
	$(call rsthtml, net/willware/eurydice/tests/package.html, net/willware/eurydice/tests/README.rst)

overview.html: ../README.rst
	$(call rsthtml, overview.html, ../README.rst)
