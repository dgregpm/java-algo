//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class TreeOrder {

    private QueueX<Integer> preWalk(BinaryNode<Integer> curr, QueueX<Integer> path) {
        if(curr == null){
            return path;
        }

        path.enqueue(curr.getData());
        preWalk(curr.left, path);
        preWalk(curr.right, path);

        return path;
    }
    
    private QueueX<Integer> inWalk(BinaryNode<Integer> curr, QueueX<Integer> path) {
        if(curr == null){
            return path;
        }

        inWalk(curr.left, path);
        path.enqueue(curr.getData());
        inWalk(curr.right, path);

        return path;
    }

    private QueueX<Integer> postWalk(BinaryNode<Integer> curr, QueueX<Integer> path) {
        if(curr == null){
            return path;
        }

        postWalk(curr.left, path);
        postWalk(curr.right, path);
        path.enqueue(curr.getData());

        return path;
    }


    public QueueX<Integer> preOrderSearch(BinaryNode<Integer> head) {
        QueueX<Integer> path = new QueueX<>();
        return preWalk(head, path);    
    }

    public QueueX<Integer> inOrderSearch(BinaryNode<Integer> head) {
        QueueX<Integer> path = new QueueX<>();
        return inWalk(head, path);     
    }

    public QueueX<Integer> postOrderSearch(BinaryNode<Integer> head) {
        QueueX<Integer> path = new QueueX<>();
        return postWalk(head, path);     
    }


    public static BinaryNode<Integer> tree1(){
        BinaryNode<Integer> root = new BinaryNode<>(20);
        root.left = new BinaryNode<>(10);
        root.right = new BinaryNode<>(50);
        root.left.right = new BinaryNode<>(15);
        root.left.left = new BinaryNode<>(5);
        root.left.left.right = new BinaryNode<>(7);

        root.right.left = new BinaryNode<>(30);
        root.right.right = new BinaryNode<>(100);

        root.right.left.left = new BinaryNode<>(29);
        root.right.left.right = new BinaryNode<>(45);

        return root;
        /*ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(root);
        System.out.println(json);*/
    }

    public static BinaryNode<Integer> tree2(){
        BinaryNode<Integer> root = new BinaryNode<>(20);
        root.left = new BinaryNode<>(10);
        root.right = new BinaryNode<>(50);
        root.left.right = new BinaryNode<>(15);
        root.left.left = new BinaryNode<>(5);
        root.left.left.right = new BinaryNode<>(7);

        root.right.left = new BinaryNode<>(30);
        root.right.left.right = new BinaryNode<>(45);

        root.right.left.left = new BinaryNode<>(29);
        root.right.left.right = new BinaryNode<>(45);
        root.right.left.right.right = new BinaryNode<>(49);
        root.right.left.left.left = new BinaryNode<>(21);

        return root;
    }
    
    public static BinaryNode<Integer> tree3(){
        BinaryNode<Integer> root = new BinaryNode<>(7);
        root.left = new BinaryNode<>(23);
        root.right = new BinaryNode<>(8);
        root.left.left = new BinaryNode<>(5);
        root.left.right = new BinaryNode<>(4);

        root.right.left = new BinaryNode<>(21);
        root.right.right = new BinaryNode<>(15);

        return root;
    }
}
