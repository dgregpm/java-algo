package utils;

public class BinaryNode<T> {
    private T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T obj){
        this.data = obj;
    }

    public T getData(){
        return this.data;
    }
}
