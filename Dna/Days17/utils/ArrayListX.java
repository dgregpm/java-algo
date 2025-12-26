package utils;
import java.util.Arrays;

public class ArrayListX<T extends Comparable<T>> {
    private int length;
    private int capacity;
    private T[] arr;

    public ArrayListX(){
        this.length = 0;
        this.capacity = 8;
        this.arr = (T[])new Comparable[this.capacity];
    }

    public ArrayListX(int x){
        this.length = 0;
        if(x < 4){
            this.capacity = 8;
        } else {
            this.capacity = x;
        }
        this.arr = (T[])new Comparable[this.capacity];
    }

    private void shift(int idx){
        for(int i=this.length;i>idx;i--){
            arr[i] = arr[i-1];
        }
    }

    private void unShift(int idx){
        for(int i=idx;i<this.length;i++){
            arr[i] = arr[i+1];
        }
    }
    
    private void capacity(){
        double ub = 0;
        if(this.length <= 8)
            ub = 3;
        else {
            ub = Math.ceil(Math.log(this.length)/Math.log(2));
        }
        int limit = (int)Math.pow(2,ub);
        int cUb = (int)Math.ceil(Math.log(this.capacity)/Math.log(2));
        if(this.capacity < (limit + 2) || cUb > (ub + 3)){
            if((ub+1) < 32){
                this.capacity = (int)Math.pow(2,ub+1) - 1;
                T[] nArr = (T[])new Comparable[this.capacity];
                System.arraycopy(this.arr,0,nArr,0,this.length);
                this.arr = nArr;
            }
        }
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length){
            return false;
        }
        return true;
    }
    
    public void prepend(T obj) {
        this.capacity();
        if(this.length > 0){
            this.shift(0);
        }
        
        this.arr[0] = obj;
        this.length++;
    }

    public void insertAt(int idx, T obj) {
        this.capacity();
        if(!this.inRange(idx))
            throw new IndexOutOfBoundsException("The index: " + idx + " is out of range!");
        
        this.shift(idx);
        this.arr[idx] = obj;
        this.length++;
    }

    public void append(T obj) {
        this.capacity();
        this.arr[this.length] = obj;
        this.length++;
    }

    public boolean add(T obj){
        this.append(obj);
        return true;
    }

    public void add(int idx, T obj){
        this.insertAt(idx,obj);
    }

    public ArrayListX<T> reverse(){
        if(this.length <= 1)
            return this;
        int lo = 0;
        int hi = this.length - 1;
        while(lo < hi){
            T tmp = this.arr[lo];
            this.arr[lo++] = this.arr[hi];
            this.arr[hi--] = tmp;
        }
        return this;
    }

    public void clear(){
        for (int i = 0; i < this.length; i++) {
            this.arr[i] = null;
        }
        this.length = 0;
    }

    public boolean contains(){
        return false;
    }

    public boolean isEmpty(){
        return this.length <= 0 ? true : false;
    }

    public void sort(){
        Arrays.sort(this.arr,0,this.length);        
    }

    public int size(){
        return this.length;
    }

    public T get(int idx) {
        if(!this.inRange(idx))
            throw new IndexOutOfBoundsException("The index: " + idx + " is out of range!");
        
        return this.arr[idx];
    }

    public void set(int idx, T obj){
        if(!this.inRange(idx))
            throw new IndexOutOfBoundsException("The index: " + idx + " is out of range!");
        
        this.arr[idx] = obj;
    }
    
    public boolean remove(T obj) {
        if(this.length == 0)
            return false;
        for (int i = 0; i < this.length; i++) {
            if(obj.equals(this.arr[i])){
                this.unShift(i);
                this.length--;
                return true;
            }
        }
        return false;
    }

    public T removeAt(int idx) {
        if(!this.inRange(idx))
            throw new IndexOutOfBoundsException("The index: " + idx + " is out of range!");
        
        T tmp = this.arr[idx];
        this.unShift(idx);
        this.length--;
        return tmp;
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
}
