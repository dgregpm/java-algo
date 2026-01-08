package utils;
    
public class HashNode<T,V> {
    private T key;
    private V value;
    public HashNode<T,V> next;

    HashNode(T key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public T getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }

    public void setValue(V value){
        this.value = value;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{ ").append(this.key);
        sb.append(" : ").append(this.value).append(" }");
        return sb.toString();
    }
}
