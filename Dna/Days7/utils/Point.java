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
        return sb.append("(").append(x).append(",").append(y).append(")").toString();
    }

    @Override
    public int hashCode(){
        return (int)(this.x + this.y + 1000);
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
        if(other.x == this.x && other.y == this.y)
            return true;
        return false;
    }

}
