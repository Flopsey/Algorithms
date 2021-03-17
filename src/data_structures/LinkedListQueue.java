package data_structures;

public class LinkedListQueue<E> extends LinkedList<E> implements Queue<E> {

    public void enqueue(E e) {
        addLast(e);
    }

    public E dequeue() {
        return removeFirst();
    }

    public E front() {
        if (first == null) {
            return null;
        }
        return first.value;
    }

}
