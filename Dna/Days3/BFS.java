import utils.BinaryNode;
import utils.QueueX;

public class BFS {

    public static boolean search(BinaryNode<Integer> head, int needle){
        QueueX<BinaryNode<Integer>> nodes = new QueueX<>();
        nodes.enqueue(head);
        while(nodes.size() > 0){
            BinaryNode<Integer> curr = nodes.deque();
            if(curr.left != null)
                nodes.enqueue(curr.left);
            if(curr.right != null)
                nodes.enqueue(curr.right);
            if(curr.getData() == needle)
                return true;
        }
        return false;
    }
}
