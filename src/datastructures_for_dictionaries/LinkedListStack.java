package datastructures_for_dictionaries;

public class LinkedListStack<E> extends LinkedList<E> implements Stack<E> {

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public E top() {
        return first.value;
    }

}
