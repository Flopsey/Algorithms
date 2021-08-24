// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

import java.util.concurrent.atomic.AtomicBoolean;

public class TASConsensusProtocol<T> extends ConsensusProtocol<T> {

    static AtomicBoolean x = new AtomicBoolean(false);
    protected T[] proposed = (T[]) new Object[2];

    public T decide(T value) {
        propose(value);
        boolean val = tas(x);
        if (val) {
            return value;
        } else {
            return proposed[1 - (int) Thread.currentThread().getId()];
        }
    }

    private static boolean tas(AtomicBoolean x) {
        return !x.getAndSet(true);
    }

}
