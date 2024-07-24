import java.util.ArrayList;

public class MinHeap {
    private int length;
    private ArrayList<Integer> arr; 
    
    MinHeap() {
        this.arr = new ArrayList<Integer>();
    }

    private void heapifyUp(int idx){
        if(idx <= 0)
            return;
        int pIdx = this.parent(idx);
        int pV = this.arr.get(pIdx);
        int cV = this.arr.get(idx);
        if(pV > cV){
            this.arr.set(pIdx, cV);
            this.arr.set(idx, pV);
            this.heapifyUp(pIdx);
        }
    }

    private void heapifyDown(int idx){
        int lIdx = this.leftChild(idx);
        int rIdx = this.rightChild(idx);
        //System.out.println("This Length: " + this.length + ", Arr Length: " + arr.size());
        
        if(idx >= this.length || lIdx >= this.length)
            return;

        int pV = this.arr.get(idx);
        int lV = this.arr.get(lIdx);
        int rV;
        if(rIdx >= this.length)
            rV = lV + 1;
        else
            rV = this.arr.get(rIdx);

        if(lV < rV && pV > lV){
            this.arr.set(idx, lV);
            this.arr.set(lIdx, pV);
            this.heapifyDown(lIdx);
        } else if(rV < lV && pV > rV){
            this.arr.set(idx, rV);
            this.arr.set(rIdx, pV);
            this.heapifyDown(rIdx);
        }
    }

    public void insert(int value) {
        this.arr.add(value);
        this.heapifyUp(this.length);
        this.length++;
    }
    
    public int delete() {
        if(this.length == 0)
            return -1;
        int res = this.arr.get(0);
        int lastV = this.arr.get(this.length - 1);
        this.arr.set(0, lastV);
        this.arr.remove(this.length - 1);
        this.length--;
        heapifyDown(0);
        return res;
    }

    public int size(){
        return this.length;
    }

    private int parent(int idx){
        return (int)((idx - 1)/2);
    }

    private int leftChild(int idx){
        return 2*idx + 1;
    }

    private int rightChild(int idx){
        return 2*idx + 2;
    }
}
