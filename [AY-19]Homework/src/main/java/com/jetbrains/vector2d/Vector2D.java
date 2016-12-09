package com.jetbrains.vector2d;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D vectorSum(Vector2D vector2D) {
        return new Vector2D(this.x + vector2D.getX(), this.y + vector2D.getY());
    }

    public Vector2D vectorMult(double k) {
        return new Vector2D(this.x * k, this.y * k);
    }

    public double scalarMult(Vector2D vector2D){
        return this.x*vector2D.getX() + this.y*vector2D.getY();
    }

    public boolean equals(Vector2D vector2D){
        return this.x==vector2D.getX() && this.y==vector2D.getY();
    }
}
