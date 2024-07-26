package utils;

public class ArrayListX<T> {
    private int length;
    private int capacity;
    private Object[] arr;

    public ArrayListX(){
        this.length = 0;
        this.capacity = 2;
        this.arr = new Object[this.capacity];
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length)
            return false;
        else
            return true;
    }

    private void capacityCheck(){
        if(this.length >= this.capacity - 1){
            this.capacity += this.capacity + 2;
            Object[] tmp = new Object[this.capacity];
            System.arraycopy(this.arr, 0, tmp, 0, this.length);
            this.arr = tmp;
            System.out.println("New Capacity: " + this.capacity);
        } else
            return;
    }

    private void shift(int idx){
        if(!this.inRange(idx))
            return;
        this.capacityCheck();

        for(int i = this.length;i > idx;i--){
            this.arr[i] = this.arr[i - 1];  
        }
    }

    private void unShift(int idx){
        if(!this.inRange(idx))
            return;
        for (int i = idx; i < this.length - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }
    }

    public void prepend(T obj) {
        this.shift(0);
        this.arr[0] = obj;
        this.length++;
    }

    public void insertAt(T obj, int idx) {
        if(!this.inRange(idx))
            return;
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
            T tmp = (T)this.arr[i];
            if(tmp.equals(obj)){
                this.unShift(i);
                this.length--;
                return tmp;
            }
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

    public T removeAt(int idx) {
        if(!inRange(idx))
            return null;
        T tmp = (T)this.arr[idx];
        this.unShift(idx);
        this.length--;
        return tmp;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < this.length; i++) {
            sb.append(this.arr[i]);
            if(i < this.length - 1)
                sb.append(", ");
        }
        sb.append(" }");
        return sb.toString();
    }

}
