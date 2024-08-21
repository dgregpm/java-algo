package utils;

public class GraphEdge {
    private int from;
    private int to;
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

    public int from(){
        if(!this.complete)
            return -1;
        return this.from;
    }

    public int to(){
        return this.to;
    }

    public int weight(){
        return this.weight;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.complete)
            return sb.append("[ From: ").append(this.from).append(" To: ").append(this.to).append(" Weight: ").append(this.weight).append(" ]").toString();
        else
            return sb.append(" To: ").append(this.to).append(" Weight: ").append(this.weight).append(" ]").toString();
    }
}
