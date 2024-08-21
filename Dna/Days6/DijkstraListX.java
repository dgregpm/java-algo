import java.util.Arrays;
import utils.ArrayListX;
import utils.GraphEdge;

public class DijkstraListX {
    public ArrayListX<Integer> graph(int source, int sink, GraphEdge[][] g){
        boolean[] seen = new boolean[g.length];
        double[] dists = new double[g.length];
        int[] prev = new int[g.length];
        Arrays.fill(dists,Double.POSITIVE_INFINITY);
        Arrays.fill(prev, -1);
        dists[source] = 0;

        while(this.hasUnvisited(seen,dists)){
            int curr = lowestUnvisited(seen,dists);
            seen[curr] = true;

            GraphEdge[] adjs = g[curr];
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
        System.out.println(Arrays.toString(prev));
        return out;
    }

    public boolean hasUnvisited(boolean[] seen, double[] dists){
        for (int i = 0; i < seen.length; i++) {
            if(!seen[i] && dists[i] < Double.POSITIVE_INFINITY)
                return true;
        }
        return false;
    }

    public int lowestUnvisited(boolean[] seen, double[] dists){
        int idx = -1;
        double lowestDistance = Double.POSITIVE_INFINITY;
        
        for (int i = 0; i < seen.length; i++) {
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
