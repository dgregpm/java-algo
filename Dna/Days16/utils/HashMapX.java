package utils;

public class HashMapX<T,V> {

    private class HashNode<K,D>{
        private D data;
        private K key;
        HashNode(K key, D data){
            this.key = key;
            this.data = data;
        }
        public K getKey(){
            return this.key;
        }
        public D getData(){
            
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
