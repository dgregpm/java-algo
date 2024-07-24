package utils;

public class Node<T> {
    private T data;
    public Node<T> next;
    public Node<T> prev;

    public Node(T obj){
        this.data = obj;
    }

    public T getData(){
        return this.data;
    }
    
    public String toString(){
        return this.data.toString();
    }
}
