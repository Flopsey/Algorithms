// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

import java.util.concurrent.atomic.AtomicBoolean;

public class TATASLock {

    AtomicBoolean state = new AtomicBoolean(false);

    @SuppressWarnings("StatementWithEmptyBody")
    public void lock() {
        do {
            while (state.get());
        } while (!state.compareAndSet(false, true));
    }

    public void unlock() {
        state.set(false);
    }

}
