package pl.edu.agh.macwozni.dmeshparallel.myProductions;

import pl.edu.agh.macwozni.dmeshparallel.mesh.CornerOfVertices;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;
import pl.edu.agh.macwozni.dmeshparallel.production.AbstractProduction;
import pl.edu.agh.macwozni.dmeshparallel.production.PDrawer;

public class P4 extends AbstractProduction<CornerOfVertices, Vertex> {

    public P4(CornerOfVertices _obj, PDrawer<Vertex> _drawer) {
        super(_obj, _drawer);
    }

    @Override
    public Vertex apply(CornerOfVertices c) {
        System.out.println("p4");
        Vertex m = new Vertex("M");
        
        c.upperVertex.setEast(m);
        m.setWest(c.upperVertex);

        c.lowerVertex.setNorth(m);
        m.setSouth(c.lowerVertex);

        return m;
    }
}
