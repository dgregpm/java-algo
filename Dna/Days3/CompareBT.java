import utils.BinaryNode;

public class CompareBT {

    public boolean compare(BinaryNode<Integer> a, BinaryNode<Integer> b){
        if(a == null && b == null)
            return true;
        else if(a == null || b == null)
            return false;
        else if(a.getData() != b.getData())
            return false;

        return compare(a.left,b.left) && compare(a.right,b.right); 
    }

}
