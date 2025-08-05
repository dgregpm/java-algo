package utils;

public class GraphNode implements Comparable<GraphNode>{
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
        double res = this.distance - other.distance();
        if(res == 0)
            return 0;
        else if(res < 0)
            return -1;
        else
            return 1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ Node: ").append(this.node).append(", Distance: ").append(this.distance).append(" ]");
        return sb.toString();
    }
}
