package utils;

public class StackX<T> {
    private int length;
    private Node<T> head;

    public StackX(){
        this.length = 0;
    }

    public StackX<T> push(T obj){
        Node<T> curr = new Node<>(obj);
        if(this.length == 0){
            this.head = curr;
        }else{
            curr.next = this.head;
            this.head = curr;
        }
        this.length++;
        return this;
    }

    public T pop(){
        if(this.length > 0){
            Node<T> curr = this.head;
            this.head = this.head.next;
            curr.next = null;
            this.length--;
            return curr.getData();
        }
        return null;
    }

    public T peek(){
        if(this.length > 0){
            return this.head.getData();
        }
        return null;
    }

    public StackX<T> reverse(){
        if(this.length <= 1){
            return this;
        }
        Node<T> curr = this.head;
        Node<T> before = null;
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

    public int size(){
        return this.length;
    }

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
