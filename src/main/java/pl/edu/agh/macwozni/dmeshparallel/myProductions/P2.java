package pl.edu.agh.macwozni.dmeshparallel.myProductions;

import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;
import pl.edu.agh.macwozni.dmeshparallel.production.AbstractProduction;
import pl.edu.agh.macwozni.dmeshparallel.production.PDrawer;

public class P2 extends AbstractProduction<Vertex, Vertex> {

    public P2(Vertex _obj, PDrawer<Vertex> _drawer) {
        super(_obj, _drawer);
    }

    @Override
    public Vertex apply(Vertex m1) {
        System.out.println("p2");
        Vertex m2 = new Vertex("M");
        m1.setNorth(m2);
        m2.setSouth(m1);
        return m2;
    }
}
