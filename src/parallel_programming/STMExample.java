// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

import scala.concurrent.stm.Ref;
import scala.concurrent.stm.TArray;
import scala.concurrent.stm.japi.STM;

abstract public class STMExample<T> {

    private final Ref.View<Integer> count = STM.newRef(0);
    private final Ref.View<Integer> tail = STM.newRef(0);
    private final TArray.View<T> items;

    public STMExample(int capacity) {
        items = STM.newTArray(capacity);
    }

    public void enq(final T x) {
        STM.atomic(() -> {
            if (count.get() == items.length()) {
                STM.retry();
            }
            items.update(tail.get(), x);
            tail.set((tail.get() + 1) % items.length());
            STM.increment(count, 1);
        });
    }

}
