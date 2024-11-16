package utils;

public class LinkedListX<T> implements QueueX<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    public LinkedListX(){
        {System.out.println("valid");}
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length)
            return false;
        return true;
    }

    @Override
    public void offer(T obj){
        
    }

    @Override
    public T poll(){
        if(this.length == 0)
            return null;       
        Node<T> curr = this.head;
        if(this.length == 1)
            this.head = this.tail = null;
        else{
            this.head = this.head.next;
        }
        curr.next = null;
        this.length--;
        return curr.getData();
    }

    public LinkedListX<T> prepend(T obj){
        Node<T> curr = new Node<>(obj);
        if(this.length == 0){
            this.head = this.tail = curr;
        } else {
            curr.next = this.head;
            this.head = curr;
        }
        this.length++;
        return this;
    }

    public void insertAt(T obj, int idx){

    }
    
    public void append(T obj) {

    }

    public T remove(T obj) {
        return null;
    }

    public T get(int idx) {
        return null;
    }

    public void set(T obj, int idx){

    }

    public T removeAt(int idx) {
        return null;
    }

    @Override
    public T peek(){
        if(this.length == 0)
            return null;
        return this.head.getData();
    }

    @Override
    public void reverse(){
       if(this.length <= 1)
           return;
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
    }

    @Override
    public int size(){
        return this.length;
    }
}
