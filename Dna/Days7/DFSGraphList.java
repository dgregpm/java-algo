import utils.GraphEdge;
import utils.ArrayListX;
import utils.StackX;

public class DFSGraphList {

    public  StackX<Integer> dfs(GraphEdge[][] graph, int source, int needle) {
        boolean[] seen = new boolean[graph.length];
        StackX<Integer> path = new StackX<>();

        helper(graph,source,needle,seen,path);
        path.reverse();
        return path;
    }

    private boolean helper(GraphEdge[][] graph,int curr,int needle,boolean[] seen, StackX<Integer> path){
        if(seen[curr])
            return false;

        if(curr == needle){
            path.push(curr);
            return true;
        }

        path.push(curr);
        seen[curr] = true;

        GraphEdge[] adjs = graph[curr];
        for (int i = 0; i < adjs.length; i++) {
            if(helper(graph,adjs[i].to(),needle,seen,path))
                return true;
        }
        path.pop();
        return false;
    }
}
