package utils;
import java.util.Arrays;

public class ArrayListX<T> {
    private int length;
    private int capacity;
    private T[] arr;

    public ArrayListX(){
        this.capacity = 4;
        this.arr = (T[])new Object[this.capacity];
    }

    public ArrayListX(int c){
        this.capacity = c;
        this.arr = (T[])new Object[this.capacity];
    }

    private void capacityCheck(){
        int ub = 1;
        if(this.length > 0){
            ub = (int)Math.ceil((Math.log(this.length)/Math.log(2)));
            ub = Math.max(ub,1);
        }

        if(this.length >= this.capacity - 2 || this.capacity > (int)Math.pow(2,ub + 4)){
            this.capacity = (int)Math.pow(2,ub + 1);
            T[] other = (T[])new Object[this.capacity];
            System.arraycopy(this.arr, 0, other, 0, this.length);
            this.arr = other;
        }
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
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length)
            return false;
        return true;
    }

    public void prepend(T obj) {
        this.capacityCheck();
        this.shift(0);
        this.arr[0] = obj;
        this.length++;
    }

    public void insertAt(int idx, T obj) {
        if(this.length == 0 && idx == 0)
            this.append(obj);
        else{
            if(!this.inRange(idx)){
                throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
            }
            this.capacityCheck();
            this.shift(idx);
            this.arr[idx] = obj;
            this.length++;
        }
    }

    public void append(T obj) {
        this.capacityCheck();
        this.arr[this.length] = obj;
        this.length++;
    }

    public boolean add(T obj){
        this.append(obj);
        return true;
    }

    public void add(int idx, T obj){
        this.insertAt(idx, obj);
    }

    public void reverse(){
        if(this.length <= 1)
            return;

        int lo = 0;
        int hi = this.length - 1;
        while(lo < hi){
            T tmp = this.arr[lo];
            this.arr[lo++] = this.arr[hi];
            this.arr[hi--] = tmp;
        }
    }

    public void clear(){
        for (int i = 0; i < this.capacity; i++) {
            this.arr[i] = null;
        }
    }

    public boolean contains(T obj){
        for (int i = 0; i < this.length; i++) {
            if(this.arr[i].equals(obj))
                return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(this.length == 0)
            return false;
        return true;
    }

    public void sort(){
        Arrays.sort(this.arr,0,this.length);    
    }

    public int size(){
        return this.length;
    }

    public T get(int idx) {
        if(!this.inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }

        return this.arr[idx];
    }

    public void set(int idx, T obj){
        if(!this.inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        this.arr[idx] = obj;
    }
    
    public boolean remove(T obj) {
        this.capacityCheck();
        for (int i = 0; i < this.length; i++) {
            if(this.arr[i].equals(obj)){
                this.unShift(i);
                this.length--;
                return true;
            }
        }
        return false;
    }

    public T removeAt(int idx) {
        if(!this.inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }

        this.capacityCheck();
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
            if(i < this.length - 1){
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
