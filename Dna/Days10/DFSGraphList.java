import utils.StackX;
import utils.GraphEdge;

public class DFSGraphList {

    public StackX<Integer> dfs(GraphEdge[][] graph, int source, int needle) {
        boolean[] seen = new boolean[graph.length];
        StackX<Integer> path = new StackX<>();

        walk(graph,source,needle,seen,path);
        return path.reverse();
    }

    private boolean walk(GraphEdge[][] graph, int curr, int needle, boolean[] seen, StackX<Integer> path){
        if(seen[curr])
            return false;
        if(curr == needle){
            path.push(curr);
            return true;
        }

        seen[curr] = true;
        path.push(curr);
        GraphEdge[] adjs = graph[curr];
        for (int i = 0; i < adjs.length; i++) {
            GraphEdge edge = adjs[i];
            if(walk(graph,edge.to(),needle,seen,path))
                return true;
        }
        path.pop();
        return false;
    }

}
