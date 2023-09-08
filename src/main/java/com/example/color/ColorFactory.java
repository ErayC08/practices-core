package com.example.color;

public class ColorFactory {

    public Color getColor(String name) {
        switch (name.toUpperCase()) {
            case "BLUE":
                return new Blue();
            case "GREEN":
                return new Green();
            case "RED":
                return new Red();
            default:
                return null;
        }
    }
}
