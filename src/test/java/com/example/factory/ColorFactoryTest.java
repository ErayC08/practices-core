package com.example.factory;

import com.example.color.Color;
import com.example.factory.exception.ColorNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColorFactoryTest {
    /*
     * The following list shows the expected behaviors for the method 'getInstance'.
     *
     * 1. When a corresponding instance of 'Color' exists with the provided color name,
     * the method should return that instance.
     * 2. When a corresponding instance of 'Color' does not exist with the provided color name,
     * the method should throw ColorNotFoundException.
     * 3. When the method is invoked multiple times, it should return the same instance rather than
     * creating new instances.
     */

    @Test
    void givenColorName_whenGetInstance_thenReturnInstance() {
        final Color color = ColorFactory.getInstance("Red");

        Assertions.assertEquals("Red", color.getName());
    }

    @Test
    void givenWrongColorName_whenGetInstance_thenThrowColorNotFoundException() {
        Assertions.assertThrows(ColorNotFoundException.class, () -> ColorFactory.getInstance("wrongColorName"));
    }

    @Test
    void givenColorName_whenGetInstanceMultipleTimes_thenReturnSameInstance() {
        final Color color1 = ColorFactory.getInstance("Red");
        final Color color2 = ColorFactory.getInstance("Red");

        Assertions.assertEquals(color1, color2);
    }
}
