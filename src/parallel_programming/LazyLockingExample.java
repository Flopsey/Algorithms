// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

public abstract class LazyLockingExample<T> extends OptimisticLockingExample<T> {

    private final Node head;

    public LazyLockingExample() {
        head = new Node(Integer.MIN_VALUE);
        head.next = new Node(Integer.MAX_VALUE);
    }

    // ...

    public boolean remove(T item) {
        int key = item.hashCode();
        while (true) {
            Node pred = head;
            Node curr = pred.next;
            while (curr.key < key) {
                pred = curr;
                curr = curr.next;
            }
            pred.lock();
            curr.lock();
            try {
                if (validate(pred, curr)) {
                    if (key == curr.key) {
                        // logically remove
                        curr.marked = true;
                        // physically remove
                        pred.next = curr.next;
                        return true;
                    } else {
                        return false;
                    }
                }
            } finally {
                pred.unlock();
                curr.unlock();
            }
        }
    }

    public boolean contains(T item) {
        int key = item.hashCode();
        Node curr = head;
        while (curr.key < key) {
            curr = curr.next;
        }
        return curr.key == key && !curr.marked;
    }

    boolean validate(Node pred, Node curr) {
        // Both reachable and local state as expected
        return !pred.marked && !curr.marked && pred.next == curr.next;
    }

    class Node extends OptimisticLockingExample<T>.Node {

        Node next;
        boolean marked;

        Node(int key) {
            super(key);
        }

        Node(T item) {
            super(item);
            marked = false;
        }

    }

}
