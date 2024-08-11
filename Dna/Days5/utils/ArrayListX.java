package utils;

public class ArrayListX<T> {
    private T[] arr;
    private int length;
    private int capacity;

    public ArrayListX(){
        this.length = 0;
        this.capacity = 16;
        this.arr = (T[]) new Object[this.capacity];
    }

    public ArrayListX(int c){
        this.length = 0;
        if(c < 4)
            this.capacity = 16;
        else
            this.capacity = c;
        this.arr = (T[]) new Object[this.capacity];
    }

    public ArrayListX(Object[] obj, int len){
        this.length = len;
        this.capacity = 2*len + 2; 
        this.arr = (T[])obj;
    }

    public void prepend(T obj) {
        this.capacityCheck();
        this.shift(0);
        this.arr[0] = obj;
        this.length++;
    }

    public void insertAt(T obj, int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        this.capacityCheck();
        this.shift(idx);
        this.arr[idx] = obj;
        this.length++;
    }

    public void append(T obj) {
        this.capacityCheck();
        this.arr[this.length] = obj;
        this.length++;
    }

    public T remove(T obj) {
        for (int i = 0; i < this.length; i++) {
            if(this.arr[i].equals(obj))
                return this.removeAt(i);
        }
        return null;
    }

    public void reverse(){
        if(this.length <= 1)
            return;

        int lo = 0;
        int hi = this.length - 1;

        while(lo < hi){
            T obj = this.arr[lo];
            this.arr[lo++] = this.arr[hi];
            this.arr[hi--] = obj;
        }
    }

    public int size(){
        return this.length;
    }

    public T get(int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        
        return this.arr[idx];
    }

    public void set(int idx, T obj){
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
    }

    public T removeAt(int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        
        T obj = this.arr[idx];
        this.unShift(idx);
        this.length--;
        return obj;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < this.length; i++) {
            sb.append(this.arr[i]);
            if(i < this.length - 1)
                sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }

    private boolean inRange(int idx){
        if(idx >= 0 && idx < this.length)
            return true;
        else
            return false;
    }

    private void capacityCheck(){
        if(this.length >= this.capacity - 2) {
            System.out.println("Capacity: " + this.capacity + " Length: " + this.length);
            this.capacity = 2*this.capacity + 2;
            T[] curr = (T[]) new Object[this.capacity];
            System.arraycopy(this.arr,0,curr,0,this.length);
            //for(int i = 0;i < this.length;i++)
              //  curr[i] = this.arr[i];
            this.arr = curr;
        }
    }

    private void shift(int idx){
        for (int i = this.length; i > idx; i--)
            this.arr[i] = this.arr[i-1];
    }

    private void unShift(int idx){
        for (int i = idx; i < this.length - 1; i++) 
            this.arr[i] = this.arr[i+1];
    }
}
