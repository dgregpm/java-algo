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
        sb.append("[").append(x).append(",").append(y).append("]");
        return sb.toString();
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

    @Override
    public int hashCode(){
        return (int)(this.x + this.y + 1000);
    }
}
