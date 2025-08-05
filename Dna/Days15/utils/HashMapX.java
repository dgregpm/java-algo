package utils;



public class HashMapX<T,V> {
    private class HashNodeX<K,D> {
        private K key;
        private D data;
        public HashMapX<K,D> next;
        public HashNodeX<K,D> nextKey;
        public HashNodeX<K,D> prevKey;
        
        public HashNodeX(K key, D data){
            this.key = key;
            this.data = data;
        }

        public K getKey(){
            return this.key;
        }

        public D getData(){
            return this.data;
        }

        public void setData(D data){
            this.data = data;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder("[ ");
            sb.append("Key: ").append(this.key.toString()).append(", ").append("Value: ").append(this.data.toString()).append(" ]");
            return sb.toString();
        }
    }

    private int length;
    private int capacity;
    private HashNodeX<T,V> keyHead;
    private HashNodeX<T,V>[] table;

    public HashMapX() {
        this.length = 0;
        this.capacity = 4;
        this.table = new HashMapX[this.capacity];
    }

    private void capacityCheck(){
        double ub;
        if(length == 0){
            ub = 1;
        } else{
            ub = Math.ceil(Math.log(this.length)/Math.log(2));
        }
        int limit = (int)Math.pow(2,ub);
        int newLimit = (int)Math.pow(2,ub+1);
        int reduce = (int)Math.pow(2,ub-2);
        if(this.capacity <= limit || this.length < reduce){
            this.capacity = newLimit;
            HashMapX<T,V>[] nTable = 
        }
    }

    private int hashFn(T key){
        int hash = key.hashCode() % this.capacity;
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
        return this.length;
    }
}
