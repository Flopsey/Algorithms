package datastructures_for_dictionaries;

public interface Dictionary<E> {

    boolean search(E e);

    void insert(E e);

    void remove(E e);

}
