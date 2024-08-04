package utils;

public class LinkedListX<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;
  
    public void prepend(T obj){
        Node<T> curr = new Node<>(obj);
        if(this.length == 0){
            this.head = this.tail = curr;
        } else {
            curr.next = this.head;
            this.head = curr;
        }
        this.length++;
    }

    public void insertAt(T obj, int idx){
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        
        if(idx == 0)
            this.prepend(obj);
        else {
            Node<T> curr = new Node<>(obj);
            Node<T> itr = this.head;

            for (int i = 0; i < idx - 1; i++)
                itr = itr.next;
            
            curr.next = itr.next;
            itr.next = curr;
            this.length++;
        }
    }
    
    public void append(T obj) {
        Node<T> curr = new Node<>(obj);
        if(this.length == 0){
            this.head = this.tail = curr;
        } else {
            this.tail.next = curr;
            this.tail = curr;
        }
        this.length++;
    }

    public T remove(T obj) {
        Node<T> curr = this.head;
        Node<T> prev = null;
        T res = null;
        while(curr != null){
            res = curr.getData();
            if(res.equals(obj)){
                if(this.length == 1){
                    this.head = this.tail = null;
                } else if(curr == this.head){
                    this.head = this.head.next;
                    curr.next = null;
                } else if(curr == this.tail){
                    this.tail = prev;
                    prev.next = null;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                }
                this.length--;
                return res;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    public T get(int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds");

        Node<T> curr = this.head;

        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        return curr.getData();
    }

    public void set(T obj, int idx){
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds");

        Node<T> curr = this.head;

        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        curr.setData(obj); 
    }

    public T removeAt(int idx) {
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds");
        
        Node<T> curr = this.head;
        Node<T> prev = null;
        T res = null;
        if(this.length == 1){
            this.head = this.tail = null;
            res = curr.getData();
            this.length--;
            return res;
        }
        for (int i = 0; i < idx; i++) {
            prev = curr;
            curr = curr.next;
        }
        res = curr.getData();
        if(idx == 0){
            this.head = this.head.next;
            curr.next = null;
        } else if(idx == this.length - 1){
            this.tail = prev;
            prev.next = null;
        } else {
            prev.next = curr.next;
            curr.next = null;
        }
        this.length--;
        return res;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> curr = this.head;
        for (int i = 0; i < this.length; i++) {
            sb.append(curr.getData());
            if(i < this.length - 1)
                sb.append(", ");
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.length)
            return false;
        else 
            return true;
    }

    public int size(){
        return this.length;
    }
}
