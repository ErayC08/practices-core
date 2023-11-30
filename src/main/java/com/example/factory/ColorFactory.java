package com.example.factory;

import com.example.color.Blue;
import com.example.color.Color;
import com.example.color.Green;
import com.example.color.Red;
import com.example.factory.exception.ColorNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ColorFactory {

    private static final Map<String, Color> colorsCache = new HashMap<>();

    public static Color getInstance(String colorName) {
        return colorsCache.computeIfAbsent(colorName, ColorFactory::produceInstance);
    }

    private static Color produceInstance(String colorName) {
        return switch (colorName.toUpperCase()) {
            case "RED" -> new Red();
            case "GREEN" -> new Green();
            case "BLUE" -> new Blue();
            default -> throw new ColorNotFoundException("A color doesn't exist with the given name.");
        };
    }
}
