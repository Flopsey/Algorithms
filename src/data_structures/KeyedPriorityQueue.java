package data_structures;

public interface KeyedPriorityQueue<V> {

    void insert(V value, double key);

    V extractMin();

    V getMin();

    void decreaseKey(V value, double newKey);

}
