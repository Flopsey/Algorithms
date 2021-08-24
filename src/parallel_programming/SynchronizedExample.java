package parallel_programming;

public class SynchronizedExample {

    public static void main(String[] args) {
        Thread t1 = new SynchronizedCounter();
        Thread t2 = new SynchronizedCounter();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(SynchronizedCounter.cnt);  // 2000
    }

}

class SynchronizedCounter extends Thread {

    static int cnt = 0;
    static final Object lock = new Object();

    public void run() {
        for (int i = 0; i < 1000; ++i) {
            synchronized (lock) {
                ++cnt;
            }
        }
    }

}
