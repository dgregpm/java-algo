import utils.ArrayListX;
import utils.QueueX;

public class MinHeap {
    private ArrayListX<Integer> arr; 
    
    MinHeap() {
        this.arr = new ArrayListX<>();
    }

    private boolean inRange(int idx){
        if(idx >= 0 && idx < this.size())
            return true;
        return false;
    }

    private void heapifyUp(int idx){
        if(!inRange(idx))
            return;
        int pIdx = this.parent(idx);
        if(!inRange(pIdx))
            return;
        int pV = this.arr.get(pIdx);
        int cV = this.arr.get(idx);

        if(cV < pV){
            this.swap(pIdx,idx,pV,cV);
            heapifyUp(pIdx);
        }
    }
    
    private void heapifyDown(int idx){
        if(!inRange(idx))
            return;

        int pV = this.arr.get(idx);
        int lIdx = this.leftChild(idx);
        int rIdx = this.rightChild(idx);
        if(!inRange(lIdx))
            return;
        
        int lV = this.arr.get(lIdx);
        int rV = lV + 1;
        if(inRange(rIdx))
            rV = this.arr.get(rIdx);
        
        if(lV <= rV && lV < pV){
            this.swap(lIdx,idx,lV,pV);
            this.heapifyDown(lIdx);
        } else if(rV < lV && rV < pV){
            this.swap(rIdx,idx,rV,pV);
            this.heapifyDown(rIdx);
        }
    }

    private void swap(int x,int y,int xVal,int yVal){
            this.arr.set(x,yVal);
            this.arr.set(y,xVal);
    }

    public void insert(int value) {
        this.arr.append(value);
        this.heapifyUp(this.arr.size() - 1);
    }
    
    public int delete() {
        if(this.size() == 0)
            return -1;

        if(this.size() <= 2)
            return this.arr.removeAt(0);
        else {
            int res = this.arr.get(0);
            this.arr.set(0,this.arr.removeAt(this.size() - 1));
            this.heapifyDown(0);
            return res;
        }
    }

    public int size(){
        return this.arr.size();
    }

    @Override
    public String toString(){
        if(this.size() == 0)
            return this.arr.toString();

        ArrayListX<Integer> kids = new ArrayListX<>();
        kids.append(0);
        QueueX<ArrayListX<Integer>> level = new QueueX<>();
        level.enqueue(kids);
        StringBuilder sb = new StringBuilder();
        while(level.size() > 0){
            ArrayListX<Integer> next = new ArrayListX<>();
            kids = level.deque();
            sb.append("[ ");
            for (int i = 0; i < kids.size(); i++) {
                int p = kids.get(i);
                sb.append(this.arr.get(p));
                if(i < kids.size() - 1)
                sb.append(" ");
                
                int l = this.leftChild(p);
                int r = this.rightChild(p);
                if(inRange(l))
                    next.append(l);
                if(inRange(r))
                    next.append(r);
            }
            sb.append(" ]\n");
            if(next.size() > 0)
                level.enqueue(next);
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
