package pl.edu.agh.macwozni.dmeshparallel.mesh;

public class SquareOfVertices {
    Vertex northWest;
    Vertex northEast;
    Vertex southWest;
    Vertex southEast;

    public SquareOfVertices(Vertex northWest, Vertex northEast, Vertex southWest, Vertex southEast){
        this.northWest = northWest;
        this.northEast = northEast;
        this.southEast = southEast;
        this.southWest = southWest;

        this.southEast.setWest(this.southWest);
        this.southWest.setEast(this.southEast);

        this.southEast.setNorth(this.northEast);
        this.northEast.setSouth(this.southEast);

        this.southWest.setNorth(this.northWest);
        this.northWest.setSouth(this.southWest);

        this.northWest.setEast(this.northEast);
        this.northEast.setWest(this.northWest);
    }
}
