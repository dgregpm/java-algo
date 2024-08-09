import utils.ArrayListX;
import utils.QueueX;
import java.util.Arrays;

public class BFSGraphMatrix {

    public ArrayListX<Integer> bfs(int[][] graph, int source, int needle) {

        boolean[] seen = new boolean[graph.length];
        int[] prev = new int[graph.length];
        Arrays.fill(prev,-1);

        seen[source] = true;
        QueueX<Integer> q = new QueueX<>();
        q.enqueue(source);
        while(q.size() > 0){
            int curr = q.deque();
            if(curr == needle){
                break;
            }

            int[] adjs = graph[curr];
            for (int i = 0; i < graph.length; i++) {
                if(adjs[i] == 0)
                    continue;
                if(seen[i])
                    continue;
                seen[i] = true;
                prev[i] = curr;
            }
        }

        int curr = needle;
        ArrayListX<Integer> out = new ArrayListX<>();
        while(prev[curr] != -1){
            out.append(curr);
            curr = prev[curr];
        }

        if(out.size() > 0)
            out.prepend(source);
        
        return out;

    }
}
