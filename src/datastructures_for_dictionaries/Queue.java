package datastructures_for_dictionaries;

public class Queue<E> extends LinkedList<E> {

    public void enqueue(E e) {
        addLast(e);
    }

    public E dequeue(E e) {
        return removeFirst();
    }

}
