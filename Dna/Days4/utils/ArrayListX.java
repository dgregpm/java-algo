package utils;
import java.lang.reflect;

public class ArrayListX<T> {
    private int length;
    private Object[] arr;
    private int capacity;

    public ArrayListX(){
        this.length = 0;
        this.capacity = 16;
        this.arr = new Object[this.capacity];
    }

    public ArrayListX(Object obj, int len){
        this.length = len;
        this.capacity = 2*this.length + 2;
        this.arr = new Object[this.capacity];
        for (int i = 0; i < this.length; i++) {
            this.arr[i] = Array.get(obj,i);
        }
    }

    public void prepend(T obj) {
        this.insertAt(obj, 0);
    }

    public void insertAt(T obj, int idx) {
        this.capacityCheck();
        if(!this.inRange(idx))
            return;
        this.shift(idx);
        this.arr[idx] = obj;
        this.length++;
    }

    public void append(T obj) {
        this.arr[this.length] = obj;
        this.length++;
    }

    public T remove(T obj) {
        for (int i = 0; i < this.length; i++) {
            T item = (T)this.arr[i];
            if(item.equals(obj))
                return this.removeAt(i);
        }
        return null;
    }

    public int size(){
        return this.length;
    }

    public T get(int idx) {
        if(!inRange(idx))
            return null;
        else
            return (T)this.arr[idx];
    }

    public void set(int idx, T obj){
        if(!inRange(idx))
            return;
        this.arr[idx] = obj;
    }

    public T removeAt(int idx) {
        if(!this.inRange(idx))
            return null;
        this.capacityCheck();

        Object o = this.arr[idx];
        unShift(idx);
        this.length--;
        return (T)o;
    }

    public String toString(){
        return this.arr.toString();
    }

    private void capacityCheck(){
        if(this.length >= this.capacity - 2;){
            this.capacity = 2*this.capacity + 2;
            Object[] narr = new Object[this.capacity];
            System.arraycopy(this.arr, 0, narr, 0,this.length);
            this.arr = narr;
        }
    }

    private boolean inRange(int idx){
        if(idx >= 0 && idx < this.length)
            return true;
        else
            return false;
    }

    private void shift(int idx){
        for (int i = this.length; i > idx; i--) {
            this.arr[i] = this.arr[i - 1];
        }
    }

    private void unShift(int idx){
        for (int i = idx; i < this.length - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }
    }

}
