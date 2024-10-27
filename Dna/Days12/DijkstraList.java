import utils.GraphEdge;
import java.util.ArrayList;
import java.util.Arrays;
import utils.MinHeap;
import utils.GraphNode;

public class DijkstraList {

    public ArrayList<Integer> graph(int source, int sink, GraphEdge[][] arr) {
        boolean[] seen = new boolean[arr.length];
        int[] prev = new int[arr.length];
        double[] dists = new double[arr.length];
        Arrays.fill(prev,-1);
        Arrays.fill(dists,Double.POSITIVE_INFINITY);
        MinHeap<GraphNode> nodes = new MinHeap<>();
        GraphNode g = new GraphNode(0,0);
        nodes.insert(g);

        dists[source] = 0;

        while(nodes.size() > 0){
            System.out.println(nodes);
            GraphNode lowest = nodes.delete();
            int curr = lowest.node();
            seen[curr] = true;
            if(curr == sink){
                break;
            }

            GraphEdge[] adjs = arr[curr];
            for (int i = 0; i < adjs.length; i++) {
                GraphEdge edge = adjs[i];
                if(seen[edge.to()])
                    continue;
                double dist = dists[curr] + edge.weight();
                if(dist < dists[edge.to()]){
                    GraphNode next = new GraphNode(edge.to(),dist);
                    nodes.insert(next);
                    prev[edge.to()] = curr;
                    dists[edge.to()] = dist;
                }
            }
        }
        ArrayList<Integer> out = new ArrayList<>();
        int curr = sink;
        while(prev[curr] != -1){
            out.add(0,curr);
            curr = prev[curr];
        }
        if(out.size() > 0)
            out.add(0,source);
        return out;
    }

    private boolean hasUnvisited(boolean[] seen, double[] dists){
        for (int i = 0; i < seen.length; i++) {
            if(!seen[i] && dists[i] < Double.POSITIVE_INFINITY)
                return true;
        }
        return false;
    }

    private int lowestUnvisited(boolean[] seen, double[] dists){
        int idx = -1;
        double lowest = Double.POSITIVE_INFINITY;

        for (int i = 0; i < dists.length; i++) {
            if(seen[i])
                continue;
            if(lowest > dists[i]){
                lowest = dists[i];
                idx = i;
            }
        }

        return idx;
    }

}
