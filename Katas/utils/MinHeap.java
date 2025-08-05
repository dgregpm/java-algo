package utils;

public class MinHeap<T extends Comparable> {
    private ArrayListX<T> arr;
    
    public MinHeap() {
        this.arr = new ArrayListX<>();
    }

    private boolean inRange(int idx){
        if(idx < 0 || idx >= this.size())
            return false;
        return true;
    }

    private void heapifyUp(int idx){
        if(!inRange(idx))
            return;
        int pIdx = this.parent(idx);
        if(!inRange(pIdx))
            return;
        T pV = this.arr.get(pIdx);
        T cV = this.arr.get(idx);
        if(cV.compareTo(pV) < 0){
            this.arr.set(pV,idx);
            this.arr.set(cV,pIdx);
            this.heapifyUp(pIdx);
        }
    }

    private void heapifyDown(int idx){
        if(!inRange(idx))
            return;
        int lIdx = this.leftChild(idx);
        if(!inRange(lIdx))
            return;
        int rIdx = this.rightChild(idx);
        T rV = null;
        if(inRange(rIdx))
            rV = this.arr.get(rIdx);

        T pV = this.arr.get(idx);
        T lV = this.arr.get(lIdx);

        if(rV != null){
            if(lV.compareTo(rV) <= 0 && lV.compareTo(pV) < 0){
                this.arr.set(lV,idx);
                this.arr.set(pV,lIdx);
                this.heapifyDown(lIdx);
            } else if(rV.compareTo(lV) < 0 && rV.compareTo(pV) < 0){
                this.arr.set(rV,idx);
                this.arr.set(pV,rIdx);
                this.heapifyDown(rIdx);
            }
        } else {
            if(lV.compareTo(pV) < 0){
                this.arr.set(lV,idx);
                this.arr.set(pV,lIdx);
                this.heapifyDown(lIdx);
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
            this.arr.set(this.arr.removeAt(this.size() - 1),0);
            this.heapifyDown(0);
        }
        return res;
    }

    public int size(){
        return this.arr.size();
    }

    @Override
    public String toString(){
        if(this.size() == 0)
            return "[ ]";
        StringBuilder sb = new StringBuilder();
        QueueX<ArrayListX<Integer>> rows = new QueueX<>();
        ArrayListX<Integer> top = new ArrayListX<>();
        top.append(0);
        rows.enqueue(top);
        while(rows.size() > 0){
            ArrayListX<Integer> curr = rows.deque();
            ArrayListX<Integer> next = new ArrayListX<>();
            sb.append("[ ");
            for (int i = 0; i < curr.size(); i++) {
                int pIdx = curr.get(i);
                sb.append(this.arr.get(pIdx));
                if(i < curr.size() - 1)
                    sb.append(" ");

                int lIdx = this.leftChild(pIdx);
                int rIdx = this.rightChild(pIdx);
                if(inRange(lIdx))
                    next.append(lIdx);
                if(inRange(rIdx))
                    next.append(rIdx);
            }
            sb.append(" ]\n");
            if(next.size() > 0)
                rows.enqueue(next);
        }
        return sb.toString();
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
}
