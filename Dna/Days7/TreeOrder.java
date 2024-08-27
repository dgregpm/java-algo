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
    
    private QueueX<Integer> walk(BinaryNode<Integer> curr, QueueX<Integer> path, int w){
        if(curr == null)
            return path;

        switch(w){
            case 0:
                path.enqueue(curr.getData());
                walk(curr.left,path,w);
                walk(curr.right,path,w);
                break;
            case 1:
                walk(curr.left,path,w);
                path.enqueue(curr.getData());
                walk(curr.right,path,w);
                break;
            case 2:
                walk(curr.left,path,w);
                walk(curr.right,path,w);
                path.enqueue(curr.getData());
                break;
            default:
                System.out.println("Oopsies!");
        }
        return path;
    }
}
