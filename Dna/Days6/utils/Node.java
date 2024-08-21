package utils;

public class Node<T> {
    private T data;
    public Node<T> prev;
    public Node<T> next;

    public Node(T obj){
        this.data = obj;
    }

    public T getData(){
        return this.data;
    }

    @Override
    public String toString(){
        return this.data.toString();
    }

    public void setData(T obj){
        this.data = obj;
    }
}
