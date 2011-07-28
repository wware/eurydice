#/bin/sh

CP=/opt/rhino1_7R3/js.jar:${HOME}/eurydice/eurydice.jar

python testit.py $@ || exit 1
java -cp ${CP} org.mozilla.javascript.tools.shell.Main tmp.js || exit 1
rm -f tmp.js
