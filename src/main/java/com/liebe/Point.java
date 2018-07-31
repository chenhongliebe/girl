package com.liebe;

public class Point {


        private int x;
        private int y;
        boolean checked;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        checked=false;
    }

    public int getLength(Point point){
            return Math.abs(this.x - point.x) + Math.abs(this.y - point.y);
        }


}
