package com.example.color;

public interface Color {
    String getHexValue();

    default String getName() {
        return getClass().getSimpleName();
    }
}
