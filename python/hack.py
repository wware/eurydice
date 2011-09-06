import os

home = os.environ["HOME"]
classpath = "/opt/rhino1_7R3/js.jar"
#classpath += ":" + home + "/eurydice/eurydice.jar"

def run(cmd):
    print cmd
    os.system(cmd)

run("cat ../javascript/eurydice.js tests.js > foo.js")

run("java -cp " + classpath + " " +
    "org.mozilla.javascript.tools.shell.Main foo.js")
