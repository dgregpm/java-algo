package utils;

public class QueueX<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    public QueueX(){
        this.length = 0;
        this.head = this.tail = null;
    }

    public T poll() {
        if(this.length == 0)
            return null;
        else if(this.length == 1)
            this.tail = null;
        Node<T> curr = this.head;
        this.head = this.head.next;
        this.length--;
        return curr.getData();
    }

    public QueueX<T> offer(T obj){
        Node<T> curr = new Node<>(obj);
        if(this.length == 0)
            this.head = this.tail = curr;
        else{
            this.tail.next = curr;
            this.tail = curr;
        }
        this.length++;
        return this;
    }

    public T peek() {
        if(this.length == 0)
            return null;
        return this.head.getData();
    }

    public QueueX<T> reverse(){
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

    public int size() {
        return this.length;
    }

    @Override
    public String toString(){
        if(this.length == 0)
            return "[ ]";
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

