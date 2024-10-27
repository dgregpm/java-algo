package utils;

public class GraphNode implements Comparable<GraphNode> {
    private int node;
    private double distance;

    public GraphNode(int n, double d){
        this.node = n;
        this.distance = d;
    }

    public int node(){
        return this.node;
    }

    public double distance(){
        return this.distance;
    }

    @Override
    public int compareTo(GraphNode other){
        int res = 0;
        if(this.distance < other.distance())
            res = -1;
        else if(this.distance == other.distance())
            res = 0;
        else
            res = 1;
        return res;
    }

    @Override
    public String toString(){
        return "[ " + node + ", " + distance + " ]";
    }
}
