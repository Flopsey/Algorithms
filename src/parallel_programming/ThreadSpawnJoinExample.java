// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

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
            } catch (InterruptedException ignored) { }
        }
        System.out.println("All done.");
    }

}
