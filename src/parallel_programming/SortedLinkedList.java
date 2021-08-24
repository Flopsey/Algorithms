package parallel_programming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class SortedLinkedList<T> {

    // ...
    abstract boolean remove(T item);
    // ...

    class Node {

        T item;
        int key;
        Node next;
        private final Lock lock = new ReentrantLock();

        Node(int key) {
            this.key = key;
        }

        Node(T item) {
            this.item = item;
            this.key = item.hashCode();
        }

        void lock() {
            lock.lock();
        }

        void unlock() {
            lock.unlock();
        }

    }

}
