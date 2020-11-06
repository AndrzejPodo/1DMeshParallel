package pl.edu.agh.macwozni.dmeshparallel.production;

import pl.edu.agh.macwozni.dmeshparallel.parallelism.MyLock;

public abstract class AbstractProduction<P_in, P_out> implements IProduction<P_in, P_out> {

    private MyLock lock;
    private final PThread thread = new PThread();
    private final P_in obj;
    private P_out result;
    private final PDrawer<P_out> drawer;

    public AbstractProduction(P_in _obj, PDrawer<P_out> _drawer) {
        this.obj = _obj;
        this.drawer = _drawer;
    }

    @Override
    public P_out getObj() {
        return this.result;
    }

//run the thread
    @Override
    public void start() {
        thread.start();
    }

    @Override
    public void join() throws InterruptedException {
        thread.join();
    }

    @Override
    public void injectRefs(MyLock _lock) {
        this.lock = _lock;
    }

    private class PThread extends Thread {

        @Override
        public void run() {
            lock.lock();
            result = apply(obj);
            drawer.draw(result);
        }
    }
}
