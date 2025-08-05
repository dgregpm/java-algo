package utils;

public interface QueueX<T> {
    T poll();
    QueueX<T> offer(T obj);
    T peek();
    void reverse();
    int size();
}

