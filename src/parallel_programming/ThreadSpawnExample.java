// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

public class ThreadSpawnExample {

    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) {
            Thread t = new Useless(i + 1);
            t.start();
        }
    }

}

class Useless extends Thread {

    int i;

    Useless(int i) {
        this.i = i;
    }

    public void run() {
        System.out.printf("Thread %d says hi\n", i);
        System.out.printf("Thread %d says bye\n", i);
    }

}
