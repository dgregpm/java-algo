package utils;

public interface List<T> {
    List<T> prepend(T obj);
    List<T> append(T obj);
    void insertAt(T obj, int idx);
    T remove(T obj);
    T removeAt(int idx);
    int size();
    void reverse();
    T get(int idx);
    void set(T obj, int idx);
}
