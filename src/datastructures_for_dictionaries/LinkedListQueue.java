package datastructures_for_dictionaries;

public class LinkedListQueue<E> extends LinkedList<E> implements Queue<E> {

    public void enqueue(E e) {
        addLast(e);
    }

    public E dequeue() {
        return removeFirst();
    }

}
