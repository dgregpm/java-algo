public class Point {
    public int x;
    public int y;

    Point(int a, int b){
        this.x = a;
        this.y = b;
    }
    
    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public boolean equals(Object o){
        if(o == this)
            return true;
        if(!(o instanceof Point))
            return false;
        Point other = (Point)o;
        if(this.x == other.x && this.y == other.y)
            return true;
        return false;
    }

    public int hashCode(){
        return (int)(this.x + this.y + 1000);
    }
}
