import utils.Direction;
import utils.Point;
import java.util.Stack;

public class MazeSolver {

    public void solve(String[] maze, char wall, Point start, Point end){
        boolean[][] visit = new boolean[maze.length][maze[0].length()];
        Stack<Point> path = new Stack<>();

        walk(maze,wall,start,end,visit,path);
        System.out.println(path);
    }

    private boolean walk(String[] maze, char wall, Point curr, Point end, boolean[][] visit, Stack<Point> path) {
        if(curr.x < 0 || curr.y < 0 || curr.x >= maze[0].length() || curr.y >= maze.length)
            return false;
        if(maze[curr.y].charAt(curr.x) == wall)
            return false;
        if(visit[curr.y][curr.x] == true)
            return false;
        if(curr.equals(end)){
            path.push(curr);
            return true;
        }

        visit[curr.y][curr.x] = true;
        path.push(curr);
        for (Direction dir : Direction.values()) {
            Point p = new Point(curr.x + dir.getDeltaX(), curr.y + dir.getDeltaY());
            if(walk(maze,wall,p,end,visit,path))
                return true;
        }
        path.pop();
        return false;
    }
}
