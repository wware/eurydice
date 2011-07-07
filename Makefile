.SUFFIXES: .rst .html ;

CLASSPATH := \
	/usr/share/java/junit.jar \
	.

# Convert spaces to colons.
EMPTY:=
SPACE:=$(EMPTY) $(EMPTY)
CLASSPATH:=$(subst $(SPACE),:,$(CLASSPATH))

.rst.html:
	rst2html $< /tmp/rst.html
	head -$$(egrep -n '^</body>$$' /tmp/rst.html | sed 's/:.*//') /tmp/rst.html | \
		tail --lines=+$$(egrep -n '^<body>$$' /tmp/rst.html | sed 's/:.*//') | \
		grep -v "<div class" | grep -v "</div>" | \
		sed "s#<h1 class=\"title\">#<h1>#" > $@

PACKAGE_DESCRIPTIONS = src/net/willware/eurydice/core/package.html \
	src/net/willware/eurydice/db/package.html \
	src/net/willware/eurydice/view/package.html \
	src/net/willware/eurydice/elements/package.html \
	src/net/willware/eurydice/forcefields/package.html \
	src/net/willware/eurydice/forcefields/mm2/package.html \
	src/net/willware/eurydice/library/package.html \
	src/net/willware/eurydice/math/package.html \
	src/net/willware/eurydice/serialization/package.html \
	src/net/willware/eurydice/tests/package.html

show-doc: html/index.html
	x-www-browser html/index.html &

doc: html/index.html

html/index.html: overview.html $(PACKAGE_DESCRIPTIONS)
	javadoc -overview overview.html -d html $$(find . -name '*.java')

doc-tarball: overview.html $(PACKAGE_DESCRIPTIONS)
	rm -rf nc2-javadoc
	javadoc -overview overview.html -d nc2-javadoc $$(find . -name '*.java')
	tar cfz ~/nc2-javadoc.tgz nc2-javadoc
	rm -rf nc2-javadoc

clean:
	rm -f *~ $$(find . -name "package.html")
	rm -rf html overview.html $(PACKAGE_DESCRIPTIONS)

rsthtml = \
	rst2html $(2) /tmp/rst.html; \
	head -$$(egrep -n '^</body>$$' < /tmp/rst.html | sed 's/:.*//') < /tmp/rst.html | \
		tail --lines=+$$(egrep -n '^<body>$$' < /tmp/rst.html | sed 's/:.*//') | \
		grep -v '<div class' | grep -v '</div>' | \
		sed 's\#<h1 class="title">\#<h1>\#' > $(1)

src/net/willware/eurydice/core/package.html: src/net/willware/eurydice/core/README.rst
	$(call rsthtml, src/net/willware/eurydice/core/package.html, src/net/willware/eurydice/core/README.rst)
src/net/willware/eurydice/db/package.html: src/net/willware/eurydice/db/README.rst
	$(call rsthtml, src/net/willware/eurydice/db/package.html, src/net/willware/eurydice/db/README.rst)
src/net/willware/eurydice/view/package.html: src/net/willware/eurydice/view/README.rst
	$(call rsthtml, src/net/willware/eurydice/view/package.html, src/net/willware/eurydice/view/README.rst)
src/net/willware/eurydice/elements/package.html: src/net/willware/eurydice/elements/README.rst
	$(call rsthtml, src/net/willware/eurydice/elements/package.html, src/net/willware/eurydice/elements/README.rst)
src/net/willware/eurydice/forcefields/package.html: src/net/willware/eurydice/forcefields/README.rst
	$(call rsthtml, src/net/willware/eurydice/forcefields/package.html, src/net/willware/eurydice/forcefields/README.rst)
src/net/willware/eurydice/forcefields/mm2/package.html: src/net/willware/eurydice/forcefields/mm2/README.rst
	$(call rsthtml, src/net/willware/eurydice/forcefields/mm2/package.html, src/net/willware/eurydice/forcefields/mm2/README.rst)
src/net/willware/eurydice/library/package.html: src/net/willware/eurydice/library/README.rst
	$(call rsthtml, src/net/willware/eurydice/library/package.html, src/net/willware/eurydice/library/README.rst)
src/net/willware/eurydice/math/package.html: src/net/willware/eurydice/math/README.rst
	$(call rsthtml, src/net/willware/eurydice/math/package.html, src/net/willware/eurydice/math/README.rst)
src/net/willware/eurydice/serialization/package.html: src/net/willware/eurydice/serialization/README.rst
	$(call rsthtml, src/net/willware/eurydice/serialization/package.html, src/net/willware/eurydice/serialization/README.rst)
src/net/willware/eurydice/tests/package.html: src/net/willware/eurydice/tests/README.rst
	$(call rsthtml, src/net/willware/eurydice/tests/package.html, net/willware/eurydice/tests/README.rst)

overview.html: README.rst
	$(call rsthtml, overview.html, README.rst)
