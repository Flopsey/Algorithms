package datastructures_for_dictionaries;

public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E front();

}
