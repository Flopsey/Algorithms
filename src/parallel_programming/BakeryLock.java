// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

public class BakeryLock {

    volatile boolean[] flag;
    volatile int[] label;
    final int n;

    public BakeryLock(int n) {
        this.n = n;
        flag = new boolean[n];
        label = new int[n];
    }

    private boolean conflict(int id) {
        for (int i = 0; i < n; ++i) {
            if (i != id && flag[i]) {
                int diff = label[i] - label[id];
                if (diff < 0 || diff == 0 && i < id) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void lock(int id) {
        flag[id] = true;

        // find maximum label and increment by 1
        label[id] = label[0];
        for (int i = 1; i < n; ++i) {
            label[id] = Math.max(label[i], label[id]);
        }
        ++label[id];

        // Waiting section
        while (conflict(id)) { }
    }

    public void unlock(int id) {
        flag[id] = false;
    }

}
