package com.example.parallelogram;

public class Rectangle {
    private final Parallelogram parallelogram;

    public Rectangle(double base, double height) {
        parallelogram = new Parallelogram(base, height, 90.0);
    }

    public double getBase() {
        return parallelogram.getBase();
    }

    public double getHeight() {
        return parallelogram.getSide();
    }

    public double getPerimeter() {
        return parallelogram.getPerimeter();
    }

    public double getArea() {
        return getBase() * getHeight();
    }

    public void setBase(double base) {
        parallelogram.setBase(base);
    }

    public void setHeight(double height) {
        parallelogram.setSide(height);
    }
}
