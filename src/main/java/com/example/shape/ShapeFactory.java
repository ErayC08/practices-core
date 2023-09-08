package com.example.shape;

public class ShapeFactory {

    public Shape getShape(String name) {
        switch (name.toUpperCase()) {
            case "TRIANGLE":
                return new Triangle();
            case "RECTANGLE":
                return new Rectangle();
            case "PENTAGON":
                return new Pentagon();
            default:
                return null;
        }
    }
}
