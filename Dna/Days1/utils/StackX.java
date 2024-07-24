package utils;

public class StackX<T> {
    private int length;
    private Node<T> head;

    public void push(T obj){
        Node<T> curr = new Node<>(obj);
        if(this.size() == 0)
            this.head = curr;
        else {
            curr.next = this.head;
            this.head = curr;
        }
        this.length++;
    }

    public T pop(){
        if(this.size() == 0)
            return null;
        Node<T> curr = this.head;
        this.head = curr.next;
        curr.next = null;
        this.length--;
        return curr.getData();
    }

    public T peek(){
        return this.head.getData();
    }

    public int size(){
        return this.length;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        Node<T> curr = this.head;
        for(int i=0;i<this.size();i++){
            sb.append(curr.getData());
            if(i < this.size() - 1)
                sb.append(", ");
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
