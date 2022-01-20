package data_structures;

import java.util.NoSuchElementException;

// See also: java.util.LinkedList
public class LinkedList<E> implements Iterable<E>, Stack<E>, Queue<E> {

    /* TODO: Add tests */

    protected ListNode<E> first;
    protected ListNode<E> last;
    protected int size;

    public static <E> LinkedList<E> from(Iterable<? extends E> iterable) {
        LinkedList<E> list = new LinkedList<>();
        for (E e : iterable) {
            list.addLast(e);
        }
        return list;
    }

    public E get(int index) {
        return getNode(index).value;
    }

    public void set(int index, E value) {
        getNode(index).value = value;
    }

    private ListNode<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<E> cur;
        if (index <= size / 2) {
            cur = first;
            for (int j = 0; j < index; ++j) {
                cur = cur.next;
            }
        } else {
            cur = last;
            for (int j = size - 1; j > index; --j) {
                cur = cur.prev;
            }
        }
        return cur;
    }

    public void addFirst(E value) {
        ListNode<E> newFirst = new ListNode<>(value);
        if (isEmpty()) {
            last = newFirst;
        } else {
            first.prev = newFirst;
            newFirst.next = first;
        }
        first = newFirst;
        ++size;
    }

    public void addLast(E value) {
        ListNode<E> newLast = new ListNode<>(value);
        if (isEmpty()) {
            first = newLast;
        } else {
            last.next = newLast;
            newLast.prev = last;
        }
        last = newLast;
        ++size;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = first.value;
        if (first == last) {
            clear();
        } else {
            first = first.next;
            first.prev = null;
            --size;
        }
        return value;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E value = last.value;
        if (first == last) {
            clear();
        } else {
            last = last.prev;
            last.next = null;
            --size;
        }
        return value;
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
        for (E value : this) {
            if (o.equals(value)) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<>() {
            private ListNode<E> cur = first;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public E next() {
                if (cur == null) {
                    throw new NoSuchElementException();
                }
                ListNode<E> next = cur;
                cur = cur.next;
                return next.value;
            }
        };
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

    @Override
    public void push(E value) {
        addFirst(value);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public E top() {
        return !isEmpty() ? get(0) : null;
    }

    @Override
    public void enqueue(E value) {
        addLast(value);
    }

    @Override
    public E dequeue() {
        return removeFirst();
    }

    @Override
    public E front() {
        return !isEmpty() ? get(0) : null;
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

}
