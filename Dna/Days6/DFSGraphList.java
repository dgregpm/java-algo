import utils.ArrayListX;
import utils.GraphEdge;
import utils.StackX;

public class DFSGraphList {

    public StackX<Integer> dfs(GraphEdge[][] graph, int source, int needle) {
         StackX<Integer> path = new StackX<>();
         boolean[] seen = new boolean[graph.length];
         helper(graph,source,needle,seen,path);
         return path;
    }

    private boolean helper(GraphEdge[][] graph,int curr,int needle,boolean[] seen,StackX<Integer> path){
        if(curr == needle){
            path.push(curr);
            return true;
        }
        if(seen[curr])
            return false;

        seen[curr] = true;
        path.push(curr);
        GraphEdge[] adjs = graph[curr];
        for (int i = 0; i < adjs.length; i++) {
            if(helper(graph,adjs[i].to(),needle,seen,path))
                return true;
        }

        path.pop();
        return false;
    }

}
