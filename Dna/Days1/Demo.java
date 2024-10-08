import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.Stack;

import utils.Point;
import utils.BinaryNode;
import utils.QueueX;
import utils.StackX;
import utils.ArrayListX;


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
        d.TreeOrderTest(); //d.BFSTest(); //d.CompareBTTest(); //d.DFSTest();
        //d.MinHeapTest();
    }

    public void MinHeapTest(){
        MinHeap heap = new MinHeap();

        // expect(heap.length).toEqual(0);

        System.out.println(heap.length);

        heap.insert(5);
        heap.insert(3);
        heap.insert(69);
        heap.insert(420);
        heap.insert(4);
        heap.insert(1);
        heap.insert(8);
        heap.insert(7);

       // expect(heap.length).toEqual(8);
        System.out.println(heap.length);
       // expect(heap.delete()).toEqual(1);
       // expect(heap.delete()).toEqual(3);
       // expect(heap.delete()).toEqual(4);
       // expect(heap.delete()).toEqual(5);
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());

       // expect(heap.length).toEqual(4);
        System.out.println(heap.length);

       // expect(heap.delete()).toEqual(7);
       // expect(heap.delete()).toEqual(8);
       // expect(heap.delete()).toEqual(69);
       // expect(heap.delete()).toEqual(420);
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());

       // expect(heap.length).toEqual(0);
        System.out.println(heap.length);
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

    public void TreeOrderTest(){
        BinaryNode<Integer> tree1 = new BinaryNode<Integer>(20);
        tree1.left = new BinaryNode<Integer>(10);
        tree1.right = new BinaryNode<Integer>(50);
        tree1.left.right = new BinaryNode<Integer>(15);
        tree1.left.left = new BinaryNode<Integer>(5);
        tree1.left.left.right = new BinaryNode<Integer>(7);
        tree1.right.left = new BinaryNode<Integer>(30);
        tree1.right.right = new BinaryNode<Integer>(100);
        tree1.right.left.left = new BinaryNode<Integer>(29);
        tree1.right.left.right = new BinaryNode<Integer>(45);

        BinaryNode<Integer> tree2 = new BinaryNode<Integer>(20);
        tree2.left = new BinaryNode<Integer>(10);
        tree2.right = new BinaryNode<Integer>(50);
        tree2.left.right = new BinaryNode<Integer>(15);
        tree2.left.left = new BinaryNode<Integer>(5);
        tree2.left.left.right = new BinaryNode<Integer>(7);
        tree2.right.left = new BinaryNode<Integer>(30);
        tree2.right.left.right = new BinaryNode<Integer>(45);
        tree2.right.left.left = new BinaryNode<Integer>(29);
        tree2.right.left.right = new BinaryNode<Integer>(45);
        tree2.right.left.right.right = new BinaryNode<Integer>(49);
        tree2.right.left.left.left = new BinaryNode<Integer>(21);

        BinaryNode<Integer> tree3 = new BinaryNode<Integer>(7);
        tree3.left = new BinaryNode<Integer>(23);
        tree3.right = new BinaryNode<Integer>(8);
        tree3.left.left = new BinaryNode<Integer>(5);
        tree3.left.right = new BinaryNode<Integer>(4);
        tree3.right.left = new BinaryNode<Integer>(21);
        tree3.right.right = new BinaryNode<Integer>(15);

        // ------------------------------------------------------------
        TreeOrder t = new TreeOrder();        
        System.out.println("Tree Order:"); 
        QueueX<Integer> pre = t.preOrderSearch(tree1);
        QueueX<Integer> in = t.inOrderSearch(tree1);
        QueueX<Integer> post = t.postOrderSearch(tree1);

        // Pre: [ 20, 10, 5, 7, 15, 50, 30, 29, 45, 100 ]
        // In: [ 5, 7, 10, 15, 20, 29, 30, 45, 50, 100 ]
        // Post: [ 7, 5, 15, 10, 29, 45, 30, 100, 50, 20 ]

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
        pre.reverse();
        System.out.println(pre);

        // --------------------------------------------------------------
        System.out.println("\nDFSTest:");
        DFS dfs = new DFS();
        System.out.println(dfs.search(tree1, 45));
        System.out.println(dfs.search(tree1, 7));
        System.out.println(dfs.search(tree1, 69));
    
/*
        // --------------------------------------------------------------
        System.out.println("\nCompareBTTest:");
        CompareBT cbt = new CompareBT();
        System.out.println(cbt.compare(tree1, tree1));
        System.out.println(cbt.compare(tree1, tree2));
    

        // ---------------------------------------------------------------
        System.out.println("\nBFSTest:");
        System.out.println(BFS.search(tree1, 45));
        System.out.println(BFS.search(tree1, 7));
        System.out.println(BFS.search(tree1, 69));
    */
    }

    public void QuickSortTest(){
        QuickSort q = new QuickSort();
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
        System.out.println(list.size());

        list.append(11);
        System.out.println(list.removeAt(1));

        System.out.println(list.remove(9));
        System.out.println(list.removeAt(0));
        System.out.println(list.removeAt(0));
        System.out.println(list.size());

        list.prepend(5);
        list.prepend(7);
        list.prepend(9);

        System.out.println(list.get(2));
        System.out.println(list.get(0));
        System.out.println(list.remove(9));
        System.out.println(list.size());
        System.out.println(list.get(0)); 
    }

    public void StackTest(){
        StackX<Integer> list = new StackX<>();
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
        System.out.println("Unsorted Array: " + Arrays.toString(nums));
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
        MazeSolver m = new MazeSolver();
        m.solve(maze,wall,start,end);
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

  
    public Demo(){
    /*
        tree1 = new BinaryNode<Integer>(20);
        tree1.left = new BinaryNode<Integer>(10);
        tree1.right = new BinaryNode<Integer>(50);
        tree1.left.right = new BinaryNode<Integer>(15);
        tree1.left.left = new BinaryNode<Integer>(5);
        tree1.left.left.right = new BinaryNode<Integer>(7);
        tree1.right.left = new BinaryNode<Integer>(30);
        tree1.right.right = new BinaryNode<Integer>(100);
        tree1.right.left.left = new BinaryNode<Integer>(29);
        tree1.right.left.right = new BinaryNode<Integer>(45);

        tree2 = new BinaryNode<Integer>(20);
        tree2.left = new BinaryNode<Integer>(10);
        tree2.right = new BinaryNode<Integer>(50);
        tree2.left.right = new BinaryNode<Integer>(15);
        tree2.left.left = new BinaryNode<Integer>(5);
        tree2.left.left.right = new BinaryNode<Integer>(7);
        tree2.right.left = new BinaryNode<Integer>(30);
        tree2.right.left.right = new BinaryNode<Integer>(45);
        tree2.right.left.left = new BinaryNode<Integer>(29);
        tree2.right.left.right = new BinaryNode<Integer>(45);
        tree2.right.left.right.right = new BinaryNode<Integer>(49);
        tree2.right.left.left.left = new BinaryNode<Integer>(21);

        tree3 = new BinaryNode<Integer>(7);
        tree3.left = new BinaryNode<Integer>(23);
        tree3.right = new BinaryNode<Integer>(8);
        tree3.left.left = new BinaryNode<Integer>(5);
        tree3.left.right = new BinaryNode<Integer>(4);
        tree3.right.left = new BinaryNode<Integer>(21);
        tree3.right.right = new BinaryNode<Integer>(15);
    */
    }
}
