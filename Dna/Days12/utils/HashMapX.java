package utils;

public class HashMapX<T,V> {
    private int length;
    private int capacity;
    private HashNode<T,V> keyHead;
    private HashNode<T,V>[] table;

    private class HashNode<K,D> {
        private K key;
        private D value;
        public HashNode<K,D> next;
        public HashNode<K,D> prevKey;
        public HashNode<K,D> nextKey;

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
            sb.append("{").append(key).append(":").append(value).append("}");
            return sb.toString();
        }
    }

    public HashMapX() {
        this.capacity = 4;
        this.table = new HashNode[this.capacity];
    }

    private void capacityCheck(){
        double loadFactor = .75;
        double load = this.length/this.capacity;
        if(load >= loadFactor){
            this.capacity *= 2;
            HashNode<T,V>[] other = new HashNode[this.capacity];
            for (int i = 0; i < this.table.length; i++) {
                HashNode<T,V> prev = null;
                HashNode<T,V> curr = this.table[i];
                while(curr != null){
                    int hash = this.hash(curr.getKey());
                    prev = curr;
                    curr = curr.next;
                    HashNode<T,V> p = null;
                    HashNode<T,V> c = other[hash];
                    if(c == null){
                        other[hash] = prev;
                    } else {
                        while(c != null){
                            p = c;
                            c = c.next;
                        }
                        p.next = prev;
                    }
                    prev.next = null;
                }
                this.table[i] = null;
            }
            this.table = other;
        }
    }

    public V get(T key) {
        int hash = this.hash(key);
        HashNode<T,V> prev = null;
        HashNode<T,V> curr = this.table[hash];
        if(curr == null){
            return null;
        } else {
            while(curr != null){
                if(curr.getKey().equals(key)){
                    return curr.getValue();
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return null;
    }

    public int hash(T key){
        int hash = key.hashCode() % this.capacity;
        return Math.abs(hash);
    }
    
    public HashMapX<T,V> set(T key, V value) {
        this.capacityCheck();
        int hash = this.hash(key);
        HashNode<T,V> prev = null;
        HashNode<T,V> curr = this.table[hash];
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
        curr.nextKey = this.keyHead;
        if(this.keyHead != null)
            this.keyHead.prevKey = curr;
        this.keyHead = curr;
        this.length++;
        return this;
    }

    public V delete(T key) {
        int hash = this.hash(key);
        HashNode<T,V> prev = null;
        HashNode<T,V> curr = this.table[hash];
        if(curr == null){
            return null;
        } else {
            while(curr != null){
                if(curr.getKey().equals(key)){
                    V res = curr.getValue();
                    if(prev == null){
                        this.table[hash] = this.table[hash].next;
                    } else {
                        prev.next = curr.next;
                    }
                    curr.next = null;
                    this.length--;
                    
                    if(curr.prevKey == null){
                        this.keyHead = this.keyHead.nextKey;
                    } else {
                        curr.prevKey.nextKey = curr.nextKey;
                    }
                    if(curr.nextKey != null)
                        curr.nextKey.prevKey = curr.prevKey;
                    curr.prevKey = null;
                    curr.nextKey = null;

                    return res;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return null;
    }

    public int size() {
        return this.length;
    }

    public T[] keys(){
        HashNode<T,V> curr = this.keyHead;
        T[] res = (T[])new Object[this.length];

        for (int i = 0; i < this.length && curr != null; i++) {
            res[i] = curr.getKey();
            curr = curr.nextKey;
        } 
        return res;
    }

    public V[] values(){
        HashNode<T,V> curr = this.keyHead;
        V[] res = (V[])new Object[this.length];

        for (int i = 0; i < this.length && curr != null; i++) {
            res[i] = curr.getValue();
            curr = curr.nextKey;
        } 
        return res;
    }

    @Override
    public String toString(){
        if(this.size() == 0)
            return "[ ]";
        StringBuilder sb = new StringBuilder();
        HashNode<T,V> curr = null;
        for (int i = 0; i < this.table.length; i++) {
            curr = this.table[i];
            if(curr == null)
                continue;
            sb.append("[" + i + ": ");
            while(curr != null){
                sb.append(curr);
                if(curr.next != null)
                    sb.append(", ");
                curr = curr.next;
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}
