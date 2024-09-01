package utils;

public class HashNode<K, V> {
    private K key;
    private V value;
    public HashNode<K, V> next;

    public HashNode(K k, V v){
        this.key = k;
        this.value = v;
    }

    public K getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }

    public void setValue(V v){
        this.value = v;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        HashNode<K, V> curr = this;
        while(curr != null){
            sb.append("[").append(curr.getKey()).append("->").append(curr.getValue()).append("] ");
            curr = curr.next;
        }
        return sb.toString();
    }
}
