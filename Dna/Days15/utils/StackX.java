package utils;

public class StackX<T> {
    private int length;
    private Node<T> head;

    public StackX<T> push(T obj){
        Node<T> curr = new Node<>(obj);
        if (this.head == null){
            this.head = curr;
        } else {
            curr.next = this.head;
            this.head = curr;
        }
        this.length++;
        return this;
    }

    public T pop(){
        if(this.length == 0)
            return null;
        Node<T> curr = this.head;
        this.head = this.head.next;
        curr.next = null;
        this.length--;
        return curr.getData();
    }

    public T peek(){
        if(length == 0)
            return null;
        else
            return this.head.getData();
    }

    public StackX<T> reverse(){
        Node<T> before = null;
        Node<T> curr = this.head;
        Node<T> after = null;
        while (curr != null) {
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
