package utils;

public class LinkedListX<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;
  
    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length)
            return false;
        return true;
    }

    private Node<T> prevNode(int idx){
        Node<T> prev = null;
        Node<T> curr = this.head;
        for (int i = 0; i < idx && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void prepend(T obj){
        Node<T> curr = new Node<>(obj);
        if(this.length == 0)
            this.head = this.tail = curr;
        else {
            curr.next = this.head;
            this.head = curr;
        }
        this.length++;
    }

    public void insertAt(T obj, int idx){
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        Node<T> prev = this.prevNode(idx);
        Node<T> curr = new Node<>(obj);

        if(prev == null){
            this.prepend(obj);
            return;
        } else {
            curr.next = prev.next;
            prev.next = curr;
        }
        this.length++;
    }
    
    public void append(T obj) {
        Node<T> curr = new Node<>(obj);
        if(this.length == 0)
            this.head = this.tail = curr;
        else {
            this.tail.next = curr;
            this.tail = curr;
        }
        this.length++;
    }

    public T remove(T obj) {
        if(this.length == 0)
            return null;
        Node<T> prev = null;
        Node<T> curr = this.head;
        for (int i = 0; i < this.length && curr != null; i++) {
            if(curr.getData().equals(obj)){
                if(this.length == 1){
                    this.head = this.tail = null;
                } else if(curr == this.head){
                    this.head = this.head.next;
                } else if(curr == this.tail) {
                    this.tail = prev;
                } else {
                    prev.next = curr.next;
                }
                this.length--;
                curr.next = null;
                return curr.getData();
            }
            prev = curr;
            curr = curr.next;
        }       
        return null;
    }

    public T get(int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        
        Node<T> prev = prevNode(idx);
        if(prev == null)
            return this.head.getData();
        else
            return prev.next.getData();        
    }

    public void set(T obj, int idx){
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        
        Node<T> prev = prevNode(idx);
        if(prev == null)
            this.head.setData(obj);
        else 
            prev.next.setData(obj);
    }

    public T removeAt(int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        
        Node<T> prev = prevNode(idx);
        Node<T> curr = null;
        if(this.length == 1){
            curr = this.head;
            this.head = this.tail = null;
        }
        else if(idx == 0){
            curr = this.head;
            this.head = this.head.next;
        } else if(idx == this.length - 1) {
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

    public int size(){
        return this.length;
    }
}
