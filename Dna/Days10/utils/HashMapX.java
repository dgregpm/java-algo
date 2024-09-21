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
        public HashNode<K,D> prevKey;
        public HashNode<K,D> nextKey;

        public HashNode(K k, D d){
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
            sb.append("{").append(this.key).append("->").append(this.value).append("}");
            return sb.toString();
        }
    }
    
    public HashMapX() {
        this.length = 0;
        this.capacity = 6;
        this.table = new HashNode[this.capacity];
    }

    private void capacityCheck(){
        double loadFactor = .75;
        double ratio = this.length / this.capacity;
        if(ratio > .75){
            System.out.println(this.toString());
            this.capacity *= 2;
            HashNode<T,V>[] other = new HashNode[this.capacity];
            for (int i = 0; i < this.table.length; i++) {
                HashNode<T,V> prev = null;
                HashNode<T,V> curr = this.table[i];
                while(curr != null){
                    int hash = this.hash(curr.getKey());
                    HashNode<T,V> c = other[hash];
                    if(c == null)
                        other[hash] = curr;
                    else {
                        while(c.next != null)
                            c = c.next;
                        c.next = curr;
                    }
                    
                    prev = curr;
                    curr = curr.next;
                    prev.next = null;
                }
                this.table[i] = null;
            }
            this.table = other;
            System.out.println(this.toString());
        }
    }

    private int hash(T key){
        int h = key.hashCode() % this.capacity;
        return Math.abs(h);
    }

    public V get(T key) {
        HashNode<T,V> curr;
        int hash = this.hash(key);
        if(this.table[hash] == null)
            return null;
        curr = this.table[hash];
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
        HashNode<T,V> node = new HashNode<>(key,value);
        int hash = this.hash(key);
        if(this.table[hash] == null)
            this.table[hash] = node;
        else {
            HashNode<T,V> curr = this.table[hash];
            while(curr != null){
                if(curr.getKey().equals(key)){
                    curr.setValue(value);
                    return this;
                }
                if(curr.next == null){
                    curr.next = node;
                    break;
                }
                curr = curr.next;
            }
        }
        if(this.length == 0){
            this.keyHead = node;
        } else {
            node.nextKey = this.keyHead;
            this.keyHead.prevKey = node;
            this.keyHead = node;
        }
        this.length++;
        return this;
    }

    public V delete(T key) {
        if(this.length == 0)
            return null;
        int hash = this.hash(key);
        if(this.table[hash] == null)
            return null;
        HashNode<T,V> prev = null;
        HashNode<T,V> curr = this.table[hash];
        while(curr != null){
            if(curr.getKey().equals(key)){
                if(prev == null)
                    this.table[hash] = this.table[hash].next;
                else
                    prev.next = curr.next;
                curr.next = null;
                
                if(curr.prevKey == null){
                    this.keyHead = this.keyHead.nextKey;
                } else {
                    curr.prevKey.nextKey = curr.nextKey;
                    if(curr.nextKey != null)
                        curr.nextKey.prevKey = curr.prevKey;
                    curr.prevKey = null;
                    curr.nextKey = null;
                }
                
                this.length--;
                return curr.getValue();
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    public Object[] keySet(){
        Object[] keys = new Object[this.length];
        HashNode<T,V> currKey = this.keyHead;
        for (int i = 0; currKey != null; i++,currKey = currKey.nextKey) {
            keys[i] = currKey.getKey();
        }
        return keys;
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
                sb.append("[ " + i + ": ");
                while(curr != null){    
                    sb.append(curr);
                    if(curr.next != null)
                        sb.append(", ");
                    curr = curr.next;
                }
                sb.append(" ]\n");
            } else {
                sb.append("[ " + i + ": " + curr + " ]\n");
            }
        }
        return sb.toString();
    }
}
