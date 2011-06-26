package net.willware.eurydice.tests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Random;

import net.willware.eurydice.math.Matrix;
import net.willware.eurydice.math.Vector;

/**
 * CLASSPATH=eurydice.jar:/usr/share/java/junit.jar java net.willware.eurydice.tests.LinearAlgebraTests
 */
public class LinearAlgebraTests extends TestCase {

    // @Test
    public void testMatrixInverse() {
        Random r = new Random();
        Matrix m = new Matrix(
            r.nextDouble(),
            r.nextDouble(),
            r.nextDouble(),
            r.nextDouble(),
            r.nextDouble(),
            r.nextDouble(),
            r.nextDouble(),
            r.nextDouble(),
            r.nextDouble());
        assertTrue(new Matrix().approximatelyEqual(m.times(m.inverse())));
    }

    // @Test
    public void testMatrixRotations() {
        Vector v = new Vector(1, 2, 3);
        Matrix r = Matrix.rotationX(Math.PI / 2);
        assertTrue(r.times(v).approximatelyEqual(new Vector(1, 3, -2)));
        r = Matrix.rotationX(Math.PI / 4);
        assertTrue(r.times(v).approximatelyEqual(new Vector(1.0, 3.535534, 0.7071068)));
        r = Matrix.rotationY(Math.PI / 2);
        assertTrue(r.times(v).approximatelyEqual(new Vector(3, 2, -1)));
        r = Matrix.rotationY(Math.PI / 4);
        assertTrue(r.times(v).approximatelyEqual(new Vector(2.828427, 2, 1.414213)));
        r = Matrix.rotationZ(Math.PI / 2);
        assertTrue(r.times(v).approximatelyEqual(new Vector(2, -1, 3)));
        r = Matrix.rotationZ(Math.PI / 4);
        assertTrue(r.times(v).approximatelyEqual(new Vector(2.12132, 0.7071068, 3)));
    }

    public static Test suite() {
        return new TestSuite(LinearAlgebraTests.class);
    }

    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
