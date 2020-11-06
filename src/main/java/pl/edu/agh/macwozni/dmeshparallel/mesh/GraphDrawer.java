package pl.edu.agh.macwozni.dmeshparallel.mesh;

import pl.edu.agh.macwozni.dmeshparallel.production.PDrawer;

public class GraphDrawer implements PDrawer<Vertex> {

    @Override
    public void draw(Vertex v) {
        // go west
        while (v.mWest != null) {
            v = v.mWest;
        }

        // go south
        while (v.mNorth != null) {
            v = v.mNorth;
        }

        // plot
        Vertex lineBeginning = v, _v;
        while (lineBeginning != null) {
            v = lineBeginning;
            _v = v;
            lineBeginning = lineBeginning.mSouth;
            // firstly lets print labels
            while (v != null) {
                System.out.print(v.mLabel);
                if (v.mEast != null) {
                    System.out.print("--");
                }
                v = v.mEast;
            }
            System.out.println("");
            v = _v;
            // secondly lets print links
            while (v != null) {
                if (v.mSouth != null) {
                    System.out.print("|  ");
                } else {
                    System.out.print("   ");
                }
                v = v.mEast;
            }
            System.out.println("");
        }
    }
}
