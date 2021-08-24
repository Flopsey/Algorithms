package parallel_programming;

import java.util.concurrent.Semaphore;

public class CyclicBarrier {

    private final int threshold;
    private int count = 0;
    private final Semaphore barrier1 = new Semaphore(0);
    private final Semaphore barrier2 = new Semaphore(1);

    public CyclicBarrier(int threshold) {
        this.threshold = threshold;
    }

    public void await() {
        synchronized (this) {
            ++count;
            if (count == threshold) {
                try {
                    barrier2.acquire();
                } catch (InterruptedException ignored) { }
                barrier1.release();
            }
        }
        try {
            barrier1.acquire();
        } catch (InterruptedException ignored) { }
        barrier1.release();
        synchronized (this) {
            --count;
            if (count == 0) {
                try {
                    barrier1.acquire();
                } catch (InterruptedException ignored) { }
                barrier2.release();
            }
        }
        try {
            barrier2.acquire();
        } catch (InterruptedException ignored) { }
        barrier2.release();
    }

}
