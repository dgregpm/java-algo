import utils.BinaryNode;
import utils.QueueX;

public class TreeOrder {
    private QueueX<Integer> path = new QueueX<>();

    public QueueX<Integer> preOrderSearch(BinaryNode<Integer> head) {
        path.clear();
        walk(head,0);
        return path;        
    }

    public QueueX<Integer> inOrderSearch(BinaryNode<Integer> head) {
        path.clear();
        walk(head,1);
        return path;
    }

    public QueueX<Integer> postOrderSearch(BinaryNode<Integer> head) {
        path.clear();
        walk(head,2);
        return path;
    }

    private void walk(BinaryNode<Integer> curr, int w){
        if(curr == null)
            return;
        switch(w){
            case 0:
                path.enqueue(curr.getData());
                walk(curr.left,w);
                walk(curr.right,w);
                break;
            case 1:
                walk(curr.left,w);
                path.enqueue(curr.getData());
                walk(curr.right,w);
                break;
            case 2:
                walk(curr.left,w);
                walk(curr.right,w);
                path.enqueue(curr.getData());
                break;
            default:
                System.out.println("Oopsie");
        }
    }
}
