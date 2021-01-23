package datastructures_for_dictionaries;

import java.util.NoSuchElementException;

// See also: java.util.LinkedList
public class LinkedList<E> implements Iterable<E> {

    /* TODO: Add tests */

    protected ListNode<E> first;
    protected ListNode<E> last;
    protected int size;

    public E get(int i) {
        return getNode(i).value;
    }

    public void set(int i, E value) {
        getNode(i).value = value;
    }

    private ListNode<E> getNode(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<E> node;
        if (i <= size / 2) {
            node = first;
            for (int j = 0; j < i; ++j) {
                node = node.next;
            }
        } else {
            node = last;
            for (int j = size - 1; j > i; --j) {
                node = node.prev;
            }
        }
        return node;
    }

    public void addFirst(E e) {
        ListNode<E> newFirst = new ListNode<>(e);
        if (isEmpty()) {
            last = newFirst;
        } else {
            newFirst.next = first;
            first.prev = newFirst;
        }
        first = newFirst;
        ++size;
    }

    public void addLast(E e) {
        ListNode<E> newLast = new ListNode<>(e);
        if (isEmpty()) {
            first = newLast;
        } else {
            newLast.prev = last;
            last.next = newLast;
        }
        last = newLast;
        ++size;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E retValue = first.value;
        if (first.next != null) {
            first.next.prev = null;
        } else {
            last = null;
        }
        first = first.next;
        --size;
        return retValue;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E retValue = last.value;
        if (last.prev != null) {
            last.prev.next = null;
        } else {
            first = null;
        }
        last = last.prev;
        --size;
        return retValue;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public int indexOf(Object o) {
        int i = 0;
        for (E e : this) {
            if (o.equals(e)) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    public java.util.Iterator<E> iterator() {
        return new Iterator();
    }

    @Override
    public String toString() {
        StringBuilder repr = new StringBuilder();
        for (java.util.Iterator<E> i = iterator(); i.hasNext(); ) {
            repr.append(i.next());
            if (i.hasNext()) {
                repr.append(", ");
            }
        }
        return "[" + repr + "]";
    }

    protected static class ListNode<E> {
        protected E value;
        protected ListNode<E> prev;
        protected ListNode<E> next;

        private ListNode(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private class Iterator implements java.util.Iterator<E> {

        private ListNode<E> current;

        @Override
        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            } else if (current == null) {
                return true;
            }
            return current.next != null;
        }

        @Override
        public E next() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            if (current == null) {
                current = first;
            } else {
                if (current.next == null) {
                    throw new NoSuchElementException();
                }
                current = current.next;
            }
            return current.value;
        }
    }

}
