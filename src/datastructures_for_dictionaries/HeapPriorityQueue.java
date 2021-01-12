package datastructures_for_dictionaries;

public class HeapPriorityQueue<E extends Comparable<? super E>> implements PriorityQueue<E> {

    private final LinkedList<E> heap;

    public HeapPriorityQueue() {
        this.heap = new LinkedList<>();
    }

    public static void main(String[] args) {
        // Example:
        PriorityQueue<Integer> prioQueue = new HeapPriorityQueue<>();
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
        heap.addFirst(e);
        restoreHeapCondition();
    }

    @Override
    public E extractMin() {
        E element = heap.removeFirst();
        restoreHeapCondition();
        return element;
    }

    private void restoreHeapCondition() {
        int i = 0;
        while (2 * (i + 1) - 1 < heap.size) {
            int j = 2 * (i + 1) - 1;
            if (j + 1 < heap.size) {
                if (heap.get(j).compareTo(heap.get(j + 1)) > 0) {
                    ++j;
                }
            }
            if (heap.get(i).compareTo(heap.get(j)) <= 0) {
                return;
            }
            E temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
            i = j;
        }
    }

}
