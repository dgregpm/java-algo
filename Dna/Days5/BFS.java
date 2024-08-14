import utils.BinaryNode;
import utils.QueueX;

public class BFS {

    public static boolean search(BinaryNode<Integer> head, int needle){
        QueueX<BinaryNode<Integer>> q = new QueueX<>();
        q.enqueue(head);

        while(q.size() > 0){
            BinaryNode<Integer> curr = q.deque();
            if(curr.getData() == needle)
                return true;
            if(curr.left != null)
                q.enqueue(curr.left);
            if(curr.right != null)
                q.enqueue(curr.right);
        }

        return false;
    }
}
