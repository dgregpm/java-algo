package utils;

public class Node<T> {
    private T data;
    public Node<T> next;
    public Node<T> prev;

    public Node(T obj){
        this.data = obj;
    }

    public String toString(){
        return this.data.toString();
    }

    public T getData(){
        return this.data;
    }
}
