import utils.BinaryNode;

public class DFS {

    public boolean search(BinaryNode<Integer> curr, int needle){
        if(curr == null)
            return false;
        else if(curr.getData() == needle)
            return true;
        else if(curr.getData() < needle)
            return search(curr.right, needle);
        else
            return search(curr.left, needle);
    }

}
