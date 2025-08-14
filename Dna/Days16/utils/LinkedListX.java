package utils;

public class LinkedListX<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    public LinkedListX(){
        this.length = 0;
        this.head = this.tail = null;
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

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length)
            return false;
        return true;
    }
  
    public void prepend(T obj){
        Node<T> curr = new Node<>(obj);
        if(this.length == 0)
            this.head = this.tail = curr;
        else{
            curr.next = this.head;
            this.head = curr;
        }
        this.length++;
    }

    public void insertAt(int idx, T obj){
        if(this.length == 0 && idx == 0){
            this.prepend(obj);
        }else{
            if(!inRange(idx)){
                throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
            }
            Node<T> curr = new Node<>(obj);
            Node<T> prev = this.prev(idx);
            if(prev == null){
                this.prepend(obj);
            }else{
                curr.next = prev.next;
                prev.next = curr;
                this.length++;
            }
        }
    }
    
    public void append(T obj) {
        Node<T> curr = new Node<>(obj);
        if(this.length == 0){
            this.head = this.tail = curr;
        }else{
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
            curr = curr.next;
        }
        return null;
    }

    public T get(int idx) {
        if(!this.inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        Node<T> prev = this.prev(idx);
        if(prev == null){
            return this.head.getData();
        }
        return prev.next.getData();
    }

    public void set(int idx, T obj){
        if(!this.inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        Node<T> prev = this.prev(idx);
        if(prev == null){
            this.head.setData(obj);
        }else{
            prev.next.setData(obj);
        }
    }

    public T removeAt(int idx) {
        if(!this.inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        Node<T> prev = this.prev(idx);
        Node<T> curr = this.head;
        if(length == 1){
            this.head = this.tail = null;
        }else if(prev == null){
            this.head = this.head.next;
        }else if(idx == this.length - 1){
            curr = this.tail;
            this.tail = prev;
            this.tail.next = null;
        }else{
            curr = prev.next;
            prev.next = curr.next;
        }
        curr.next = null;
        this.length--;
        return curr.getData();
    }

    public void reverse(){
        if(this.length <= 1){
            return;
        }
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

    public void sort(){

    }

    public int size(){
        return this.length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> curr = this.head;
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
