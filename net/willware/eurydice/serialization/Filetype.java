package net.willware.eurydice.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import net.willware.eurydice.core.InputStreamFromString;
import net.willware.eurydice.core.OutputStreamToString;
import net.willware.eurydice.core.Structure;

/**
 * A base class for serializing and de-serializing molecules to and from files on disk.
 * Extended for various standard (and not so standard) molecule file formats.
 */
public abstract class Filetype {
    /* these are for formatting strings and numbers */
    protected final static int LEFT = 0;
    protected final static int RIGHT = 1;

    /** The pbis. */
    protected PushbackInputStream pbis;

    /**
     * Dump a Structure to an OutputStream.
     *
     * @param outs an OutputStream to which a structure should be serialized
     * @param struc the structure to be serialized
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void dump(OutputStream outs, Structure struc) throws IOException {
        dump(new PrintStream(outs), struc);
    }

    /**
     * Dump a Structure to a PrintStream.
     *
     * @param ps the PrintStream to which the structure should be serialized
     * @param struc the structure to be serialized
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected abstract void dump(PrintStream ps, Structure struc) throws IOException;

    /**
     * Load a structure by de-serializing stuff gotten from an InputStream.
     *
     * @param ins the InputStream
     * @return the structure gotten by de-serializing the received stuff
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract Structure load(InputStream ins) throws IOException;

    /**
     * Dump a Structure to a file, given a filename.
     *
     * @param filename the filename to be written to
     * @param struc the structure to be serialized
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void dump(String filename, Structure struc) throws IOException {
        FileOutputStream f = new FileOutputStream(filename);
        dump(new PrintStream(f), struc);
    }

    /**
     * Dump a Structure to a String.
     *
     * @param struc the Structure to be serialized
     * @return the resulting String
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public String dumps(Structure struc) throws IOException {
        OutputStreamToString osts = new OutputStreamToString();
        dump(osts, struc);
        return osts.toString();
    }

    /**
     * Loads.
     *
     * @param content the content
     * @return the structure
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Structure loads(String content) throws IOException {
        return load(new InputStreamFromString(content));
    }

    /**
     * Load.
     *
     * @param filename the filename
     * @return the structure
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Structure load(String filename) throws IOException {
        throw new RuntimeException("not implemented yet");
    }

    protected int scanInt() throws IOException {
        return (int) scanDouble();
    }

    protected String read(int n) throws IOException {
        byte[] b = new byte[n];
        pbis.read(b);
        return new String(b);
    }

    protected void unread(String s) throws IOException {
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            pbis.unread(s.charAt(i));
        }
    }

    protected char nextChar() throws IOException {
        char c = (char) pbis.read();
        pbis.unread(c);
        return c;
    }

    protected String scanWord() throws IOException {
        StringBuilder sb = new StringBuilder();
        skipBlanks();
        while (true) {
            char c = (char) pbis.read();
            if (isBlank(c, true)) {
                pbis.unread(c);
                //System.out.println("WORD: " + sb);
                return sb.toString();
            }
            sb.append(c);
        }
    }

    /**
     * Scan double.
     *
     * @return the double
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected double scanDouble() throws IOException {
        try {
            return new Double(scanWord());
        } catch (Exception e) {
            return 0.0;
        }
    }

    protected void bagLine() throws IOException {
        while (true) {
            char c = (char) pbis.read();
            if (c == '\n') {
                return;
            }
        }
    }

    protected void skipBlanks() throws IOException {
        while (true) {
            char c = (char) pbis.read();
            if (!isBlank(c, true)) {
                pbis.unread(c);
                return;
            }
        }
    }

    protected boolean isBlank(char c, boolean includeNewline) {
        if (includeNewline)
            return c == ' ' || c == '\t' || c == '\n'
                   || c == '\r';
        else
            return c == ' ' || c == '\t';
    }

    protected String formatInt(int x, int spaces, int direction) {
        String intstr = "";
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }
        if (x == 0)
            intstr = "0";
        else
            while (x > 0) {
                intstr =
                    ((char) ((x % 10) + '0')) + intstr;
                x /= 10;
            }
        if (neg)
            intstr = '-' + intstr;
        if (direction == LEFT)
            while (intstr.length() < spaces)
                intstr = intstr + ' ';
        else
            while (intstr.length() < spaces)
                intstr = ' ' + intstr;
        return intstr;
    }

    protected String formatString(String x, int spaces, int direction) {
        int i;
        String spc = "";
        for (i = 0; i < spaces - x.length(); i++)
            spc += " ";
        if (direction == LEFT)
            return x + spc;
        else
            return spc + x;
    }

    protected String formatFractionalPart(double x, int fracpart) {
        String fracstr = "";
        if (x < 0.0)
            x = -x;
        x -= (int) x;
        while (fracstr.length() < fracpart) {
            int xi;
            x *= 10;
            xi = (int) x;
            x -= xi;
            fracstr = fracstr + (char) (xi + '0');
        }
        return fracstr;
    }

    protected String formatDouble(double x, int intpart, int fracpart) {
        boolean neg = false;
        String fraction;
        if (x < 0.0) {
            neg = true;
            x = -x;
        }
        fraction = formatFractionalPart(x, fracpart);
        if (neg) {
            if (((int) x) == 0) {
                String intstr = "-0";
                while (intstr.length() < intpart)
                    intstr = " " + intstr;
                return intstr + "." + fraction;
            } else
                return formatInt(-((int) x), intpart,
                                 RIGHT) + "." + fraction;
        } else
            return formatInt(((int) x), intpart,
                             RIGHT) + "." + fraction;
    }

    protected class InputStreamFromStringBuilder extends InputStream {
        private int index;
        private String s;

        /**
         * Constructor.
         *
         * @param sb the StringBuilder to which this InputStream will append characters
         */
        public InputStreamFromStringBuilder(StringBuilder sb) {
            s = sb.toString();
        }

        /* (non-Javadoc)
         * @see java.io.InputStream#read()
         */
        public int read() {
            if (index >= s.length())
                return -1;
            return (int) s.charAt(index++);
        }
    }
}
