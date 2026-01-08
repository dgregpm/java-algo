package utils;

public class HashMapX<T,V> {

    private int length;
    private int capacity;
    private HashNode<T,V>[] table;
    
    public HashMapX() {
        this.length = 0;
        this.capacity = 4;
        this.table = new HashNode[this.capacity];
    }

    private void reHash(){
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

    private void capacityCheck(){
        double loadFactor = .75;
        double load = this.length/this.capacity;
        if(load >= loadFactor){
            this.capacity *= 2;
            this.reHash();
        } 
    }

    private int hash(T key){
        int hash = key.hashCode() % this.capacity;
        return Math.abs(hash);
    }

    public V get(T key) {
        int hash = this.hash(key);
        HashNode<T,V> prev = null;
        HashNode<T,V> curr = this.table[hash];
        if(curr != null){
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
        this.length++;
        return this;
    }

    public V delete(T key) {
        int hash = this.hash(key);
        HashNode<T,V> prev = null;
        HashNode<T,V> curr = this.table[hash];
        if(curr != null){
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
        T[] res = (T[])new Object[this.length];
        int cnt = 0;

        for (int i = 0; i < this.table.length; i++) {
            HashNode<T,V> curr = this.table[i];
            while(curr != null){
                res[cnt++] = curr.getKey();
                curr = curr.next;
            }
        }
        return res;
    }

    public V[] values(){
        V[] res = (V[])new Object[this.length];
        int cnt = 0;

        for (int i = 0; i < this.table.length; i++) {
            HashNode<T,V> curr = this.table[i];
            while(curr != null){
                res[cnt++] = curr.getValue();
                curr = curr.next;
            }
        }
        return res;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.table.length; i++) {
            HashNode<T,V> curr = this.table[i];
            if(curr != null){
                sb.append("[" + i + ": ");
                while(curr != null){
                    sb.append(curr);
                    if(curr.next != null)
                        sb.append(", ");
                    curr = curr.next;
                }
                sb.append("]\n");
            }
        }
        return sb.toString();
    }
}
