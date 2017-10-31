package pl.edu.agh.macwozni.dmeshparallel;

import pl.edu.agh.macwozni.dmeshparallel.myProductions.P2;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P6;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P1;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P5;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P3;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;
import pl.edu.agh.macwozni.dmeshparallel.parallelism.BlockRunner;
import pl.edu.agh.macwozni.dmeshparallel.production.PDrawer;

public class Executor extends Thread {

    private final BlockRunner runner;
    private final PDrawer drawer;

    public Executor(BlockRunner _runner, PDrawer _drawer) {
        this.runner = _runner;
        this.drawer = _drawer;
    }

    @Override
    public void run() {

        //axiom
        Vertex s = new Vertex(null, null, "S");

        //p1 
        P1 p1 = new P1(s, this.drawer);
        this.runner.addThread(p1);

        //start threads
        this.runner.startAll();

        //p2,p3
        P2 p2 = new P2(p1.getObj(), this.drawer);
        P3 p3 = new P3(p1.getObj().getRight(), this.drawer);
        this.runner.addThread(p2);
        this.runner.addThread(p3);

        //start threads
        this.runner.startAll();

        //p5^2,p6^2
        P5 p5A = new P5(p2.getObj(), this.drawer);
        P5 p5B = new P5(p3.getObj().getRight(), this.drawer);
        P6 p6A = new P6(p2.getObj().getRight(), this.drawer);
        P6 p6B = new P6(p3.getObj(), this.drawer);
        this.runner.addThread(p5A);
        this.runner.addThread(p5B);
        this.runner.addThread(p6A);
        this.runner.addThread(p6B);

        //start threads
        this.runner.startAll();

        //done
        System.out.println("done");
        drawer.draw(p6B.getObj());

    }
}
