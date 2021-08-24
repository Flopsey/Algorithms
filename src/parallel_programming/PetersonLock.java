// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

public class PetersonLock {

    private final boolean[] flag = new boolean[2];
    private volatile int victim;

    @SuppressWarnings("StatementWithEmptyBody")
    public void lock(int id) {
        flag[id] = true;
        victim = id;
        while (flag[1 - id] && victim == id);
    }

    public void unlock(int id) {
        flag[id] = false;
    }

}
