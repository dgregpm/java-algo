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
        if(curr == needle){
            path.push(curr);
            return true;
        }
        if(seen[curr])
            return false;

        path.push(curr);
        seen[curr] = true;

        GraphEdge[] adjs = graph[curr];
        for (int i = 0; i < adjs.length; i++) {
            if(walk(graph,adjs[i].to(),needle,seen,path))
                return true;
        }

        path.pop();
        return false;
    }
}
