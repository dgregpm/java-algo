import utils.ArrayListX;
import utils.QueueX;

public class MinHeap {
    private ArrayListX<Integer> arr;
    
    MinHeap() {
        arr = new ArrayListX<>();
    }

    private void heapifyUp(int idx){
        if(!inRange(idx))
            return;
        int pIdx = this.parent(idx);
        int pV = this.arr.get(pIdx);
        int cV = this.arr.get(idx);
        if(cV < pV){
            this.arr.set(pIdx,cV);
            this.arr.set(idx,pV);
            this.heapifyUp(pIdx);
        }
    }

    private void heapifyDown(int idx){
        if(!inRange(idx))
            return;
        int lIdx = this.leftChild(idx);
        int rIdx = this.rightChild(idx);
        int pV = this.arr.get(idx);
        if(!inRange(lIdx))
            return;
        int lV = this.arr.get(lIdx);
        int rV = lV + 1;
        if(inRange(rIdx))
            rV = this.arr.get(rIdx);

        if(lV <= rV && lV < pV){
            this.arr.set(idx, lV);
            this.arr.set(lIdx, pV);
            this.heapifyDown(lIdx);
        } else if(rV < lV && rV < pV){
            this.arr.set(idx, rV);
            this.arr.set(rIdx, pV);
            this.heapifyDown(rIdx);
        }
    }

    public void insert(int value) {
        this.arr.append(value);
        this.heapifyUp(this.size() - 1);
    }
    
    public int delete() {
        if(this.size() == 0)
            return -1;
        else if(this.size() == 1)
            return this.arr.removeAt(0);
        
        int curr = this.arr.get(0);
        this.arr.set(0,this.arr.removeAt(this.size() - 1));
        this.heapifyDown(0);
        return curr;
    }

    public int size() {
        return this.arr.size();
    }

    public String toString(){
        if(this.size() == 0)
            return "[ ]";
        QueueX<ArrayListX<Integer>> path = new QueueX<>();
        ArrayListX<Integer> kids = new ArrayListX<>();
        kids.append(0);
        path.enqueue(kids);
        StringBuilder sb = new StringBuilder();
        while(path.size() > 0){
            ArrayListX<Integer> curr = path.deque();
            ArrayListX<Integer> children = new ArrayListX<>();
            sb.append("[ ");
            for (int i = 0; i < curr.size(); i++) {
                int pIdx = curr.get(i);
                sb.append(this.arr.get(pIdx)).append(" ");
                int lIdx = this.leftChild(pIdx);
                int rIdx = this.rightChild(pIdx);
                if(inRange(lIdx))
                    children.append(lIdx);
                if(inRange(rIdx))
                    children.append(rIdx);

            }
            sb.append("]\n");
            if(children.size() > 0)
                path.enqueue(children);
        }
        return sb.toString();
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.size())
            return false;
        else
            return true;
    }

    private int parent(int idx) {
        return (idx - 1)/2;
    }

    private int leftChild(int idx) {
        return 2*idx + 1;
    }

    private int rightChild(int idx) {
        return 2*idx + 2;
    }
}
