public class BinaryNode<T> {
    private T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    BinaryNode(T obj){
        this.data = obj;
    }

    public T getData(){
        return this.data;
    }

    public String toString(){
        return this.data.toString();
    }
}