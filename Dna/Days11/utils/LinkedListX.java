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

    private Node<T> getPrev(int idx){
        if(idx == 0)
            return null;
        Node<T> curr = this.head;
        for (int i = 0; i < idx - 1; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public LinkedListX<T> prepend(T obj){
        Node<T> curr = new Node(obj);
        if(this.length == 0){
            this.head = this.tail = curr;
        } else {
            curr.next = this.head;
            this.head = curr;
        }
        this.length++;
        return this;
    }

    public LinkedListX<T> insertAt(T obj, int idx){
        if(!inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        Node<T> curr = new Node(obj);
        Node<T> prev = this.getPrev(idx);
        if(idx == 0){
            curr.next = this.head;
            this.head = curr;
        } else {
            curr.next = prev.next;
            prev.next = curr;
        }
        this.length++;
        return this;
    }
    
    public LinkedListX<T> append(T obj) {
        Node<T> curr = new Node(obj);
        if(this.length == 0){
            this.head = this.tail = curr;
        } else {
            this.tail.next = curr;
            this.tail = curr;
        }
        this.length++;
        return this;
    }

    public T remove(T obj) {
        Node<T> curr = this.head;
        for (int i = 0; i < this.length; i++){
            if(curr.getData().equals(obj)){
                return this.removeAt(i);
            }
            curr = curr.next;
        }
        return null;
    }

    public T get(int idx) {
        if(!inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        Node<T> prev = this.getPrev(idx);
        if(idx == 0){
            return this.head.getData();
        }
        return prev.next.getData();
    }

    public LinkedListX<T> set(T obj, int idx){
        if(!inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        Node<T> prev = this.getPrev(idx);
        if(idx == 0){
            this.head.setData(obj);
            return this;
        }
        prev.next.setData(obj);
        return this;
    }

    public T removeAt(int idx) {
        if(!inRange(idx)){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
        T tmp = null;
        Node<T> prev = this.getPrev(idx);
        if(this.length == 1){
            tmp = this.head.getData();
            this.head = this.tail = null;
        } else if(idx == 0){
            tmp = this.head.getData();
            this.head = this.head.next;
        } else if(idx == this.length - 1){
            tmp = this.tail.getData();
            prev.next = null;
            this.tail = prev;
        } else {
            tmp = prev.next.getData();
        }
        this.length--;
        return tmp;
    }

    public LinkedListX<T> reverse(){
        if(this.length <= 1){
            return this;
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
        return this;
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
