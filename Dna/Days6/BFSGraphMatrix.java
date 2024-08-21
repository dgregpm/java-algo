import utils.ArrayListX;
import java.util.Arrays;
import utils.QueueX;

public class BFSGraphMatrix {

    public ArrayListX<Integer> bfs(int[][] graph, int source, int needle) {
        boolean[] seen = new boolean[graph.length];
        int[] prev = new int[graph.length];
        Arrays.fill(prev,-1);
        seen[source] = true;

        QueueX<Integer> path = new QueueX<>();
        path.enqueue(source);

        while(path.size() > 0){
            int curr = path.deque();
            if(curr == needle)
                break;
            
            int[] adjs = graph[curr];
            for (int i = 0; i < adjs.length; i++) {
                if(adjs[i] == 0 || seen[i])
                    continue;
                
                path.enqueue(i);
                prev[i] = curr;
                seen[i] = true;

            }
        }

        ArrayListX<Integer> res = new ArrayListX<>();
        int curr = needle;
        while(prev[curr] != -1){
            res.prepend(curr);
            curr = prev[curr];
        }
        if(res.size() > 0)
            res.prepend(source);
        return res;
    }
}
