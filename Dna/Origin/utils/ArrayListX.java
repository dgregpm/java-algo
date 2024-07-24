import java.util.*;
import java.lang.reflect.*;


public class ArrayListX<T> {
    
    public int length;
    private int capacity;
    private Object[] arr;

    
    ArrayListX() {
        this.length = 0;
        this.capacity = 16;
        this.arr = new Object[this.capacity];
    }

    private void capacityCheck(){
        if(this.length >= this.capacity - 1){
            this.capacity *= 2;
            this.arr = Arrays.copyOf(this.arr, this.capacity);
        }
    }

    private void shiftRight(int idx){
        this.capacityCheck();
        for (int i = this.length; i > idx; i--) {
            this.arr[i] = this.arr[i-1];            
        }
    }

    private void shiftLeft(int idx){
        for (int i = idx; i < this.length; i++) {
            this.arr[i] = this.arr[i+1];
        }
    }

    public void prepend(T obj) {
        this.shiftRight(0);
        this.arr[0] = obj;
        this.length++;
    }

    public void insertAt(T obj, int idx) {
        this.shiftRight(idx);
        this.arr[idx] = obj;
        this.length++;
    }

    public void append(T obj) {
        this.capacityCheck();
        this.arr[this.length] = obj;
        this.length++;
    }

    public T remove(T obj) {
        T curr;
        for (int i = 0; i < this.length; i++) {
            curr = (T)this.arr[i];
            if(curr.equals(obj)){
                return this.removeAt(i); 
            }
        }
        return null;
    }

    public T get(int idx) {
        return (T)this.arr[idx];
    }

    public T removeAt(int idx) {
        if(!this.inRange(idx)){
            return null;
        }
        T curr = (T)this.arr[idx];
        this.shiftLeft(idx);
        this.length--;
        return curr;
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length){
            return false;
        }
        return true;
    }

    public String toString(){
        return "Sigh...";
    }

}
