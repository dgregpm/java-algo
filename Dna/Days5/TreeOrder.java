import utils.QueueX;
import utils.BinaryNode;

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

    public QueueX<Integer> walk(BinaryNode<Integer> curr, QueueX<Integer> path, int w){
        if(curr == null)
            return path;

        switch(w){
            case 0:
                path.enqueue(curr.getData());
                walk(curr.left,path,0);
                walk(curr.right,path,0);
                break;
            case 1:
                walk(curr.left,path,1);
                path.enqueue(curr.getData());
                walk(curr.right,path,1);
                break;
            case 2:
                walk(curr.left,path,2);
                walk(curr.right,path,2);
                path.enqueue(curr.getData());
                break;
            default:
                System.out.println("Problem!");
        }
        return path;
    }
    
}
