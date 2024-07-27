import utils.ArrayListX;
import utils.QueueX;
import utils.StackX;

public class MinHeap {
    private ArrayListX<Integer> heap;

    MinHeap() {
        this.heap = new ArrayListX<>();
    }

    private void heapifyUp(int idx){
        if(idx <= 0)
            return;
        int pIdx = this.parent(idx);
        int pV = this.heap.get(pIdx);
        int cV = this.heap.get(idx);
        if(cV < pV){
            this.heap.set(pIdx,cV);
            this.heap.set(idx,pV);
            this.heapifyUp(pIdx);
        }
    }

    private void heapifyDown(int idx){
        int lIdx = this.leftChild(idx);
        if(idx >= this.size() || lIdx >= this.size())
            return;
        int rIdx = this.rightChild(idx);
       // System.out.println("Size: " + this.size() + ", idx: " + idx + ", lIdx: " + lIdx);
        int pV = this.heap.get(idx);
        int lV = this.heap.get(lIdx);
        int rV = 0;
        if(rIdx >= this.size())
            rV = lV + 1;
        else
            rV = this.heap.get(rIdx);

        if(lV < rV && lV < pV){
            this.heap.set(idx, lV);
            this.heap.set(lIdx, pV);
            this.heapifyDown(lIdx);
        } else if(rV < lV && rV < pV){
            this.heap.set(idx, rV);
            this.heap.set(rIdx, pV);
            this.heapifyDown(rIdx);
        }
    }

    public void insert(int value) {
        this.heap.append(value);
        this.heapifyUp(this.size() - 1);
    }
    
    public int delete() {
        if(this.size() <= 0)
            return -1;
        else if(this.size() == 1)
            return this.heap.removeAt(0);
        else {
            int tmp = this.heap.get(0);
            this.heap.set(0, this.heap.removeAt(this.size() - 1));
            this.heapifyDown(0);
            return tmp;
        }
    }

    public int size(){
        return this.heap.size();
    }

    private int parent(int idx){
        return (idx - 1)/2;
    }

    private int leftChild(int idx){
        return 2*idx + 1;
    }

    private int rightChild(int idx){
        return 2*idx + 2;
    }

    public String toString(){
        if(this.size() == 0)
            return "[ ]";
        StackX<ArrayListX<Integer>> tree = new StackX<>();
        ArrayListX<Integer> bfs = new ArrayListX<>();
        QueueX<String> leaf = new QueueX<>();
        bfs.append(0);
        leaf.enqueue(this.heap.get(0).toString());
        tree.push(bfs);
        for (int i = 1; i < this.size();) {
            ArrayListX<Integer> curr = tree.peek();
            ArrayListX<Integer> next = new ArrayListX<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < curr.size(); j++) {
                                
                int pIdx = curr.get(j);
                int lIdx = this.leftChild(pIdx);
                int rIdx = this.rightChild(pIdx);
                if(lIdx < this.size()){
                    next.append(lIdx);
                    sb.append(this.heap.get(lIdx).toString());
                    sb.append(" ");
                    i++;
                }
                if(rIdx < this.size()){
                    next.append(rIdx);
                    sb.append(this.heap.get(rIdx).toString());
                    sb.append(" ");
                    i++;
                }
            }
            leaf.enqueue(sb.toString());
            tree.push(next);
        }
        while(leaf.size() > 0){
            System.out.println("Wtf... " + leaf.deque());
        }
        return this.heap.toString();
    }
}
