import utils.BinaryNode;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {

    public static boolean search(BinaryNode<Integer> head, int needle){
        Queue<BinaryNode<Integer>> nodes = new LinkedList<>();
        nodes.offer(head);
        while(nodes.size() > 0){
            BinaryNode<Integer> curr = nodes.poll();
            if(curr.getData() == needle)
                return true;
            if(curr.left != null)
                nodes.offer(curr.left);
            if(curr.right != null)
                nodes.offer(curr.right);
        }
        return false;
    }
}
