package com.example.parallelogram;

public class Square {
    private final Rectangle rectangle;

    public Square(double length) {
        rectangle = new Rectangle(length, length);
    }

    public double getLength() {
        return rectangle.getBase();
    }

    public double getPerimeter() {
        return 4 * getLength();
    }

    public double getArea() {
        return getLength() * getLength();
    }

    public void setLength(double length) {
        rectangle.setBase(length);
        rectangle.setHeight(length);
    }
}
