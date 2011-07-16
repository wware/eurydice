package net.willware.eurydice.gwttest;

import com.google.gwt.core.client.EntryPoint;

import net.willware.eurydice.core.Atom;
import net.willware.eurydice.elements.ElementFactory;
import net.willware.eurydice.forcefields.mm2.MM2;
import net.willware.eurydice.math.Quaternion;
import net.willware.eurydice.math.Vector;
import net.willware.eurydice.core.ImplFactory;
import net.willware.eurydice.core.Structure;
import net.willware.eurydice.core.StructureMutable;

public class GwtTest implements EntryPoint {
    private Atom a;
    private StructureMutable s;
    private Quaternion q;
    private MM2 mm2;
    public void onModuleLoad() {
        a = ElementFactory.getInstance().get("Carbon");
        s = (StructureMutable) ImplFactory.getInstance().get(Structure.class);
        s.addAtom(a);
        s.getMetadata().put("here is", "some metadata");
        q = new Quaternion(1, new Vector());
        mm2 = new MM2();
        mm2.setStructure(s);
        q.setImaginary(q.rotate(new Vector(3.1415926, 2.718281828, 1.2345678)));
    }
    public Atom getA() {
        return a;
    }
    public StructureMutable getS() {
        return s;
    }
    public Quaternion getQ() {
        return q;
    }
    public MM2 getMm2() {
        return mm2;
    }
}
