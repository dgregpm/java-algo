package utils;

public class HashMapX<T,V> {
    private int length;
    private int capacity;
    private HashNode<T,V>[] table;
    private HashNode<T,V> keyHead;

    private class HashNode<K,D>{
        private K key;
        private D value;
        public HashNode<K,D> next;
        public HashNode<K,D> nextKey;
        public HashNode<K,D> prevKey;

        HashNode(K k, D d){
            this.key = k;
            this.value = d;
        }

        public K getKey(){
            return this.key;
        }

        public D getValue(){
            return this.value;
        }

        public void setValue(D d){
            this.value = d;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("{ ").append(this.key).append(",").append(this.value).append(" }");
            return sb.toString();
        }
    }

    private int getHash(T key){
        int hash = key.hashCode() % this.capacity;
        return Math.abs(hash);
    }

    private void capacityCheck(){
        double loadFactor = this.length/this.capacity;
        if(loadFactor > .75){
            this.capacity *= 2;
            HashNode<T,V>[] other = new HashNode[this.capacity];
            for (int i = 0; i < this.table.length; i++) {
                HashNode<T,V> curr = this.table[i]; 
                HashNode<T,V> prev = null;
                while(curr != null){
                    int hash = this.getHash(curr.getKey());
                    HashNode<T,V> c = other[hash];
                    HashNode<T,V> p = null;
                    if(c == null){
                        other[hash] = curr;
                    } else {
                        while(c != null){
                            p = c;
                            c = c.next;
                        }
                        p.next = curr;
                    }

                    prev = curr;
                    curr = curr.next;
                    prev.next = null;   
                }
                this.table[i] = null;
            }
            this.table = other;
        }
    }
    
    public HashMapX() {
        this.capacity = 4;
        this.table = new HashNode[this.capacity];
    }

    public V get(T key) {
        int hash = this.getHash(key);
        HashNode<T,V> curr = this.table[hash];
        while(curr != null){
            if(curr.getKey().equals(key)){
                return curr.getValue();
            }
            curr = curr.next;
        }
        return null;
    }
    
    public HashMapX<T,V> set(T key, V value) {
        this.capacityCheck();
        int hash = this.getHash(key);
        HashNode<T,V> curr = this.table[hash];
        HashNode<T,V> prev = null;
        
        if(curr == null){
            curr = new HashNode<>(key,value);
            this.table[hash] = curr;
        } else {
            while(curr != null){
                if(curr.getKey().equals(key)){
                    curr.setValue(value);
                    return this;
                }
                prev = curr;
                curr = curr.next;
            }
            curr = new HashNode<>(key,value);
            prev.next = curr;
        }
        if(this.length == 0){
            this.keyHead = curr;
        } else {
            curr.nextKey = this.keyHead;
            this.keyHead.prevKey = curr;
            this.keyHead = curr;
        }
        this.length++;
        return this;
    }

    public V delete(T key) {
        if(this.length == 0)
            return null;
        int hash = this.getHash(key);
        HashNode<T,V> curr = this.table[hash];
        HashNode<T,V> prev = null;
        while(curr != null){
            if(curr.getKey().equals(key)){
                if(prev == null){
                    this.table[hash] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                curr.next = null;

                //Key Set Linked List
                if(curr.prevKey == null){
                    this.keyHead = this.keyHead.nextKey;
                } else {
                    curr.prevKey.nextKey = curr.nextKey;
                    if(curr.nextKey != null){
                        curr.nextKey.prevKey = curr.prevKey;
                    }
                }
                curr.prevKey = null;
                curr.nextKey = null;
                
                this.length--;
                return curr.getValue();
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    public T[] keys(){
        T[] arr = (T[])new Object[this.length];
        HashNode<T,V> curr = this.keyHead;
        for (int i = 0; i < this.length; i++){
            arr[i] = curr.getKey();
            curr = curr.nextKey;
        }
        return arr;
    }

    public V[] values(){
        if(this.length == 0)
            return null;
        V[] arr = (V[])new Object[this.length];
        HashNode<T,V> curr = this.keyHead;
        for (int i = 0; i < this.length; i++){
            arr[i] = curr.getValue();
            curr = curr.nextKey;
        }
        return arr;
    }

    public int size() {
        return this.length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.table.length; i++) {
            HashNode<T,V> curr = this.table[i];
            if(curr != null){
                sb.append("[ ").append(i).append(": ");
                while(curr != null){
                    sb.append(curr);
                    if(curr.next != null)
                        sb.append(", ");
                    curr = curr.next;
                }
                sb.append(" ]\n");
            }
        }
        return sb.toString();
    }
}
