import java.util.Stack;

public class MazeSolver {
    //private static final int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void solve(String[] maze, char wall, Point start, Point end){
        
        Stack<Point> path = new Stack<Point>();
        boolean[][] visit = new boolean[maze.length][maze[0].length()];
        MazeSolver m = new MazeSolver();
        m.helper(maze,wall,start,end,visit,path);
        //for(Point p : path){
          //  System.out.println("[" + p + "]");
        //}
        System.out.println(path);
    }

    private boolean helper(String[] maze, char wall, Point curr, Point end, boolean[][] visit, Stack<Point> path){

        if(curr.x >= maze[0].length() || curr.y >= maze.length || curr.x < 0 || curr.y < 0){
            return false;
        }
        if(maze[curr.y].charAt(curr.x) == wall){
            return false;
        }
        if(visit[curr.y][curr.x] == true){
            return false;
        }
        if(curr.equals(end)){
            path.push(curr);
            return true;
        }
        
        visit[curr.y][curr.x] = true;
        path.push(curr);

        for(Direction dir : Direction.values()){
            Point p = new Point(curr.x + dir.getDeltaX(), curr.y + dir.getDeltaY());
            if(helper(maze,wall,p,end,visit,path)){
                return true;
            }
        }

        path.pop();

        return false;   
    }
}
