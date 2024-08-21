import utils.ArrayListX;
import utils.StackX;

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
            this.arr.set(cV,pIdx);
            this.arr.set(pV,idx);
            this.heapifyUp(pIdx);
        }
    }

    private void heapifyDown(int idx){
        if(!inRange(idx))
            return;
        int lIdx = this.leftChild(idx);
        int rIdx = this.rightChild(idx);
        if(!inRange(lIdx))
            return;
        
        int pV = this.arr.get(idx);
        int lV = this.arr.get(lIdx);
        int rV = lV + 1;
        if(inRange(rIdx))
            rV = this.arr.get(rIdx);

        if(lV <= rV && lV < pV){
            this.arr.set(lV,idx);
            this.arr.set(pV,lIdx);
            this.heapifyDown(lIdx);
        } else if(rV < lV && rV < pV){
            this.arr.set(rV,idx);
            this.arr.set(pV,rIdx);
            this.heapifyDown(rIdx);
        }
    }

    public void insert(int value) {
        this.arr.append(value);
        this.heapifyUp(this.size() - 1);
    }
    
    public int delete() {
        if(this.size() <= 0)
            return -1;
        if(this.size() <= 2)
            return this.arr.removeAt(0);
        else{
            int res = this.arr.get(0);
            this.arr.set(this.arr.removeAt(this.size() - 1),0);
            this.heapifyDown(0);
            return res;
        }
    }

    @Override
    public String toString(){
        if(this.size() == 0)
            return "[ ]";
        StringBuilder sb = new StringBuilder();
        StackX<ArrayListX<Integer>> tree = new StackX<>();
        ArrayListX<Integer> root = new ArrayListX<>();
        root.append(0);
        tree.push(root);
        while(tree.size() > 0){
            sb.append("[ ");
            ArrayListX<Integer> curr = tree.pop();
            ArrayListX<Integer> next = new ArrayListX<>();
            
            for (int i = 0; i < curr.size(); i++) {
                int p = curr.get(i);
                sb.append(this.arr.get(p));
                if(i < curr.size() - 1)
                    sb.append(" ");
                int lIdx = this.leftChild(p);
                int rIdx = this.rightChild(p);
                if(inRange(lIdx))
                    next.append(lIdx);
                if(inRange(rIdx))
                    next.append(rIdx);
            }
            
            if(next.size() > 0)
                tree.push(next);
            sb.append(" ]\n");
        }

        return sb.toString();
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
}
