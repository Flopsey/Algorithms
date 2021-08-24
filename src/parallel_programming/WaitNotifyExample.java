package parallel_programming;

public class WaitNotifyExample extends Thread {

    private volatile static int men = 0;
    private volatile static int women = 0;
    private static final Object lock = new Object();

    public void femaleEnter() {
        synchronized (lock) {
            while (men > 0 || women > 2) {
                try {
                    lock.wait();
                } catch (InterruptedException ignored) { }
            }
            ++women;
        }
    }

    public void femaleExit() {
        synchronized (lock) {
            --women;
            lock.notifyAll();
        }
    }

    public void maleEnter() {
        synchronized (lock) {
            while (women > 0 || men > 2) {
                try {
                    lock.wait();
                } catch (InterruptedException ignored) {}
            }
            ++men;
        }
    }

    public void maleExit() {
        synchronized (lock) {
            --men;
            lock.notifyAll();
        }
    }

}
