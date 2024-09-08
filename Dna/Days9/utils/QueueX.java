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
        else
            this.head = this.head.next;
        curr.next = null;
        this.length--;
        return curr.getData();
    }

    public QueueX<T> enqueue(T obj){
        Node<T> curr = new Node(obj);
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
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> curr = this.head;
        for (int i = 0; i < this.length && curr != null; i++) {
            sb.append(curr.getData());
            if(i < this.length - 1)
                sb.append(", ");
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}

