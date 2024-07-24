public class LinkedList<T> {
    public int length;
    public Node<T> head;
    public Node<T> tail;
    

    LinkedList() {
        
    }

    public void prepend(T obj){
        Node<T> curr = new Node<T>(obj);
        if(head == null){
            head = curr;
        } else {
            curr.next = head;
            head.prev = curr;
            head = curr;
        }
        lenght++;
    }

    public void insertAt(T obj, int idx){
        Node<T> item = new Node<T>(obj);
        Node<T> curr = head;
        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        item.next = curr;
        item.prev = curr.prev;
        curr.prev.next = item;
        curr.prev = item;
        
    }
    
    /*append(item: T): void {

    }

    remove(item: T): T | undefined {

    }

    get(idx: number): T | undefined {

    }

    removeAt(idx: number): T | undefined {

    }*/
}
