import utils.QueueX;
import utils.BinaryNode;

public class TreeOrder {

    public QueueX<Integer> preOrderSearch(BinaryNode<Integer> head) {
        QueueX<Integer> path = new QueueX<Integer>();
        return walk(head, path, -1);        
    }

    public QueueX<Integer> inOrderSearch(BinaryNode<Integer> head) {
        QueueX<Integer> path = new QueueX<Integer>();
        return walk(head, path, 0);
    }

    public QueueX<Integer> postOrderSearch(BinaryNode<Integer> head) {
        QueueX<Integer> path = new QueueX<Integer>();
        return walk(head, path, 1);     
    }

    private QueueX<Integer> walk(BinaryNode<Integer> curr, QueueX<Integer> path, int t){
        if(curr == null)
            return path;

        switch (t){
            case -1:
                path.enqueue(curr.getData());
                walk(curr.left, path, -1);
                walk(curr.right, path, -1);
                break;
            case 0:
                walk(curr.left, path, 0);
                path.enqueue(curr.getData());
                walk(curr.right, path, 0);
                break;
            case 1:
                walk(curr.left, path, 1);
                walk(curr.right, path, 1);
                path.enqueue(curr.getData());
                break;
        }
        return path;
    } 

}
