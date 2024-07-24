public class StackX<T> {
    private int length;
    private Node<T> head;

    StackX(){
        this.length = 0;
    }

    public void push(T obj){
        Node<T> curr = new Node<T>(obj); 
        curr.next = this.head;
        this.head = curr;
        this.length++;
    }

    public T pop(){
        if(this.head == null){
            return null;
        }
        Node<T> curr = this.head;
        this.head = this.head.next;
        curr.next = null;
        this.length--;
        return curr.getData();
    }

    public T peek(){
        return this.head == null ? null : this.head.getData();
    }

    public int size(){
        return this.length;
    }

    public String toString(){
        Node<T> curr = this.head;
        StringBuffer result = new StringBuffer();
        result.append("[ ");
        for(int i = 0;i<this.length;i++){
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
