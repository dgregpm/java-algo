public class DFS {

    public static boolean search(BinaryNode<Integer> curr, int needle){
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
