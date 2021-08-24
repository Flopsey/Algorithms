package parallel_programming;

abstract class SortedLinkedList<T> {

    abstract boolean add(T item);
    abstract boolean remove(T item);
    abstract boolean contains(T item);

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
