package parallel_programming;

import java.util.concurrent.Semaphore;

public class SimpleBarrier {

    private final int threshold;
    private int count = 0;
    private final Semaphore barrier = new Semaphore(0);

    public SimpleBarrier(int threshold) {
        this.threshold = threshold;
    }

    public void await() {
        synchronized (this) {
            ++count;
        }
        if (count == threshold) {
            barrier.release();
        }
        try {
            barrier.acquire();
        } catch (InterruptedException ignored) { }
        barrier.release();
    }

}
