package utils;

public class GraphNode implements Comparable<GraphNode>{
    private int node;
    private double distance;

    public GraphNode(int n, double d){
        this.node = n;
        this.distance = d;
    }

    public int getNode(){
        return this.node;
    }

    public double getDistance(){
        return this.distance;
    }

    public void setDistance(double d){
        this.distance = d;
    }
    
    @Override
    public int compareTo(GraphNode other){
        double dist = this.distance - other.distance;
        if(dist < 0)
            return -1;
        else if(dist == 0)
            return 0;
        else
            return 1;
    }
}
