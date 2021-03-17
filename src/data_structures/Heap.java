package data_structures;

public class Heap<E extends Comparable<? super E>> implements PriorityQueue<E> {

    final LinkedList<E> heap;

    public Heap() {
        this.heap = new LinkedList<>();
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

    static int left(int index) {
        return 2 * index + 1;
    }

    static int right(int index) {
        return 2 * index + 2;
    }

    static int parent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public void insert(E e) {
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

    public boolean contains(Object o) {
        return heap.contains(o);
    }

    void restoreHeapCondition(int i) {
        while (left(i) < heap.size) {
            int j = left(i);
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
        return e1.compareTo(e2);
    }

}
