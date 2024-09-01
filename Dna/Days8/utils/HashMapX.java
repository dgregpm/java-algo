package utils;

public class HashMapX<T,V> {
    private int length;
    private int capacity;
    private HashNode<T,V>[] table;

    public HashMapX() {
        this.capacity = 8;
        this.table = new HashNode[this.capacity];
    }

    private void capacityCheck(){
        double loadFactor = this.length/this.capacity;
        if(loadFactor >= .75){
            this.capacity *= 2;
            HashNode<T,V>[] other = new HashNode[this.capacity];
            this.reHash(other);
            this.table = other;
        }
    }

    private void reHash(HashNode<T,V>[] other){
        for (int i = 0; i < this.table.length; i++) {
            if(this.table[i] == null)
                continue;
            HashNode<T,V> prev = null;
            HashNode<T,V> curr = this.table[i];
            while(curr != null){
                int hash = this.hash(curr.getKey());
                if(other[hash] == null){
                    other[hash] = curr;
                } else{
                    HashNode<T,V> c = other[hash];
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
    }
    
    private int hash(T key){
        return Math.abs(key.hashCode() % this.capacity);
    }
    
    public V get(T key) {
        HashNode<T,V> res = this.table[hash(key)];
        if(res == null)
            return null;
        
        while(res != null){
            if(res.getKey().equals(key))
                return res.getValue();
            res = res.next;
        }
        return null;
    }
    
    public HashMapX<T,V> set(T key, V value) {
        this.capacityCheck();
        //System.out.println("Key: " + key + ", Hash: " + hash(key) + ", HashCode: " + key.hashCode());
        HashNode<T,V> node = new HashNode<>(key,value);
        if(table[hash(key)] == null){
            table[hash(key)] = node;
        } else{
            HashNode<T,V> prev = null;
            HashNode<T,V> curr = table[hash(key)];
            while(curr != null){
                if(curr.getKey().equals(key)){
                    curr.setValue(value);
                    return this;
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = node;
        }
        this.length++;
        return this;
    }

    public V delete(T key) {
        if(this.table[hash(key)] == null)
            return null;
        
        HashNode<T,V> prev = null;
        HashNode<T,V> curr = table[hash(key)];
        while(curr != null){
            if(curr.getKey().equals(key)){
                if(prev == null)
                    this.table[hash(key)] = curr.next;
                else
                    prev.next = curr.next;
                    
                curr.next = null;
                this.length--;
                return curr.getValue();
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    public int size() {
        return this.length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" -------------\n");
        for (int i = 0; i < this.table.length; i++) {
            sb.append(this.table[i] + "\n");
        }
        sb.append(" -------------");
        return sb.toString();
    }
}
