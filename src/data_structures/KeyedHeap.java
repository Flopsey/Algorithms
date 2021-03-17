package data_structures;

public class KeyedHeap<V> implements KeyedPriorityQueue<V> {

    private final Heap<KeyValuePair> heap;

    public KeyedHeap() {
        this.heap = new Heap<>();
    }

    @Override
    public void insert(V value, double key) {
        heap.insert(new KeyValuePair(value, key));
    }

    @Override
    public V extractMin() {
        return heap.extractMin().value;
    }

    @Override
    public V getMin() {
        return heap.getMin().value;
    }

    @Override
    public void decreaseKey(V value, double key) {
        LinkedList<KeyValuePair> rawHeap = heap.heap;
        int index = 0;
        boolean found = false;
        for (KeyValuePair p : rawHeap) {
            if (p.value.equals(value)) {
                found = true;
                break;
            }
            ++index;
        }
        if (!found) {
            throw new IllegalArgumentException("Entry not found in heap");
        }
        KeyValuePair entry = rawHeap.get(index);
        if (key > entry.key) {
            throw new IllegalArgumentException("New key is greater than previous");
        }
        entry.key = key;

        // https://de.wikipedia.org/w/index.php?title=Binärer_Heap&curid=40416#Decrease-Key
        while (index >= 0 && rawHeap.get(index).key < rawHeap.get(Heap.parent(index)).key) {
            KeyValuePair temp = rawHeap.get(index);
            rawHeap.set(index, rawHeap.get(Heap.parent(index)));
            rawHeap.set(Heap.parent(index), temp);
            index = Heap.parent(index);
        }
    }

    public boolean contains(Object o) {
        return heap.contains(o);
    }

    class KeyValuePair implements Comparable<KeyValuePair> {

        public final V value;
        protected double key;

        public KeyValuePair(V value, double key) {
            this.value = value;
            this.key = key;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof KeyedHeap.KeyValuePair) {
                return value.equals(((KeyValuePair) obj).value);
            }
            return super.equals(obj);
        }

        @Override
        public int compareTo(KeyValuePair p) {
            return Double.compare(key, p.key);
        }

        @Override
        public String toString() {
            return "(" + value + ", " + key + ")";
        }
    }

}
