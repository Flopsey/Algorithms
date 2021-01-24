package datastructures_for_dictionaries;

public interface PriorityQueue<E> {

    void insert(E e);

    E extractMin();

    E getMin();

    <V extends Comparable<V>> void decreaseKey(V value, int key);

    class KeyValuePair<V extends Comparable<V>> implements Comparable<KeyValuePair<V>> {

        public final V value;
        protected int key;

        public KeyValuePair(V value, int key) {
            this.value = value;
            this.key = key;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof KeyValuePair) {
                return value.equals(((KeyValuePair<?>) obj).value);
            } else {
                return super.equals(obj);
            }
        }

        @Override
        public int compareTo(KeyValuePair<V> p) {
            return value.compareTo(p.value);
        }

    }

}
