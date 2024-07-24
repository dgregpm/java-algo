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

        Node<T> curr;
        if(this.length == 1){
            curr = this.head;
            this.head.next = null;
            this.head = null;
            this.length--;
        } else{
            curr = this.head;
            this.head = this.head.next;
            curr.next = null;
            this.length--;
        }
        return curr.getData();
    }

    public T peek(){
        if(this.length == 0)
            return null;

        return this.head.getData();
    }

    public int size(){
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
