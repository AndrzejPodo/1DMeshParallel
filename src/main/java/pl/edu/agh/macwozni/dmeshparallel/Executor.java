package pl.edu.agh.macwozni.dmeshparallel;

import pl.edu.agh.macwozni.dmeshparallel.myProductions.P2;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P1;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P3;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P4;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;
import pl.edu.agh.macwozni.dmeshparallel.mesh.CornerOfVertices;
import pl.edu.agh.macwozni.dmeshparallel.mesh.GraphDrawer;
import pl.edu.agh.macwozni.dmeshparallel.mesh.GraphDrawerSquare;
import pl.edu.agh.macwozni.dmeshparallel.parallelism.BlockRunner;
import pl.edu.agh.macwozni.dmeshparallel.production.PDrawer;

public class Executor extends Thread {

    private final BlockRunner runner;

    public Executor(BlockRunner _runner) {
        this.runner = _runner;
    }

    @Override
    public void run() {

        PDrawer drawer = new GraphDrawer();
        PDrawer squareDrawer = new GraphDrawerSquare();
        // axiom
        Vertex s = new Vertex("S");

        // p1
        P1 p1 = new P1(s, drawer);
        this.runner.addThread(p1);

        // start threads
        this.runner.startAll();

        // //p2,p3
        P2 p2 = new P2(p1.getObj(), drawer);
        P3 p3 = new P3(p1.getObj(), drawer);

        this.runner.addThread(p2);
        this.runner.addThread(p3);

        // start threads
        this.runner.startAll();

        // p2A, p3A, p4
        P2 p2a = new P2(p2.getObj(), drawer);
        P3 p3a = new P3(p3.getObj(), drawer);
        CornerOfVertices c1 = new CornerOfVertices(p2.getObj(), p1.getObj(), p3.getObj());
        P4 p4 = new P4(c1, drawer);

        this.runner.addThread(p2a);
        this.runner.addThread(p3a);
        this.runner.addThread(p4);

        // start threads
        this.runner.startAll();

        // p4A, p4B
        CornerOfVertices c2 = new CornerOfVertices(p2a.getObj(), p2.getObj(), p4.getObj());
        CornerOfVertices c3 = new CornerOfVertices(p4.getObj(), p3.getObj(), p3a.getObj());
        P4 p4a = new P4(c2, drawer);
        P4 p4b = new P4(c3, drawer);

        this.runner.addThread(p4a);
        this.runner.addThread(p4b);

        //start threads
        this.runner.startAll();

        //p4c
        CornerOfVertices c4 = new CornerOfVertices(p4a.getObj(), p4.getObj(), p4b.getObj());
        P4 p4c = new P4(c4, drawer);
        this.runner.addThread(p4c);
        
        this.runner.startAll();
        // done
        System.out.println("done");

        drawer.draw(p3.getObj());

    }
}
