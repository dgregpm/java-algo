import java.util.ArrayList;
import java.util.Stack;
import utils.*;

public class MazeSolver {

    public void solve(String[] maze, char wall, Point start, Point end){
        Stack<Point> path = new Stack<>();
        boolean[][] visit = new boolean[maze.length][maze[0].length()];
        helper(maze,wall,start,end,visit,path);
        System.out.println(path);
    }

    private boolean helper(String[] maze, char wall, Point curr, Point end, boolean[][] visit, Stack<Point> path){
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

        path.push(curr);
        visit[curr.y][curr.x] = true;

        for(Direction dir : Direction.values()){
            int x = dir.getDeltaX();
            int y = dir.getDeltaY();
            Point p = new Point(curr.x + x, curr.y + y);
            //System.out.println(path);
            if(helper(maze,wall,p,end,visit,path) == true)
                return true;
        }

        path.pop();
        return false;
    }

}
