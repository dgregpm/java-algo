import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class BFSGraphMatrix {

    public ArrayList<Integer> bfs(int[][] graph, int source, int needle) {
        boolean[] seen = new boolean[graph.length];
        int[] prev = new int[graph.length];
        Arrays.fill(prev, -1);
        Queue<Integer> path = new LinkedList<>();

        seen[source] = true;
        path.add(source);
        while(path.size() > 0){

            int curr = path.remove();
            if(curr == needle)
                break;
        
            int[] adjs = graph[curr];
            for (int i = 0; i < adjs.length; i++) {
                if(!seen[i] && adjs[i] > 0){
                    path.add(i);
                    prev[i] = curr;
                    seen[i] = true;
                }
            }
        }
        ArrayList<Integer> out = new ArrayList<>();
        int curr = needle;
        while(prev[curr] != -1){
            out.add(0,curr);
            curr = prev[curr];
        }
        if(out.size() > 0)
            out.add(0,source);
        return out;
    }

}
