package data_structures;

public interface PriorityQueue<E extends Comparable<? super E>> {

    void insert(E e);

    E extractMin();

    E getMin();

}
