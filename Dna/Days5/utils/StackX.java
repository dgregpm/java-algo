package utils;

public class StackX<T> {
    private int length;
    private Node<T> head;

    public void push(T obj){
        Node<T> curr = new Node<>(obj);
        if(this.length == 0)
            this.head = curr;
        else {
            curr.next = this.head;
            this.head = curr;
        }
        this.length++;
    }

    public T pop(){
        if(this.length == 0)
            return null;
        Node<T> curr = this.head;
        if(this.length == 1)
            this.head = null;
        else {
            this.head = this.head.next;
            curr.next = null;
        }
        this.length--;
        return curr.getData();
    }

    public T peek(){
        if(this.length == 0)
            return null;
        return this.head.getData();
    }

    public void reverse(){
        if(this.length <= 1)
            return;
        Node<T> before = null;
        Node<T> curr = this.head;
        Node<T> after = null;
        while(curr != null){
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
}
