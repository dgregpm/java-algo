package utils;

public class GraphEdge {
    private int from;
    private int to;
    private int weight;

    public GraphEdge(int t, int w){
        this.to = t;
        this.weight = w;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ To: ").append(this.to).append(" Weight: ").append(this.weight).append(" ]");
        return sb.toString();
    }

    public int to(){
        return this.to;
    }

    public int weight(){
        return this.weight;
    }
}
