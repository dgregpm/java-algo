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
                if(!seen[i] && adjs[i] > 0){
                    seen[i] = true;
                    path.enqueue(i);
                    prev[i] = curr;
                }
            }
        }

        int curr = needle;
        ArrayListX<Integer> out = new ArrayListX<>();
        while(prev[curr] != -1){
            out.prepend(curr);
            curr = prev[curr];
        }
        if(out.size() > 0)
            out.prepend(source);
        return out;
    }

}
