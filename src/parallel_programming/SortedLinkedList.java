package parallel_programming;

abstract class SortedLinkedList<T> {

    // ...
    abstract boolean remove(T item);
    // ...

    class Node {

        T item;
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }

        Node(T item) {
            this.item = item;
            this.key = item.hashCode();
        }

    }

}
