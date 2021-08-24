// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FineGrainedLockingExample<T> extends SortedLinkedList<T> {

    private final Node head;

    public FineGrainedLockingExample() {
        head = new Node(Integer.MIN_VALUE);
        head.next = new Node(Integer.MAX_VALUE);
    }

    // ...

    public boolean remove(T item) {
        int key = item.hashCode();
        head.lock();
        Node pred = head;
        try {
            Node curr = pred.next;
            curr.lock();
            try {
                while (curr.key < key) {
                    pred.unlock();
                    pred = curr;
                    curr = curr.next;
                    curr.lock();
                }
                if (key == curr.key) {
                    pred.next = curr.next;
                    return true;
                } else {
                    return false;
                }
            } finally {
                curr.unlock();
            }
        } finally {
            pred.unlock();
        }
    }

    // ...

    class Node extends SortedLinkedList<T>.Node {

        Node next;
        Lock lock = new ReentrantLock();

        Node(int key) {
            super(key);
        }

        Node(T item) {
            super(item);
        }

        void lock() {
            lock.lock();
        }

        void unlock() {
            lock.unlock();
        }

    }

}