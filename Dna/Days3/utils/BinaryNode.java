public class BinaryNode<T> {
    private T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T obj){
        this.data = obj;
    }

    public String toString(){
        return this.data.toString();
    }

    public T getData(){
        return this.data;
    }
}
