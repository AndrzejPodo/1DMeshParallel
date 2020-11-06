package pl.edu.agh.macwozni.dmeshparallel.mesh;

public class Vertex {

    // label
    String mLabel;
    // links to adjacent elements
    Vertex mEast;
    Vertex mWest;
    Vertex mSouth;
    Vertex mNorth;

    // empty constructor

    public Vertex(String label) {
        this.mLabel = label;
    }

    public void setEast(Vertex _east) {
        this.mEast = _east;
    }

    public void setWest(Vertex _west) {
        this.mWest = _west;
    }

    public void setSouth(Vertex _south) {
        this.mSouth = _south;
    }

    public void setNorth(Vertex _north) {
        this.mNorth = _north;
    }

    public void setLabel(String _lab) {
        this.mLabel = _lab;
    }

    public Vertex getEast() {
        return this.mEast;
    }

    public Vertex getWest() {
        return this.mWest;
    }

    public Vertex getSouth() {
        return this.mSouth;
    }

    public Vertex getNorth() {
        return this.mNorth;
    }

    public String getLabel() {
        return this.mLabel;
    }
}
