package datastructures_for_dictionaries;

// See also: java.util.LinkedList
public class LinkedList<E> {

    /* TODO: Add tests */

    protected ListElement<E> first;
    protected ListElement<E> last;
    protected int size;

    public void addFirst(E e) {
        ListElement<E> newFirst = new ListElement<>(e);
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
        ListElement<E> newLast = new ListElement<>(e);
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
        if (!isEmpty()) {
            if (first.next != null) {
                first.next.prev = null;
            } else {
                last = null;
            }
            first = first.next;
            --size;
        }
        return retValue;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E retValue = last.value;
        if (!isEmpty()) {
            if (last.prev != null) {
                last.prev.next = null;
            } else {
                first = null;
            }
            last = last.prev;
            --size;
        }
        return retValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    java.util.Iterator<E> iterator() {
        return new Iterator();
    }

    @Override
    public String toString() {
        StringBuilder repr = new StringBuilder();
        java.util.Iterator<E> it = iterator();
        while (it.hasNext()) {
            repr.append(it.next());
            if (it.hasNext()) {
                repr.append(", ");
            }
        }
        return "[" + repr + "]";
    }

    protected static class ListElement<E> {
        protected final E value;
        protected ListElement<E> prev;
        protected ListElement<E> next;

        private ListElement(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private class Iterator implements java.util.Iterator<E> {

        private ListElement<E> current;

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
                throw new java.util.NoSuchElementException();
            }
            if (current == null) {
                current = first;
            } else {
                if (current.next == null) {
                    throw new java.util.NoSuchElementException();
                }
                current = current.next;
            }
            return current.value;
        }
    }

}
