package utils;

public class GraphEdge{
    private int from;
    private int to;
    private int weight;

    public GraphEdge(int t, int w){
        this.to = t;
        this.weight = w;
    }

    public int to(){
        return this.to;
    }

    public int weight(){
        return this.weight;
    }
}
