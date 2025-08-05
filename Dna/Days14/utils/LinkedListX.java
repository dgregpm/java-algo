package utils;

public class LinkedListX<T> implements QueueX<T>, List<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public T poll(){
        return this.removeAt(0);
    }

    @Override
    public QueueX<T> offer(T obj){
        this.append(obj);
        return this;
    }

    @Override
    public T peek(){
        return this.get(0);
    }

    @Override
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

    @Override
    public int size(){
        return this.length;
    }
    
    @Override
    public List<T> prepend(T obj){
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

    @Override
    public void insertAt(T obj, int idx){
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        Node<T> curr = new Node<>(obj);
        Node<T> prev = this.prevNode(idx);
        if(prev == null){
            curr.next = this.head;
            this.head = curr;
        } else {
            curr.next = prev.next;
            prev.next = curr;
        }
        this.length++;
    }
    
    @Override
    public List<T> append(T obj) {
        Node<T> curr = new Node<>(obj);
        if(this.length == 0){
            this.head = this.tail = curr;
        } else {
            this.tail.next = curr;
            this.tail = curr;
        }
        this.length++;
        return this;
    }

    @Override
    public T remove(T obj) {
        return this.removeHelper(obj,0);
    }

    private T removeHelper(T obj, int idx){
        if(this.length == 0)
            return null;
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        Node<T> prev = null;
        Node<T> curr = this.head;
        T res = null;
        if(obj != null){
            while(curr != null){
                if(obj.equals(curr.getData()))
                    break;
                prev = curr;
                curr = curr.next;
            }
            if(curr == null)
                return null;
        } else {
            prev = this.prevNode(idx);
        }
        if(this.length == 1){
            res = this.head.getData();
            this.head = this.tail = null;
        } else if(prev == null){
            res = this.head.getData();
            this.head = this.head.next;
        }  else if(prev.next == this.tail){
            res = this.tail.getData();
            prev.next = null;
            this.tail = prev;
        } else {
            curr = prev.next;
            res = curr.getData();
            prev.next = curr.next;
            curr.next = null;
        }
        this.length--;
        return res;
    }
    
    @Override
    public T removeAt(int idx) {
        return this.removeHelper(null,idx);
    }
    
    @Override
    public T get(int idx) {
        if(this.length == 0)
            return null;
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        Node<T> prev = this.prevNode(idx);
        if(prev == null){
            return this.head.getData();
        } else {
            return prev.next.getData();
        }
    }

    @Override
    public void set(T obj, int idx){
        if(!inRange(idx))
            throw new IndexOutOfBoundsException("Index: " + idx + " is out of bounds!");
        Node<T> prev = this.prevNode(idx);
        if(prev == null){
            this.head.setData(obj);
        } else {
            prev.next.setData(obj);
        }
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

    private Node<T> prevNode(int idx){
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
}
