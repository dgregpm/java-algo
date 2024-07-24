package utils;

public enum Direction {
    UP(0,-1),
    RIGHT(1,0),
    DOWN(0,1),
    LEFT(-1,0);

    private int deltaX;
    private int deltaY;

    Direction(int x, int y){
        this.deltaX = x;
        this.deltaY = y;
    }

    public int getDeltaX(){
        return this.deltaX;
    }

    public int getDeltaY(){
        return this.deltaY;
    }
}


