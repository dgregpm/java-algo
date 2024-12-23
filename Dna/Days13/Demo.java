import java.util.Arrays;
import java.util.Random;
import java.time.Instant;
import java.time.Duration;

//import utils.Point;
//import utils.BinaryNode;
import utils.QueueX;
import utils.StackX;
//import utils.ArrayListX;
//import utils.HashMapX;
import utils.LinkedListX;
//import utils.MinHeap;
//import utils.Graph;

public class Demo {
           
    public static void main(String[] args){
        Demo d = new Demo();
        //d.BubbleSortTest();
        //d.InsertionSortTest();
        //d.QuickSortTest();
        //d.MergeSortTest();
        //d.BinarySearchTest();
        //d.TwoCrystalTest();
        //d.StackTest();
        d.QueueTest();
        //d.ListTest();
        //d.HashMapTest();
        //d.TreeOrderTest(); //d.BFSTest(); //d.CompareBTTest(); //d.DFSTest();
        //d.MazeSolverTest();
        //d.MinHeapTest();
        //d.TrieTest();
        //d.BFSGraphMatrixTest();
        //d.DFSGraphListTest();
        //d.DijkstraListTest();
        //d.LRUTest();
        //d.PrimsListTest(); 
    }
/*
    public void PrimsListTest(){
        // there is only one right answer for this graph
        // expect(prims(list1)).toEqual([
        //    [   { to: 2, weight: 1 }, { to: 1, weight: 3 },   ],
        //    [   { to: 0, weight: 3 }, { to: 4, weight: 1 },   ],
        //    [   { to: 0, weight: 1 }                          ],
        //    [   { to: 6, weight: 1 }                          ],
        //    [   { to: 1, weight: 1 }, { to: 5, weight: 2 },   ],
        //    [   { to: 4, weight: 2 }, { to: 6, weight: 1 },   ],
        //    [   { to: 5, weight: 1 }, { to: 3, weight: 1 },   ],  ]);
        PrimsList p = new PrimsList();
        GraphEdge[][] g = p.prims(Graph.list1());
        for (int i = 0; i < g.length; i++) {
            System.out.println(Arrays.toString(g[i]));
        }
    }

    public void LRUTest(){
        LRU<String, Integer> lru = new LRU<>(3);
        //expect(lru.get("foo")).toEqual(undefined);
        System.out.println(lru.get("foo"));
        lru.update("foo", 69);
        //expect(lru.get("foo")).toEqual(69);
        System.out.println(lru.get("foo"));
        lru.update("bar", 420);
        //expect(lru.get("bar")).toEqual(420);
        System.out.println(lru.get("bar"));
        lru.update("baz", 1337);
        //expect(lru.get("baz")).toEqual(1337);
        System.out.println(lru.get("baz"));
        lru.update("ball", 69420);
        //expect(lru.get("ball")).toEqual(69420);
        //expect(lru.get("foo")).toEqual(undefined);
        //expect(lru.get("bar")).toEqual(420);
        System.out.println(lru.get("ball"));
        System.out.println(lru.get("foo"));
        System.out.println(lru.get("bar"));
        lru.update("foo", 69);
        //expect(lru.get("bar")).toEqual(420);
        //expect(lru.get("foo")).toEqual(69);
        System.out.println(lru.get("bar"));
        System.out.println(lru.get("foo"));
        // shouldn't of been deleted, but since bar was get'd, bar was added to the
        // front of the list, so baz became the end
        //expect(lru.get("baz")).toEqual(undefined);
        System.out.println(lru.get("baz"));
    }

    public void DijkstraListTest(){
        //expect(dijkstra_list(0, 6, list1)).toEqual([0, 1, 4, 5, 6]);
        DijkstraList d = new DijkstraList();
        System.out.println(d.graph(0,6,Graph.list1()));
    }

    public void DFSGraphListTest(){
        //expect(dfs(list2, 0, 6)).toEqual([ 0,1,4,5,6 ])
        DFSGraphList d = new DFSGraphList();
        System.out.println(d.dfs(Graph.list2(),0,6));
        //expect(dfs(list2, 6, 0)).toEqual(null);
        System.out.println(d.dfs(Graph.list2(),6,0));
    }

    public void BFSGraphMatrixTest(){
        //expect(bfs(matrix2, 0, 6)).toEqual([ 0,1,4,5,6 ])
        BFSGraphMatrix b = new BFSGraphMatrix();
        System.out.println(b.bfs(Graph.matrix2(), 0, 6));
        //expect(bfs(matrix2, 6, 0)).toEqual(null);
        System.out.println(b.bfs(Graph.matrix2(), 6, 0));
    }

    public void TrieTest(){
        Trie trie = new Trie();
        trie.insert("foo");
        trie.insert("fool");
        trie.insert("foolish");
        trie.insert("bar");
        trie.insert("time");
        trie.insert("timely");
        trie.insert("foobar");
        trie.insert("tine");
        System.out.println(trie);
        System.out.println("Word Count: " + trie.wordCount());
        System.out.println(trie.find("foo"));
        System.out.println(trie.find("ti"));
        System.out.println(trie.find("b"));
        //  expect(trie.find("fo").sort()).toEqual([
        //    "foo",
        //    "fool",
        //    "foolish",
        //  ]);
        trie.delete("fool");
        System.out.println(trie.find("foo"));
        trie.delete("bar");
        System.out.println(trie.find("b"));
        trie.delete("timely");
        trie.delete("tine");
        System.out.println(trie);
        System.out.println("Word Count: " + trie.wordCount());
        
        //  expect(trie.find("fo").sort()).toEqual([
        //    "foo",
        //    "foolish",
        //  ]); 
    }

    public void MinHeapTest(){
        MinHeap<Integer> heap = new MinHeap<>();
        // expect(heap.length).toEqual(0);
        System.out.println("Size: " + heap.size());
        heap.insert(5);
        heap.insert(3);
        heap.insert(69);
        heap.insert(420);
        heap.insert(4);
        heap.insert(1);
        heap.insert(8);
        heap.insert(7);
       // expect(heap.length).toEqual(8);
        System.out.println("Size: " + heap.size());
        System.out.println(heap);
       // expect(heap.delete()).toEqual(1);
       // expect(heap.delete()).toEqual(3);
       // expect(heap.delete()).toEqual(4);
       // expect(heap.delete()).toEqual(5);
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
       // expect(heap.length).toEqual(4);
        System.out.println("Size: " + heap.size());
       // expect(heap.delete()).toEqual(7);
       // expect(heap.delete()).toEqual(8);
       // expect(heap.delete()).toEqual(69);
       // expect(heap.delete()).toEqual(420);
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
       // expect(heap.length).toEqual(0);
        System.out.println("Size: " + heap.size());
        System.out.println(heap.delete());
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
        System.out.println(pre);
        QueueX<Integer> in = t.inOrderSearch(tree1);
        System.out.println(in);
        QueueX<Integer> post = t.postOrderSearch(tree1);
        System.out.println(post);
        // Pre: [ 20, 10, 5, 7, 15, 50, 30, 29, 45, 100 ]
        // In: [ 5, 7, 10, 15, 20, 29, 30, 45, 50, 100 ]
        // Post: [ 7, 5, 15, 10, 29, 45, 30, 100, 50, 20 ]
        // --------------------------------------------------------------
        System.out.println("\nDFSTest:");
        DFS dfs = new DFS();
        System.out.println(dfs.search(tree1, 45));
        System.out.println(dfs.search(tree1, 7));
        System.out.println(dfs.search(tree1, 69));
        // --------------------------------------------------------------
        System.out.println("\nCompareBTTest:");
        CompareBT cbt = new CompareBT();
        System.out.println(cbt.compare(tree1, tree1));
        System.out.println(cbt.compare(tree1, tree2));
        // ---------------------------------------------------------------
        System.out.println("\nBFSTest:");
        System.out.println(BFS.search(tree1, 45));
        System.out.println(BFS.search(tree1, 31));
        System.out.println(BFS.search(tree1, 69));
    }

    public void HashMapTest(){
        HashMapX<String, Integer> map = new HashMapX<>();
        map.set("foo", 55);
        //expect(map.size()).toEqual(1);
        System.out.println(map.size());
        map.set("fool", 75);
        //expect(map.size()).toEqual(2);
        System.out.println(map.size());
        map.set("foolish", 105);
        //expect(map.size()).toEqual(3);
        System.out.println(map.size());
        map.set("bar", 69);
        //expect(map.size()).toEqual(4);
        System.out.println(map.size());
        System.out.println(map);

        map.set("test", 222).set("size", 00).set("remap", 33).set("milk", 12).set("cookies", 67);
        //expect(map.get("bar")).toEqual(69);
        System.out.println(map.get("bar"));
        //expect(map.get("blaz")).toEqual(undefined);
        System.out.println(map.get("blaz"));
        map.delete("barblabr");
        //expect(map.size()).toEqual(9);
        System.out.println(map.size());
        map.delete("bar");
        //expect(map.size()).toEqual(8);
        //expect(map.get("bar")).toEqual(undefined);
        System.out.println(map.size());
        System.out.println(map.get("bar"));
        //System.out.println(map.delete("foo"));
        //System.out.println(map.delete("size"));
        System.out.println(map.get("milk"));
        System.out.println(map);
        System.out.println(Arrays.toString(map.keys()));
        System.out.println(Arrays.toString(map.values()));    
    }

    public void ListTest(){
        ArrayListX<Integer> list = new ArrayListX<>(4);
        //LinkedListX<Integer> list = new LinkedListX<>();
        list.append(5);
        list.append(7);
        list.append(9);
        System.out.println(list);
        //expect(list.get(2)).toEqual(9);
        //expect(list.removeAt(1)).toEqual(7);
        //expect(list.length).toEqual(2);   
        System.out.println(list.get(2));
        System.out.println(list.removeAt(1));
        System.out.println(list.size());
        list.append(11);
        //expect(list.removeAt(1)).toEqual(9);
        //expect(list.remove(9)).toEqual(undefined);
        //expect(list.removeAt(0)).toEqual(5);
        //expect(list.removeAt(0)).toEqual(11);
        //expect(list.length).toEqual(0);     
        System.out.println(list.removeAt(1));
        System.out.println(list.remove(9));
        System.out.println(list.removeAt(0));
        System.out.println(list.removeAt(0));
        System.out.println(list.size());
        list.prepend(5);
        list.prepend(7);
        list.prepend(9);
        System.out.println(list);
        //expect(list.get(2)).toEqual(5);
        //expect(list.get(0)).toEqual(9);
        //expect(list.remove(9)).toEqual(9);
        //expect(list.length).toEqual(2);
        //expect(list.get(0)).toEqual(7);
        System.out.println(list.get(2));
        System.out.println(list.get(0));
        System.out.println(list.remove(9));
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.remove(7);
        list.remove(5);
        for (int i = 0; i < 12; i++) {
            list.append(i);
        }
        System.out.println(list);
        list.insertAt(420, 11);
        System.out.println(list);
        list.set(421, 12);
        System.out.println(list);
        System.out.println(list.removeAt(list.size() - 1));
        list.insertAt(69,0);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
*/
    public void QueueTest(){
        QueueX<Integer> q = new LinkedListX<>();
        q.offer(5);
        q.offer(9);
        q.offer(11);
        System.out.println(q);
        q.reverse();
        System.out.println(q);
        q.reverse();
        System.out.println(q.size());
        q.poll();
        q.poll();
        System.out.println(q.size());
        System.out.println(q.poll());
        q.offer(69);
        System.out.println(q.size());
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);
        System.out.println(q.size());
    }

    public void StackTest(){
        StackX<Integer> list = new StackX<>();
        list.push(5).push(7).push(9);
        //list.push(7);
        //list.push(9);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        list.reverse();
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

    public void TwoCrystalTest(){
        Random rand = new Random();
        int idx = rand.nextInt(10000);
        boolean[] data = new boolean[10000];
        for (int i = idx; i < 10000; i++) {
            data[i] = true;
        }
        boolean[] data2 = new boolean[1000];
        boolean[] data3 = new boolean[1000];
        Arrays.fill(data3,true);
        System.out.println("Idx: " + idx + ", Data: " + TwoCrystals.find(data));
        System.out.println("False array: " + TwoCrystals.find(data2));
        System.out.println("All true: " + TwoCrystals.find(data3));
    }

    public void BinarySearchTest(){
        Random rand = new Random();
        int[] nums = generateRandomArray(10,20);
        //Arrays.sort(nums);
        QuickSort q = new QuickSort();
        q.sort(nums);
        int target = rand.nextInt(25);
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Found?: " + BinarySearch.search(nums, target));
    } 
    
    public void MergeSortTest(){
        MergeSort q = new MergeSort();
        //Integer[] arr = Arrays.stream(this.generateRandomArray(6,50)).boxed().toArray(Integer[]::new);
        int[] arr = this.generateRandomArray(6,50);
        System.out.println(Arrays.toString(arr));
        q.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void QuickSortTest(){
        QuickSort q = new QuickSort();
        //Integer[] arr = Arrays.stream(this.generateRandomArray(6,50)).boxed().toArray(Integer[]::new);
        int[] arr = this.generateRandomArray(10,100);
        //System.out.println(Arrays.toString(arr));
        Instant start = Instant.now();
        q.sort(arr);
        Instant end = Instant.now();
        Duration dur = Duration.between(start,end);
        System.out.println("Quick Sort: " + Arrays.toString(arr));
        System.out.println("Running time: " + dur.toMillis() + "ms");
    } 
    
    public void InsertionSortTest(){
        InsertionSort insert = new InsertionSort();
        int[] obj = this.generateRandomArray(10,100);
        //System.out.println("Original: " + Arrays.toString(obj));
        //ArrayListX<Integer> arr = new ArrayListX<>(Arrays.stream(obj).boxed().toArray(Object[]::new),10);
        Instant start = Instant.now();
        insert.sort(obj);
        Instant end = Instant.now();
        Duration dur = Duration.between(start,end);
        System.out.println("Insertion Sort: " + Arrays.toString(obj));
        System.out.println("Running time: " + dur.toMillis() + "ms");
    } 
    
    public void BubbleSortTest(){
        int[] nums = generateRandomArray(10,100);
        int[] test = Arrays.stream(nums).toArray();
        Instant start = Instant.now();
        BubbleSort.sort(nums);
        Instant end = Instant.now();
        Duration dur = Duration.between(start,end);
        //Arrays.sort(test);
        System.out.println("Bubble Sort: " + Arrays.toString(nums));
        System.out.println("Running time: " + dur.toMillis() + "ms");
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
