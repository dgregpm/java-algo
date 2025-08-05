package utils;

public class LinkedListX<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    public LinkedListX(){
        this.length = 0;
        this.head = this.tail = null;
    }

    private Node<T> prevNode(int idx){
        if(idx < 0 || idx >= this.length)
            return null;
        Node<T> curr = this.head;
        Node<T> prev = null;

        for (int i = 0; i < idx; i++){
            if(curr.next != null)
                prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    private void rangeCheck(int idx){
        if(idx < 0 || idx >= this.length){
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        }
    }
    
    public LinkedListX<T> prepend(T obj){
        Node<T> curr = new Node<>(obj);
        curr.next = this.head;
        this.head = curr;
        this.length++;
        return this;
    }

    public void insertAt(int idx, T obj){
        if(!(this.length == 0 && idx == 0))
            this.rangeCheck(idx);
        
        Node<T> curr = new Node<>(obj);
        Node<T> prev = this.prevNode(idx);
        
        if(this.length == 0){
            this.head = this.tail = curr;
        }else if(prev == null){
            curr.next = this.head;
            this.head = curr;
        }else{
            curr.next = prev.next;
            prev.next = curr;
        }
        this.length++;
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
        for (int i = 0; i < this.length && curr != null; i++){
            if(curr.getData().equals(obj)){
                return this.removeAt(i);
            }
            curr = curr.next;
        }
        return null;
    }

    public T get(int idx) {
        this.rangeCheck(idx);
        Node<T> prev = this.prevNode(idx);
        T obj = null;
        if(prev == null)
            obj = this.head.getData();
        else
            obj = prev.next.getData();
        return obj;
    }

    public void set(int idx, T obj){
        this.rangeCheck(idx);
        Node<T> prev = this.prevNode(idx);
        if(prev == null)
            this.head.setData(obj);
        else
            prev.next.setData(obj);
    }

    public T removeAt(int idx) {
        this.rangeCheck(idx);
        Node<T> curr = this.head;
        Node<T> prev = this.prevNode(idx);
        
        if(this.length == 1){
            this.head = this.tail = null;
        }else if(idx == 0){
            this.head = this.head.next;
        }else if(idx == this.length - 1){
            curr = this.tail;
            this.tail = prev;
            this.tail.next = null;
        }else{
            curr = prev.next;
            prev.next = curr.next;
        }
        //System.out.println("Curr: " + curr);
        //System.out.println("Prev: " + prev);
        //System.out.println("Idx: " + idx);
        //System.out.println("Length: " + this.length);
        curr.next = null;
        this.length--;
        return curr.getData();
    }

    public int size(){
        return this.length;
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

    public void sort(){

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[ ");
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
