package datastructures_for_dictionaries;

public class Stack<E> extends LinkedList<E> {

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return removeFirst();
    }

    public E top() {
        return first.value;
    }

}
