import utils.Point;
import utils.StackX;
import utils.Direction;

public class MazeSolver {

    public void solve(String[] maze, char wall, Point start, Point end){
        boolean[][] visit = new boolean[maze.length][maze[0].length()];
        StackX<Point> path = new StackX<>();
        helper(maze, wall, start, end, visit, path);
        System.out.println(path);
    }

    private boolean helper(String[] maze, char wall, Point curr, Point end, boolean[][] visit, StackX<Point> path){
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
            Point p = new Point(curr.x + dir.getDeltaX(), curr.y + dir.getDeltaY());
            if(helper(maze, wall, p, end, visit, path))
                return true;
        }

        path.pop();
        return false;
    }

}
