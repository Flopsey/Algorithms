package datastructures_for_dictionaries;

public interface PriorityQueue<E extends Comparable<? super E>> {

    void insert(E e);

    E extractMin();

    E getMin();

}
