package utils;

public class LinkedListX<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;


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

    public void insertAt(T obj, int idx){
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        if(idx == 0){
            this.prepend(obj);
        } else {
            Node<T> curr = new Node<>(obj);
            Node<T> prev = this.pNode(idx);
            curr.next = prev.next;
            prev.next = curr;
            this.length++;
        }  
    }
    
    public void append(T obj) {
        Node<T> curr = new Node<>(obj);
        if(this.length == 0)
            this.head = this.tail = curr;
        else{
            this.tail.next = curr;
            this.tail = curr;
        }
        this.length++;
    }

    public T remove(T obj) {
        if(this.length == 0)
            return null;
        Node<T> before = null;
        Node<T> curr = this.head;
        for (int i = 0; i < this.length; i++) {
            if(curr.getData().equals(obj)){
                if(this.length == 1){
                    this.head = this.tail = null;
                }else if(i == 0){
                    this.head = this.head.next;
                    curr.next = null;
                }else if(i == this.length - 1){
                    this.tail = before;
                    this.tail.next = null;
                }else{
                    before.next = curr.next;
                    curr.next = null;
                }
                this.length--;
                return curr.getData();
            }
            before = curr;
            curr = curr.next;
        }
        return null;
    }

    public T get(int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        if(idx == 0)
            return this.head.getData();
        else {
            Node<T> prev = this.pNode(idx);
            return prev.next.getData();
        }
    }

    public void set(T obj, int idx){
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        if(idx == 0)
            this.head.setData(obj);
        else{
            Node<T> prev = this.pNode(idx);
            prev.next.setData(obj);
        }
    }

    public T removeAt(int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        Node<T> curr = this.head;
        if(this.length == 1){
            this.head = this.tail = null;
        }else if(idx == 0){
            this.head = this.head.next;
            curr.next = null;
        }else if(idx == this.length - 1){
            Node<T> prev = this.pNode(idx);
            this.tail = prev;
            curr = prev.next;
            this.tail.next = null;
        }else{
            Node<T> prev = this.pNode(idx);
            curr = prev.next;
            prev.next = curr.next;
            curr.next = null;
        }
        this.length--;
        return curr.getData();
    }

    public void reverse(){
        if(this.length <= 1)
            return;

        Node<T> before = null;
        Node<T> curr = this.head;
        Node<T> after = null;
        this.tail = this.head;
        while(curr!= null){
            after = curr.next;
            curr.next = before;
            before = curr;
            curr = after;
        }
        this.head = before;
    }

    public int size(){
        return this.length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> curr = this.head;
        for (int i = 0; i < this.length; i++) {
            sb.append(curr);
            if(i < this.length - 1)
                sb.append(", ");
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    private Node<T> pNode(int idx){
        Node<T> curr = this.head;
        for (int i = 0; i < idx - 1; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length)
            return false;
        return true;
    }
}
