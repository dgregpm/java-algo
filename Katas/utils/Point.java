package utils;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(this.x).append(",").append(this.y).append(")");
        return sb.toString();
    }

    @Override
    public int hashCode(){
        return (int)(2 * this.x + this.y + 1000);
    }

    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(o == this)
            return true;
        if(!(o instanceof Point))
            return false;
        Point other = (Point)o;
        if(this.x == other.x && this.y == other.y)
            return true;
        return false;
    }   
}
