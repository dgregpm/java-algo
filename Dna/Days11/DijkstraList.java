import utils.ArrayListX;
import utils.GraphEdge;
import java.util.Arrays;
import utils.MinHeap;
import utils.GraphNode;

public class DijkstraList {

    public ArrayListX<Integer> graph(int source, int sink, GraphEdge[][] arr) {
        boolean[] seen = new boolean[arr.length];
        int[] prev = new int[arr.length];
        double[] dists = new double[arr.length];
        Arrays.fill(prev,-1);
        Arrays.fill(dists,Double.POSITIVE_INFINITY);
        MinHeap<GraphNode> heap = new MinHeap<>();
        GraphNode s = new GraphNode(source,0);
        
        dists[source] = 0;
        heap.insert(s);

        while(heap.size() > 0){
            GraphNode gn = heap.delete();
            System.out.println(gn);
            int curr = gn.node();
            if(seen[curr])
                continue;
            seen[curr] = true;

            GraphEdge[] adjs = arr[curr];
            for (int i = 0; i < adjs.length; i++) {
                GraphEdge edge = adjs[i];
                if(seen[edge.to()])
                    continue;
                double dist = dists[i] + edge.weight();
                if(dist < dists[edge.to()]){
                    GraphNode nn = new GraphNode(edge.to(),dist);
                    heap.insert(nn);
                    dists[edge.to()] = dist;
                    prev[edge.to()] = curr;
                }
            } 
        }
        ArrayListX<Integer> out = new ArrayListX<>();
        int curr = sink;
        while(prev[curr] != -1){
            out.prepend(curr);
            curr = prev[curr];
        }
        if(out.size() > 0)
            out.prepend(source);
        return out;
    }

    private boolean hasUnvisited(boolean[] seen, double[] dists){
        for (int i = 0; i < seen.length; i++) {
            if(!seen[i] && dists[i] < Double.POSITIVE_INFINITY){
                return true;
            }
        }        
        return false;
    }

    private int lowestUnvisited(boolean[] seen, double[] dists){
        int idx = -1;

        double lowestDistance = Double.POSITIVE_INFINITY;

        for (int i = 0; i < dists.length; i++) {
            if(seen[i])
                continue;
            if(dists[i] < lowestDistance){
                lowestDistance = dists[i];
                idx = i;
            }
        }
        return idx;
    }

}
