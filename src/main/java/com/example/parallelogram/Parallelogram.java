package com.example.parallelogram;

public class Parallelogram {
    private double base;
    private double side;
    private double angle;

    public Parallelogram(double base, double side, double angle) {
        this.base = base;
        this.side = side;
        this.angle = angle;
    }

    public double getBase() {
        return base;
    }

    public double getSide() {
        return side;
    }

    public double getAngle() {
        return angle;
    }

    public double getHeight() {
        return Math.sin(angle) * side;
    }

    public double getPerimeter() {
        return 2 * (base + side);
    }

    public double getArea() {
        return base * getHeight();
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
