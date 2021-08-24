// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("NonAtomicOperationOnVolatileField")
public class WaitNotifyConditionsExample extends Thread {

    private volatile static int men = 0;
    private volatile static int women = 0;
    private static final Lock l = new ReentrantLock();
    private static final Condition menQueue = l.newCondition();
    private static final Condition womenQueue = l.newCondition();

    public void femaleEnter() {
        l.lock();
        while (men > 0 || women > 2) {
            try {
                womenQueue.await();
            } catch (InterruptedException ignored) { }
        }
        ++women;
        l.unlock();
    }

    public void femaleExit() {
        l.lock();
        --women;
        if (women == 0) {
            menQueue.signalAll();
        } else {
            womenQueue.signal();
        }
        l.unlock();
    }

    public void maleEnter() {
        l.lock();
        while (women > 0 || men > 2) {
            try {
                menQueue.await();
            } catch (InterruptedException ignored) { }
        }
        ++men;
        l.unlock();
    }

    public void maleExit() {
        l.lock();
        --men;
        if (men == 0) {
            womenQueue.signalAll();
        } else {
            menQueue.signal();
        }
        l.unlock();
    }

}
