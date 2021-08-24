// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

public class FilterLock {

    volatile int[] level;
    volatile int[] victim;
    volatile int n;

    public FilterLock(int n) {
        this.n = n;
        level = new int[n];
        victim = new int[n];
        for (int i = 0; i < n; ++i) {
            level[i] = 0;
        }
    }

    private boolean others(int id, int lev) {
        for (int k = 0; k < n; ++k) {
            if (k != id && level[k] >= lev) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void lock(int id) {
        for (int i = 1; i < n; ++i) {
            level[id] = i;
            victim[i] = id;
            while (others(id, i) && victim[i] == id) { }
        }
    }

    public void unlock(int id) {
        level[id] = 0;
    }

}
