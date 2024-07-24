package utils;

public class QueueX<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    public T deque() {
        if(this.size() == 0)
            return null;
        else if(this.size() == 1){
            T tmp = this.head.getData();
            this.head = this.tail = null;
            this.length--;
            return tmp;
        } else {
            Node<T> curr = this.head;
            this.head = this.head.next;
            curr.next = null;
            this.length--;
            return curr.getData();
        }
    }

    public void enqueue(T obj){
        Node<T> curr = new Node<>(obj);
        if(this.size() == 0){
            this.head = this.tail = curr;
            this.length++;
        } else {
            this.tail.next = curr;
            this.tail = curr;
            this.length++;
        }
    }

    public T peek() {
        return this.head.getData();
    }

    public int size() {
        return this.length;
    }

    public void reverse(){
        if(this.length <= 1)
            return;
        this.tail = this.head;
        Node<T> before = null;
        Node<T> curr = this.head;
        Node<T> after = this.head.next;
        while(after != null){
            curr.next = before;
            before = curr;
            curr = after;
            after = after.next;
        }
        curr.next = before;
        this.head = curr;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        Node<T> curr = this.head;
        for(int i = 0;i < this.size();i++){
            sb.append(curr.getData());
            if(i < this.size() - 1)
                sb.append(", ");
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}

