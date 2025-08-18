package utils;

public class HashMapX<T,V> {

    private class HashNode<K,D>{
        private D data;
        private K key;
        public HashNode<K,D> prev;
        public HashNode<K,D> next;
        public HashNode<K,D> nextKey;

        HashNode(K key, D data){
            this.key = key;
            this.data = data;
        }
        public K getKey(){
            return this.key;
        }
        public D getData(){
            return this.data;        
        }
        public void setData(D d){
            this.data = d;
        }
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("[ Key: ").append(this.key).append(", Value: ").append(this.data).append(" ]");
            return sb.toString();
        }
    }
    
    public HashMapX() {

    }

    public V get(T key) {
        return null;
    }
    
    public void set(T key, V value) {

    }

    public V delete(T key) {
        return null;
    }

    public int size() {
        return 0;
    }
}
