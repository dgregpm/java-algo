import java.io.*;

public class QueueX<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int length;
    transient private Node<T> head;
    transient private Node<T> tail;

    QueueX(){
        this.length = 0;
    }

    public T deque() {
        if(this.length <= 0){
            return null;
        } else if(this.length == 1){
            this.tail = null;
        }
        Node<T> curr = this.head;
        this.head = this.head.next;
        curr.next = null;
        this.length--;
        return curr.getData();
    }

    public void enqueue(T obj){
        Node<T> curr = new Node<T>(obj);
        if(this.head == null && this.tail == null){
            this.head = this.tail = curr;
        } else {
            this.tail.next = curr;
            this.tail = curr;
        }
        this.length++;
    }

    public T peek() {
        return this.head == null ? null : this.head.getData(); 
    }

    public int size() {
        return this.length;
    }

    public String toString(){
        StringBuffer result = new StringBuffer();
        result.append("[ ");
        Node<T> curr = this.head;
        for(int i=0;i<this.length;i++){
            T obj = curr.getData();
            result.append(obj.toString());
            if(i < this.length - 1)
                result.append(", "); 
            curr = curr.next;
        }
        result.append(" ]");
        return result.toString();
    }
}


