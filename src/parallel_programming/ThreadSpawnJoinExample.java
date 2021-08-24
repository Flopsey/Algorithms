package parallel_programming;

public class ThreadSpawnJoinExample {

    public static void main(String[] args) {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; ++i) {
            Thread t = new Useless(i + 1);
            t.start();
            threads[i] = t;
        }
        for (int i = 0; i < 20; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All done.");
    }

}
