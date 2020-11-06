package pl.edu.agh.macwozni.dmeshparallel.production;

import pl.edu.agh.macwozni.dmeshparallel.parallelism.MyLock;

public interface IProduction<P_in, P_out> {

    public P_out apply(P_in _p);

    public void join() throws InterruptedException;

    public void start();

    public void injectRefs(MyLock _lock);

    public P_out getObj();
}
