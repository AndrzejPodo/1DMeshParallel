package pl.edu.agh.macwozni.dmeshparallel.mesh;

public class CornerOfVertices {

    public Vertex upperVertex;
    public Vertex middleVertex;
    public Vertex lowerVertex;

    public CornerOfVertices(Vertex upperVertex, Vertex middleVertex, Vertex lowerVertex) {
        this.upperVertex = upperVertex;
        this.middleVertex = middleVertex;
        this.lowerVertex = lowerVertex;
    }
}
