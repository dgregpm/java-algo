package utils;

public class ArrayListX<T> {
    private int length;
    private int capacity;
    private T[] arr;

    public ArrayListX(){
        this.capacity = 16;
        this.arr = (T[])new Object[this.capacity];
    }

    public ArrayListX(int c){
        if(c < 4){
            this.capacity = 4;
        } else {
            this.capacity = c;
        }
        this.arr = (T[])new Object[this.capacity];
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length)
            return false;
        return true;
    }

    private void shift(int idx){
        for (int i = this.length; i > idx; i--) {
            this.arr[i] = this.arr[i-1];
        }
    }

    private void unShift(int idx){
        for (int i = idx; i < this.length; i++) {
            this.arr[i] = this.arr[i+1];
        }
        //this.arr[this.length - 1] = null;
    }

    private void capacityCheck(){
        if(this.length >= this.capacity - 2){
            this.capacity *= 2;
            T[] other = (T[])new Object[this.capacity];
            System.arraycopy(this.arr,0,other,0,this.length);
            this.arr = other;
        }
    }

    public ArrayListX<T> prepend(T obj) {
        if(this.length > 0){
            this.shift(0);
        }
        this.arr[0] = obj;
        this.length++;
        return this;
    }

    public ArrayListX<T> insertAt(T obj, int idx) {
        if(!inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        this.capacityCheck();
        this.shift(idx);
        this.arr[idx] = obj;
        this.length++;
        return this;
    }

    public ArrayListX<T> append(T obj) {
        this.capacityCheck();
        this.arr[this.length] = obj;
        this.length++;
        return this;
    }

    public T remove(T obj) {
        if(this.length == 0)
            return null;
        for (int i = 0; i < this.length; i++) {
            if(this.arr[i].equals(obj)){
                return this.removeAt(i);
            }
        }
        return null;
    }

    public ArrayListX<T> reverse(){
        if(this.length <= 1){
            return this;
        }
        int lo = 0;
        int hi = this.length - 1;
        while(lo < hi){
            T tmp = this.arr[lo];
            this.arr[lo] = this.arr[hi];
            this.arr[hi] = tmp;
        }
        return this;
    }

    public int size(){
        return this.length;
    }

    public T get(int idx) {
        if(!inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        return this.arr[idx];
    }

    public void set(T obj, int idx){
        if(!inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        this.arr[idx] = obj;
    }

    public T removeAt(int idx) {
        if(!inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        T tmp = this.arr[idx];
        this.unShift(idx);
        this.length--;
        return tmp;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < this.length; i++) {
            sb.append(this.arr[i]);
            if(i < this.length - 1){
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

}
