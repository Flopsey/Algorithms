// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

import java.util.concurrent.atomic.AtomicBoolean;

public class TASLock {

    AtomicBoolean state = new AtomicBoolean(false);

    @SuppressWarnings("StatementWithEmptyBody")
    public void lock() {
        while (state.getAndSet(true));
    }

    public void unlock() {
        state.set(false);
    }

}
