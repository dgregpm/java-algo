import utils.QueueX;
import utils.BinaryNode;

public class BFS {

    public static boolean search(BinaryNode<Integer> head, int needle){
        QueueX<BinaryNode<Integer>> path = new QueueX<>();
        path.enqueue(head);
        while(path.size() > 0){
            BinaryNode<Integer> curr = path.deque();
            if(curr.getData() == needle)
                return true;
            if(curr.left != null)
                path.enqueue(curr.left);
            if(curr.right != null)
                path.enqueue(curr.right); 
        }
        return false;
    }
}
