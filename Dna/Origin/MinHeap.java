import java.util.ArrayList;

public class MinHeap {
    public int length;
    private ArrayList<Integer> data;
    
    MinHeap() {
        data = new ArrayList<>();
        length = 0;
    }

    public void insert(int value) {
        this.data.add(value);
        this.heapifyUp(this.length);
        this.length++;
    }
    
    public int delete() {
        if(this.length == 0)
            return -1;
        
        int out = this.data.get(0);

        this.length--;
        this.data.set(0, this.data.get(this.length));
        this.heapifyDown(0);
        return out;
    }

    private void heapifyDown(int idx){
        if(idx >= this.length)
            return;
        
        int lIdx = this.leftChild(idx);
        int rIdx = this.rightChild(idx);
        
        if(lIdx >= this.length)
            return;

        int lV = this.data.get(lIdx);
        int rV;
        if(rIdx >= this.length)
            rV = lV + 1;
        else
            rV = this.data.get(rIdx);
            
        int v = this.data.get(idx);

        if(lV < rV && v > lV){
            this.data.set(idx, lV);
            this.data.set(lIdx, v);
            this.heapifyDown(lIdx);
        } else if(rV < lV && v > rV){
            this.data.set(idx, rV);
            this.data.set(rIdx, v);
            this.heapifyDown(rIdx);
        }

    }

    private void heapifyUp(int idx){
        if(idx == 0)
            return;
        int p = this.parent(idx);
        int parentV = this.data.get(p);
        int v = this.data.get(idx);

        if(parentV > v){
            this.data.set(idx, parentV);
            this.data.set(p, v);
            this.heapifyUp(p);
        }
    }

    private int parent(int idx){
        return (idx - 1)/2;
    }

    private int leftChild(int idx){
        return (2 * idx) + 1;
    }

    private int rightChild(int idx){
        return (2 * idx) + 2;
    }
}
