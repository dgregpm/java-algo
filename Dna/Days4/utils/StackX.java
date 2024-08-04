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
        return this.head.getData();
    }

    public int size(){
        return this.length;
    }

    public void reverse(){
        if(this.length <= 1)
            return;
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
