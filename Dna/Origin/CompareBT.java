public class CompareBT {
    public boolean walk(BinaryNode<Integer> a, BinaryNode<Integer> b){
        if(a == null && b == null)
            return true;
        else if(a == null || b == null)
            return false;
        else if(a.getData() != b.getData())
            return false;

        return walk(a.left, b.left) && walk(a.right, b.right);
    }

    public boolean compare(BinaryNode<Integer> a, BinaryNode<Integer> b){
        return walk(a, b);
    }
}
