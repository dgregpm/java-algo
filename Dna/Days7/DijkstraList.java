import utils.ArrayListX;
import utils.GraphEdge;
import java.util.Arrays;

public class DijkstraList {

    public ArrayListX<Integer> graph(int source, int sink, GraphEdge[][] arr) {
        boolean[] seen = new boolean[arr.length];
        double[] dists = new double[arr.length];
        int[] prev = new int[arr.length];
        Arrays.fill(dists,Double.POSITIVE_INFINITY);
        Arrays.fill(prev,-1);

        dists[source] = 0;

        while(hasUnvisited(seen,dists)){
            int curr = getLowestUnvisited(seen,dists);
            seen[curr] = true;

            GraphEdge[] adjs = arr[curr];
            for (int i = 0; i < adjs.length; i++) {
                GraphEdge edge = adjs[i];
                if(seen[edge.to()])
                    continue;

                double dist = dists[curr] + edge.weight();
                if(dist < dists[edge.to()]){
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
