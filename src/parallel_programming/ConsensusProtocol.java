// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

public abstract class ConsensusProtocol<T> {

    int n;
    protected T[] proposed = (T[]) new Object[n];

    // Announce my input value to the other threads
    void propose(T value) {
        proposed[(int) Thread.currentThread().getId()] = value;
    }

    // Figure out which thread was first
    abstract public T decide(T value);

}
