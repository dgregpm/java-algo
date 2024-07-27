import utils.BinaryNode;
import utils.QueueX;

public class TreeOrder {

    public QueueX<Integer> preOrderSearch(BinaryNode<Integer> head) {
        QueueX<Integer> path = new QueueX<>();
        return walk(head,path,0);        
    }

    public QueueX<Integer> inOrderSearch(BinaryNode<Integer> head) {
        QueueX<Integer> path = new QueueX<>();
        return walk(head,path,1);
    }

    public QueueX<Integer> postOrderSearch(BinaryNode<Integer> head) {
        QueueX<Integer> path = new QueueX<>();
        return walk(head,path,2);
    }
    
    private QueueX<Integer> walk(BinaryNode<Integer> head, QueueX<Integer> path, int w){
        if(head == null)
            return path;

        switch(w){
            case 0:
                path.enqueue(head.getData());
                walk(head.left,path,0);
                walk(head.right,path,0);
                break;
            case 1:
                walk(head.left,path,1);
                path.enqueue(head.getData());
                walk(head.right,path,1);
                break;
            case 2:
                walk(head.left,path,2);
                walk(head.right,path,2);
                path.enqueue(head.getData());
                break;
            default:
                System.out.println("Oops");
        }
        return path;
    }
}
