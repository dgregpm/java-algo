package utils;

public class Node<T> {
    private T data;
    public Node<T> prev;
    public Node<T> next;

    Node(T obj){
        this.data = obj;
    }

    public T getData(){
        return this.data;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ Data: ").append(data).append(", Next: ").append(next).append(" ]");
        return sb.toString();
    }
}
