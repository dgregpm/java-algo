package utils;

public class GraphEdge {
    private int to;
    private int from;
    private int weight;
    private boolean complete;

    public GraphEdge(int t, int w){
        this.to = t;
        this.weight = w;
        this.complete = false;
    }

    public GraphEdge(int f, int t, int w){
        this.from = f;
        this.to = t;
        this.weight = w;
        this.complete = true;
    }

    public int to(){
        return this.to;
    }

    public int from(){
        if(!this.complete)
            return -1;
        return this.from;
    }

    public int weight(){
        return this.weight;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.complete)
            sb.append("[ From: ").append(this.from).append(" To: ").append(this.to).append(" Weight: ").append(this.weight).append(" ]");
        else
            sb.append("[ To: ").append(this.to).append(" Weight: ").append(this.weight).append(" ]");
        return sb.toString();
    }
}
