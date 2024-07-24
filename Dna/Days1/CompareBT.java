import utils.BinaryNode;

public class CompareBT {

    public boolean compare(BinaryNode<Integer> a, BinaryNode<Integer> b){
        return walk(a,b); 
    }

    private boolean walk(BinaryNode<Integer> a, BinaryNode<Integer> b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        if(a.getData() != b.getData())
            return false;

        return walk(a.left, b.left) && walk(a.right, b.right);
    }
}
