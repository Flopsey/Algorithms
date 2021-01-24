package datastructures_for_dictionaries;

import java.util.Comparator;

public class Heap<E> implements PriorityQueue<E> {

    private final LinkedList<E> heap;
    private final Comparator<? super E> comparator;

    public Heap() {
        this(null);
    }

    public Heap(Comparator<? super E> comparator) {
        this.heap = new LinkedList<>();
        this.comparator = comparator;
    }

    public static void main(String[] args) {
        // Example:
        PriorityQueue<Integer> prioQueue = new Heap<>();
        int[] keys = {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        for (int key : keys) {
            prioQueue.insert(key);
        }
        System.out.print(prioQueue.extractMin());
        for (int i = 0; i < keys.length - 1; ++i) {
            System.out.print(", " + prioQueue.extractMin());
        }
        System.out.println();  // 27, 34, 39, 48, 70, 86, 87, 91, 95, 100]
        System.out.println(prioQueue.extractMin());  // null
    }

    @Override
    public void insert(E e) {
        if (comparator == null && !(e instanceof Comparable)) {
            throw new IllegalArgumentException("Entry " + e + " is not comparable");
        }

        heap.addFirst(e);
        restoreHeapCondition(0);
    }

    @Override
    public E extractMin() {
        E element = heap.removeFirst();
        restoreHeapCondition(0);
        return element;
    }

    @Override
    public E getMin() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    @Override
    public <V extends Comparable<V>> void decreaseKey(V value, int key) {
        int index = heap.indexOf(value);
        if (index < 0) {
            throw new IllegalArgumentException("Entry not found in heap");
        }
        KeyValuePair<V> entry = (KeyValuePair<V>) heap.get(index);
        if (entry.key > key) {
            throw new IllegalArgumentException("New key is greater than previous");
        }
        entry.key = key;
        restoreHeapCondition(index);
    }

    public boolean contains(Object o) {
        return heap.contains(o);
    }

    private void restoreHeapCondition(int i) {
        while (2 * (i + 1) - 1 < heap.size) {
            int j = 2 * (i + 1) - 1;
            if (j + 1 < heap.size) {
                if (compare(heap.get(j), heap.get(j + 1)) > 0) {
                    ++j;
                }
            }
            if (compare(heap.get(i), heap.get(j)) <= 0) {
                return;
            }
            E temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
            i = j;
        }

    }

    private int compare(E e1, E e2) {
        if (comparator == null) {
            return ((Comparable<? super E>) e1).compareTo(e2);
        } else {
            return comparator.compare(e1, e2);
        }
    }

}
