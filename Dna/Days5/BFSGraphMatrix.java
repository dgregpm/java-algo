import utils.QueueX;
import java.util.Arrays;
import utils.ArrayListX;

public class BFSGraphMatrix {

    public ArrayListX<Integer> bfs(int[][] graph, int source, int needle) {
        int[] prev = new int[graph.length];
        Arrays.fill(prev,-1);
        boolean[] seen = new boolean[graph.length];
        seen[source] = true;

        QueueX<Integer> q = new QueueX<>();
        q.enqueue(source);

        while(q.size() > 0){
            int curr = q.deque();
            if(curr == needle)
                break;

            int[] adjs = graph[curr];
            for (int i = 0; i < adjs.length; i++) {
                if(adjs[i] == 0 || seen[i])
                    continue;


                seen[i] = true;
                prev[i] = curr;
                q.enqueue(i);
            }
        }

        ArrayListX<Integer> out = new ArrayListX<>();
        int curr = needle;
        while(prev[curr] != -1){
            out.prepend(curr);
            curr = prev[curr];
        }

        if(out.size() > 0)
            out.prepend(source);

        return out;
    }

}
