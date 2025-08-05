package utils;

import java.util.Arrays;

public class ArrayListX<T extends Comparable<T>> {
    private int length;
    private int capacity;
    private T arr[];

    public ArrayListX(){
        this.length = 0;
        this.capacity = 10;
        this.arr = (T[])new Comparable[this.capacity];
    }

    public ArrayListX(int c){
        this.length = 0;
        this.capacity = c;
        this.arr = (T[])new Comparable[this.capacity];
    }
            
    private void shift(int idx){
        for (int i = this.length; i > idx ; i--) {
            this.arr[i] = this.arr[i-1];            
        }
    }

    private void unShift(int idx){
        for (int i = idx; i < this.length; i++) {
            this.arr[i] = this.arr[i+1];
        }
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        return true;
    }

    private void capacityCheck(){
        double ub;
        if(this.length == 0)
            ub = 1;
        else
            ub = Math.ceil(Math.log(this.length)/Math.log(2));

        //System.out.println("UB: " + ub);
        int limit = (int)Math.pow(2,ub);

        if(this.capacity <= (limit + 1) || this.capacity > (int)Math.pow(2,ub+5)){
            this.capacity = (int)Math.pow(2,ub+1);
            T[] nArr = (T[])new Comparable[this.capacity];
            System.arraycopy(this.arr,0,nArr,0,this.length);
            this.arr = nArr;
        }
    }

    public ArrayListX<T> prepend(T obj) {
        this.capacityCheck();
        this.shift(0);
        this.arr[0] = obj;
        this.length++;
        return this;
    }

    public void insertAt(int idx, T obj) {
        this.capacityCheck();
        if(this.inRange(idx)){
            this.shift(idx);
            this.arr[idx] = obj;
            this.length++;
        }
    }

    public void set(int idx, T obj){
        this.insertAt(idx,obj);
    }

    public ArrayListX<T> append(T obj) {
        this.capacityCheck();
        this.arr[this.length] = obj;
        this.length++;
        return this;
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
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = null;
        }
        this.length = 0;
    }

    public boolean contains(){
        return false;
    }

    public boolean isEmpty(){
        return this.length == 0 ? true : false;
    }

    public void sort(){
        Arrays.sort(this.arr,0,this.length);
    }

    public int size(){
        return this.length;
    }

    public T get(int idx) {
        if(inRange(idx)){
            return this.arr[idx];
        }
        return null;
    }

    public T remove(T obj) {
        if(this.length == 0)
            return null;
        for (int i = 0; i < this.length; i++) {
            if(this.arr[i].equals(obj)){
                this.capacityCheck();
                T tmp = this.arr[i];
                this.unShift(i);
                this.length--;
                return tmp;
            }
        }
        return null;
    }

    public T removeAt(int idx) {
        this.capacityCheck();
        if(inRange(idx)){
            this.capacityCheck();
            T obj = this.arr[idx];
            this.unShift(idx);
            this.length--;
            return obj;
        }
        return null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < this.length; i++) {
            sb.append(this.arr[i]);
            if(i < this.length - 1)
                sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
