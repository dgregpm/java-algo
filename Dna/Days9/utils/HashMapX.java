package utils;

public class HashMapX<T,V> {
    private int length;
    private int capacity;
    private HashNode<T,V>[] table;
    private ArrayListX<T> keys;

    private class HashNode<T,V>{
        private T key;
        private V value;
        public HashNode<T,V> next;
        HashNode(T k, V v){
            this.key = k;
            this.value = v;
        }
        public T getKey(){
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
            HashNode<T,V> curr = this;
            while(curr != null){
                sb.append("{").append(curr.getKey()).append("->").append(curr.getValue()).append("}");
                if(curr.next != null)
                    sb.append(", ");
                curr = curr.next;
            }
            return sb.toString();
        }
    }

    public HashMapX() {
        this.capacity = 4;
        this.table = new HashNode[this.capacity];    
    }

    private int hash(T key){
        return Math.abs(key.hashCode() % this.capacity);
    }

    private void capacityCheck(){
        double loadFactor = this.length/this.capacity;
        if(loadFactor >= .75){
            this.capacity *= 2;
            HashNode<T,V> prev = null;
            HashNode<T,V> curr = null;
            HashNode<T,V>[] other = new HashNode[this.capacity];
            for (int i = 0; i < this.table.length; i++) {
                prev = curr = this.table[i];
                if(curr != null){
                    while(curr != null){
                        int hash = this.hash(curr.getKey());
                        if(other[hash] == null)
                            other[hash] = curr;
                        else {
                            HashNode<T,V> c = other[hash];
                            while(c.next != null)
                                c = c.next;
                            c.next = curr;                                 
                        }
                        prev = curr;
                        curr = curr.next;
                        prev.next = null;
                    }
                }
                this.table[i] = null;
            }
            this.table = other;
        }
    }

    public V get(T key) {
        int hash = this.hash(key);
        if(this.table[hash] == null)
            return null;
        HashNode<T,V> curr = this.table[hash];
        while(curr != null){
            if(curr.getKey().equals(key))
                return curr.getValue();
            curr = curr.next;
        }
        return null;
    }
    
    public HashMapX<T,V> set(T key, V value) {
        this.capacityCheck();
        int hash = this.hash(key);
        HashNode<T,V> curr = null;
        if(this.table[hash] == null){
            curr = new HashNode<>(key,value);
            this.table[hash] = curr;
        } else {
            HashNode<T,V> prev = null;
            curr = this.table[hash];
            while(curr != null){
                if(curr.getKey().equals(key)){
                    curr.setValue(value);
                    return this;
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = new HashNode<>(key,value);
        }
        this.length++;
        return this;
    }

    public V delete(T key) {
        int hash = this.hash(key);
        HashNode<T,V> prev = null;
        HashNode<T,V> curr = null;
        if(this.table[hash] == null)
            return null;
        curr = this.table[hash];
        while(curr != null){
            if(curr.getKey().equals(key)){
                V res = curr.getValue();
                if(prev == null)
                    this.table[hash] = curr.next;
                else {
                    prev.next = curr.next;
                    curr.next = null;
                }
                this.length--;
                return res;
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
        sb.append(" ------------\n");
        for (int i = 0; i < this.table.length; i++) {
            sb.append("[").append(this.table[i]).append("]");
            if(i < this.table.length - 1)
                sb.append("\n");
        }
        sb.append("\n ------------");
        return sb.toString();
    }

}
