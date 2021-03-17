package data_structures;

public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E front();

}
