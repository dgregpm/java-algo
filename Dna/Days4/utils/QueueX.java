package utils;

public class QueueX<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;
    
    public T deque() {
        if(this.length == 0)
            return null;
        
        Node<T> curr = this.head;
        if(this.length == 1)
            this.head = this.tail = null;
        else {
            this.head = this.head.next;
            curr.next = null;
        }
        this.length--;
        return curr.getData();
    }

    public void enqueue(T obj){
        Node<T> curr = new Node<>(obj);
        if(this.length == 0)
            this.head = this.tail = curr;
        else {
            this.tail.next = curr;
            this.tail = curr;
        }
        this.length++;
    }

    public T peek() {
        if(this.length == 0)
            return null;

        return this.head.getData();
    }

    public void reverse(){
        if(this.length <= 1)
            return;
        Node<T> before = null;
        Node<T> curr = this.head;
        Node<T> after = curr.next;
        this.tail = this.head;
        while(after != null){
            curr.next = before;
            before = curr;
            curr = after;
            after = after.next;
        }
        curr.next = before;
        this.head = curr;
    }

    public int size() {
        return this.length;
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
}

