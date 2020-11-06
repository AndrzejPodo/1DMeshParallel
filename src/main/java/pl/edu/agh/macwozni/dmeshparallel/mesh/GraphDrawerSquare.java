package pl.edu.agh.macwozni.dmeshparallel.mesh;

import pl.edu.agh.macwozni.dmeshparallel.production.PDrawer;

public class GraphDrawerSquare implements PDrawer<SquareOfVertices> {

    @Override
    public void draw(SquareOfVertices p) {
        // TODO Auto-generated method stub
        PDrawer<Vertex> drawer = new GraphDrawer();
        drawer.draw(p.northEast);
    }
    
}
