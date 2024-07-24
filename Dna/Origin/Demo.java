import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.Stack;
import java.io.*;


public class Demo {
            
    public static void main(String[] args){
        Demo d = new Demo();
        //d.BubbleSortTest();
        //d.BinarySearchTest();
        //d.TwoCrystalTest();
        //d.MazeSolverTest();
        //d.QueueTest();
        //d.StackTest();
        //d.ArrayListTest();
        //d.QuickSortTest();
        //d.TreeOrderTest();
        //d.BFSTest();
        //d.CompareBTTest();
        d.DFSTest();

        //A obj = new A();
        //obj.show();
    }

    public void DFSTest(){
        System.out.println(DFS.search(TreeOrder.tree1(), 45));
        System.out.println(DFS.search(TreeOrder.tree1(), 7));
        System.out.println(DFS.search(TreeOrder.tree1(), 69));
    }

    public void TwoCrystalTest(){
        Random rand = new Random();

        int idx = rand.nextInt(10000);
        boolean[] data = new boolean[10000];
        for (int i = idx; i < 10000; i++) {
            data[i] = true;
        }

        boolean[] data2 = new boolean[1000];
 
        System.out.println("Idx: " + idx + ", Data: " + TwoCrystals.find(data));

        System.out.println("False array: " + TwoCrystals.find(data2));
    }

    public void CompareBTTest(){
        CompareBT cbt = new CompareBT();
        System.out.println(cbt.walk(TreeOrder.tree1(), TreeOrder.tree1()));
        System.out.println(cbt.walk(TreeOrder.tree1(), TreeOrder.tree2()));
    }

    public void BFSTest(){
        System.out.println(BFS2.search(TreeOrder.tree1(), 45));
        System.out.println(BFS2.search(TreeOrder.tree1(), 7));
        System.out.println(BFS2.search(TreeOrder.tree1(), 69));
    }

    public void TreeOrderTest(){
        TreeOrder t = new TreeOrder();
        BinaryNode<Integer> obj = TreeOrder.tree1();
        QueueX<Integer> pre = t.preOrderSearch(obj);
        QueueX<Integer> in = t.inOrderSearch(obj);
        QueueX<Integer> post = t.postOrderSearch(obj);
        
        /*try{
            String filePath = "queue.txt"; 
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pre);
            oos.flush();
            oos.close();
        } catch(Exception e){
            System.out.println(e);
        }*/

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    public void QuickSortTest(){
        QuickSort2 q = new QuickSort2();
        Integer[] arr = Arrays.stream(this.generateRandomArray(10,50)).boxed().toArray(Integer[]::new);

        System.out.println(Arrays.toString(arr));

        q.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public void ArrayListTest(){
        ArrayListX<Integer> list = new ArrayListX<>();

        list.append(5);
        list.append(7);
        list.append(9);
    
        System.out.println(list.get(2));
        System.out.println(list.removeAt(1));
        System.out.println(list.length);

        list.append(11);
        System.out.println(list.removeAt(1));

        System.out.println(list.remove(9));
        System.out.println(list.removeAt(0));
        System.out.println(list.removeAt(0));
        System.out.println(list.length);

        list.prepend(5);
        list.prepend(7);
        list.prepend(9);

        System.out.println(list.get(2));
        System.out.println(list.get(0));
        System.out.println(list.remove(9));
        System.out.println(list.length);
        System.out.println(list.get(0)); 
    }

    public void StackTest(){
        StackY<Integer> list = new StackY<>();
        list.push(5);
        list.push(7);
        list.push(9);

        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list.size());

        list.push(11);

        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.peek());
        System.out.println(list.pop());
        System.out.println(list.pop());

        // just wanted to make sure that I could not blow up myself when i remove
        // everything
        list.push(69);

        System.out.println(list.peek());
        System.out.println(list.size());

    }

    public void QueueTest(){
        QueueX<Integer> q = new QueueX<Integer>();
        q.enqueue(5);
        q.enqueue(9);
        q.enqueue(11);
        System.out.println(q);
        System.out.println(q.size());
        q.deque();
        q.deque();
        System.out.println(q.size());
        System.out.println(q.deque());
        q.enqueue(69);
        System.out.println(q.size());
        System.out.println(q);
        System.out.println(q.deque());
        System.out.println(q);
        System.out.println(q.size());
    }

    public void BubbleSortTest(){
        int[] nums = generateRandomArray(10,100);
        int[] test = Arrays.stream(nums).toArray();
        BubbleSort.sort(nums);
        Arrays.sort(test);
        System.out.println("Bubble Sort: " + Arrays.toString(nums));
        System.out.println("Arrays Sort: " + Arrays.toString(test));
        System.out.println(Arrays.equals(nums,test));
    }

    public void BinarySearchTest(){
        Random rand = new Random();
        int[] nums = generateRandomArray(10,20);
        BubbleSort.sort(nums);
        int target = rand.nextInt(26);
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Found?: " + BinarySearch.search(nums, target));

    }

    public void MazeSolverTest(){
        String[] maze = {
            "xxxxxxxxxx x",
            "x        x x",
            "x        x x",
            "x xxxxxxxx x",
            "x          x",
            "x xxxxxxxxxx",
        };
        char wall = 'x';
        Point start = new Point(10,0);
        Point end = new Point(1,5);
        MazeSolver.solve(maze,wall,start,end);
    }

    public int[] generateRandomArray(int l, int s){
        Random rand = new Random();
        int[] nums = new int[l];
        for(int i = 0;i< nums.length;i++){
            // nums[i] = rand.nextInt((s * 2)+1) - s;
            nums[i] = rand.nextInt(s+1);
        }
        return nums;
    }
}
