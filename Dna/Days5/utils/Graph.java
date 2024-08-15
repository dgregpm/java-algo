package utils;

public class Graph {

    //list1: WeightedAdjacencyList = [];
    //      (1) --- (4) ---- (5)
    //    /  |       |       /|
    // (0)   | ------|------- |
    //    \  |/      |        |
    //      (2) --- (3) ---- (6)

    public static GraphEdge[][] list1(){
        GraphEdge[][] g = new GraphEdge[][] {
            {new GraphEdge(1,3),new GraphEdge(2,1)},
            {new GraphEdge(0,3),new GraphEdge(2,4),new GraphEdge(4,1)},
            {new GraphEdge(1,4),new GraphEdge(3,7),new GraphEdge(0,1)},
            {new GraphEdge(2,7),new GraphEdge(4,5),new GraphEdge(6,1)},
            {new GraphEdge(1,1),new GraphEdge(3,5),new GraphEdge(5,2)},
            {new GraphEdge(6,1),new GraphEdge(4,2),new GraphEdge(2,18)},
            {new GraphEdge(3,1),new GraphEdge(5,1)}
        };
        return g;
    }

    //export const list2: WeightedAdjacencyList = [];
    //     >(1)<--->(4) ---->(5)
    //    /          |       /|
    // (0)     ------|------- |
    //    \   v      v        v
    //     >(2) --> (3) <----(6)
    public static GraphEdge[][] list2(){
        GraphEdge[][] g = new GraphEdge[][] {
            {new GraphEdge(1,3),new GraphEdge(2,1)},
            {new GraphEdge(4,1)},
            {new GraphEdge(3,7)},
            {},
            {new GraphEdge(1,1),new GraphEdge(3,5),new GraphEdge(5,2)},
            {new GraphEdge(2,18),new GraphEdge(6,1)},
            {new GraphEdge(3,1)}
        };
        return g;
    }

    //     >(1)<--->(4) ---->(5)
    //    /          |       /|
    // (0)     ------|------- |
    //    \   v      v        v
    //     >(2) --> (3) <----(6)
    public static int[][] matrix2(){
        int[][] m = new int[][]{
            {0, 3, 1,  0, 0, 0, 0}, 
            {0, 0, 0,  0, 1, 0, 0},
            {0, 0, 7,  0, 0, 0, 0},
            {0, 0, 0,  0, 0, 0, 0},
            {0, 1, 0,  5, 0, 2, 0},
            {0, 0, 18, 0, 0, 0, 1},
            {0, 0, 0,  1, 0, 0, 1},
        };
        return m;        
    }
}
