package utils;

public class MinHeap<T extends Comparable<T>> {
    private ArrayListX<T> arr;

    
    public MinHeap() {
        this.arr = new ArrayListX<>();
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.size())
            return false;
        return true;
    }

    public int size(){
        return this.arr.size();
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

    private void heapifyUp(int idx){
        int pIdx = this.parent(idx);
        if(!inRange(pIdx))
            return;
        T pV = this.arr.get(pIdx);
        T cV = this.arr.get(idx);

        if(cV.compareTo(pV) < 0){
            this.arr.set(idx,pV);
            this.arr.set(pIdx,cV);
            this.heapifyUp(pIdx);
        }
    }

    private void heapifyDown(int idx){
        int lIdx = this.leftChild(idx);
        if(!inRange(lIdx))
            return;
        T pV = this.arr.get(idx);
        T lV = this.arr.get(lIdx);
        int rIdx = this.rightChild(idx);
        T rV = null;
        if(inRange(rIdx))
            rV = this.arr.get(rIdx);
        if(rV == null){
            if(lV.compareTo(pV) < 0){
                this.arr.set(idx,lV);
                this.arr.set(lIdx,pV);
                this.heapifyDown(lIdx);
            }
        } else {
            if(lV.compareTo(rV) <= 0 && lV.compareTo(pV) < 0){
                this.arr.set(idx,lV);
                this.arr.set(lIdx,pV);
                this.heapifyDown(lIdx);
            } else if(rV.compareTo(lV) < 0 && rV.compareTo(pV) < 0){
                this.arr.set(idx,rV);
                this.arr.set(rIdx,pV);
                this.heapifyDown(rIdx);
            }
        }
    }

    public void insert(T value) {
        this.arr.append(value);
        this.heapifyUp(this.size() - 1);
    }
    
    public T delete() {
        if(this.size() == 0)
            return null;
        T res = this.arr.get(0);
        if(this.size() <= 2)
            this.arr.removeAt(0);
        else {
            this.arr.set(0, this.arr.removeAt(this.size() - 1));
            this.heapifyDown(0);
        }
        return res;
    }

    @Override
    public String toString(){
        return this.arr.toString();
    }
}
