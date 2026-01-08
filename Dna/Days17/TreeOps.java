import utils.Node;
import utils.QueueX;

public class TreeOps{
   
    public static void treeOrder(Node<Integer> curr, QueueX<Integer> path, int w){
        if(curr == null)
            return;
        switch(w){
            case 0:
                path.offer(curr.getData());
                treeOrder(curr.left,path,w);
                treeOrder(curr.right,path,w);
                break;
            case 1:
                treeOrder(curr.left,path,w);
                path.offer(curr.getData());
                treeOrder(curr.right,path,w);
                break;
            case 2:
                treeOrder(curr.left,path,w);
                treeOrder(curr.right,path,w);
                path.offer(curr.getData());
                break;
            default:
                System.out.println("Oops");
        }
    }

    public static boolean compareBT(Node<Integer> a, Node<Integer> b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        if(a.getData() != b.getData())
            return false;

        return compareBT(a.left, b.left) && compareBT(a.right, b.right);     
    }

    public static boolean DFSSearch(Node<Integer> curr, int needle){
        if(curr == null)
            return false;
        else if(curr.getData() == needle)
            return true;
        else if(curr.getData() > needle)
            return DFSSearch(curr.left,needle);
        else
            return DFSSearch(curr.right,needle);
    }

    public static boolean BFSSearch(Node<Integer> head, int needle){
        QueueX<Node<Integer>> nodes = new QueueX<>();
        nodes.offer(head);
        while(nodes.size() > 0){
            Node<Integer> curr = nodes.poll();
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
