package net.willware.eurydice.gwttest;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.core.StructureImpl;
import net.willware.eurydice.elements.Carbon;
import net.willware.eurydice.forcefields.mm2.MM2;
import net.willware.eurydice.math.Quaternion;
import net.willware.eurydice.math.Vector;

import com.google.gwt.core.client.EntryPoint;

public class GwtTest implements EntryPoint {
    private Atom a;
    private StructureImpl s;
    private Quaternion q;
    private MM2 mm2;
    public void onModuleLoad() {
        a = new Carbon();
        s = new StructureImpl(null);
        s.getMetadata().put("here is", "some metadata");
        q = new Quaternion(1, new Vector());
        mm2 = new MM2(s);
        q.setImaginary(q.rotate(new Vector(3.1415926, 2.718281828, 1.2345678)));
    }
    public Atom getA() {
        return a;
    }
    public StructureImpl getS() {
        return s;
    }
    public Quaternion getQ() {
        return q;
    }
    public MM2 getMm2() {
        return mm2;
    }
}
