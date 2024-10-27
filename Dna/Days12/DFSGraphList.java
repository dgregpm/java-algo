import utils.GraphEdge;
import java.util.Stack;

public class DFSGraphList {

    public Stack<Integer> dfs(GraphEdge[][] graph, int source, int needle) {
        boolean[] seen = new boolean[graph.length];
        Stack<Integer> path = new Stack<>();
        walk(graph,source,needle,seen,path);
        //System.out.println(path);
        return path;
    }

    private boolean walk(GraphEdge[][] graph, int curr, int needle, boolean[] seen, Stack<Integer> path){
        
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
            if(walk(graph,adjs[i].to(),needle,seen,path))
                return true;
        }

        path.pop();
        return false;
    }

}
