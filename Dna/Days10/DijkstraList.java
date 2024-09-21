import utils.GraphEdge;
import utils.ArrayListX;
import java.util.Arrays;
import utils.MinHeap;
import utils.GraphNode;

public class DijkstraList {

    public ArrayListX<Integer> graph(int source, int sink, GraphEdge[][] arr) {
        boolean[] seen = new boolean[arr.length];
        double[] dists = new double[arr.length];
        int[] prev = new int[arr.length];
        Arrays.fill(dists,Double.POSITIVE_INFINITY);
        Arrays.fill(prev,-1);
        MinHeap<GraphNode> heap = new MinHeap<>();
        GraphNode[] gArr = new GraphNode[arr.length];
        for (int i = 0; i < arr.length; i++) {

            GraphNode g = gArr[i] = new GraphNode(i,Double.POSITIVE_INFINITY);
            if(i == source)
                g.setDistance(0);
            heap.insert(g);
        }

        dists[source] = 0;

        while(heap.size() > 0){
            GraphNode node = heap.delete();
            int curr = node.getNode();
            if(seen[curr])
                continue;
            seen[curr] = true;

            GraphEdge[] adjs = arr[curr];
            for (int i = 0; i < adjs.length; i++) {
                GraphEdge edge = adjs[i];
                if(seen[edge.to()])
                    continue;
                double dist = node.getDistance() + edge.weight();
                if(dist < dists[edge.to()]){
                    dists[edge.to()] = dist;
                    prev[edge.to()] = curr;
                
                    GraphNode next = new GraphNode(edge.to(),dist);
                    heap.insert(next);
                }
            }
        }

        ArrayListX<Integer> out = new ArrayListX<>();
        int curr = sink;
        while (prev[curr] != -1) {
            out.prepend(curr);
            curr = prev[curr];
        }

        if(out.size() > 0)
            out.prepend(source);
        return out;
    }
    
    private boolean hasUnvisited(boolean[] seen, double[] dists){
        for (int i = 0; i < seen.length; i++) {
            if(!seen[i] && dists[i] < Double.POSITIVE_INFINITY)
                return true;
        }
        return false;
    }

    private int getLowestUnvisited(boolean[] seen, double[] dists){
        int idx = -1;
        double lowestDistance = Double.POSITIVE_INFINITY;

        for (int i = 0; i < dists.length; i++) {
            if(seen[i])
                continue;

            if(lowestDistance > dists[i]){
                lowestDistance = dists[i];
                idx = i;
            }
        }
        return idx;
    }
}
