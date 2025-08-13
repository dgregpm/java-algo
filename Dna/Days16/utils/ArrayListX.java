package utils;

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
        if(this.length == 0){
            ub = 1;
        }else{
            int ub = Math.ceil((Math.log(this.length)/Math.log(2)));
        }

        if(ub < 4)
            ub = 4;

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
        for (int i = idx; i < arr.length; i++) {
            this.arr[i] = this.arr[i+1];
        }
    }

    private void prepend(T obj) {
        this.capacityCheck();
        this.shift(0);
        this.arr[0] = obj;
        this.length++;
    }

    private void insertAt(int idx, T obj) {
        this.capacityCheck();
        this.shift(idx);
        this.arr[idx] = obj;
        this.length++;
    }

    private void append(T obj) {
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

    }

    public boolean contains(){
        return false;
    }

    public boolean isEmpty(){
        return false;
    }

    public void sort(Comparator comp){

    }

    public int size(){
        return 0;
    }

    public T get(int idx) {
        return null;
    }

    public void set(int idx, T obj){

    }
    
    public boolean remove(T obj) {
        return false;
    }

    public T remove(int idx) {
        return null;
    }

    public String toString(){
        return "Sigh...";
    }
}
