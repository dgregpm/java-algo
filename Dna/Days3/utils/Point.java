package utils;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(this.x);
        sb.append(",");
        sb.append(this.y);
        sb.append(")");
        return sb.toString();
    }
    
    public int hashCode(){
        return (int)(this.x + this.y + 1000);
    }

    public boolean equals(Object o){
        if(o == this)
            return true;
        else if(!(o instanceof Point))
            return false;

        Point other = (Point)o;
        if(this.x == other.x && this.y == other.y)
            return true;

        return false;
    }
}
