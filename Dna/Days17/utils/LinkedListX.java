package utils;
import java.util.Arrays;

public class LinkedListX<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    public LinkedListX(){
        this.length = 0;
        this.head = this.tail = null;
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length)
            return false;
        return true;
    }

    private Node<T> prev(int idx){
        Node<T> prev = null;
        Node<T> curr = this.head;
        for (int i = 0; i < idx && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void prepend(T obj){
        Node<T> curr = new Node<T>(obj);
        if(this.length == 0){
            this.head = this.tail = curr;
        } else {
            curr.next = this.head;
            this.head = curr;
        }
        this.length++;
    }

    public void insertAt(int idx, T obj){
        Node<T> curr = new Node<T>(obj);
        
        if(!inRange(idx) && !(this.length == 0 && idx == 0))
            throw new IndexOutOfBoundsException("The index: " + idx + " is out of bounds!");
        Node<T> prev = this.prev(idx);
        if(this.length ==0){
            this.head = this.tail = curr;
        } else if(prev == null){
            curr.next = this.head;
            this.head = curr;
        } else {
            curr.next = prev.next;
            prev.next = curr;
        }
        this.length++;
    }
    
    public void append(T obj) {
        Node<T> curr = new Node<T>(obj);
        if(this.length <= 0){
            this.head = this.tail = curr;
        } else {
            this.tail.next = curr;
            this.tail = curr;
        }
        this.length++;
    }

    public T remove(T obj) {
        Node<T> curr = this.head;
        for (int i = 0; i < this.length && curr != null; i++) {
            if(curr.getData().equals(obj)){
                return this.removeAt(i);
            }
        }
        return null;
    }

    public T get(int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("The index: " + idx + " is out of bounds!");

        if(idx == 0)
            return this.head.getData();
        else
            return this.prev(idx).next.getData();
    }

    public void set(int idx, T obj){
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("The index: " + idx + " is out of bounds!");

        if(idx == 0)
            this.head.setData(obj);
        else 
            this.prev(idx).next.setData(obj);

    }

    public T removeAt(int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("The index: " + idx + " is out of bounds!");
        
        Node<T> curr = null;
        Node<T> prev = this.prev(idx);
        if(this.length == 1){
            curr = this.head;
            this.head = this.tail = null;
        } else if(idx == 0){
            curr = this.head;
            this.head = this.head.next;
        } else if(idx == this.length - 1){
            curr = this.tail;
            this.tail = prev;
            this.tail.next = null;
        } else {
            curr = prev.next;
            prev.next = curr.next;
        }
        curr.next = null;
        this.length--;
        return curr.getData();
    }

    public int size(){
        return this.length;
    }

    public void sort(){
        Node<T> curr = this.head;
        T[] arr = (T[])new Comparable[this.length];
        for (int i = 0; i < this.length && curr != null; i++) {
           arr[i] = curr.getData();
           curr = curr.next;
        }
        Arrays.sort(arr);
        curr = this.head;
        for (int i = 0; i < this.length && curr != null; i++) {
            curr.setData(arr[i]);
            curr = curr.next;
        }
    }

    public LinkedListX<T> reverse(){
        if(this.length <= 1)
            return this;

        Node<T> before = null;
        Node<T> curr = this.tail = this.head;
        Node<T> after = null;

        while(curr != null){
            after = curr.next;
            curr.next = before;
            before = curr;
            curr = after;
        }
        this.head = before;
        return this;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<T> curr = this.head;
        sb.append("[ ");

        while(curr != null){
            sb.append(curr.getData());
            if(curr.next != null)
                sb.append(", ");
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
