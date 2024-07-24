package utils;

public class Point {
    public int x;
    public int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o){
        if(o == null)
            return false;
        else if(this == o)
            return true;
        else if(!(o instanceof Point))
            return false;

        Point other = (Point)o;
        if(this.x == other.x && this.y == other.y)
            return true;

        return false;
    }

    public int hashCode(){
        return (int)(this.x + this.y + 1000);
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("(");
        sb.append(x);
        sb.append(",");
        sb.append(y);
        sb.append(")");
        return sb.toString();
    }
}
