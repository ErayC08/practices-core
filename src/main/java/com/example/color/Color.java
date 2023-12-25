package com.example.color;

public enum Color {
    RED, YELLOW, NONE;

    @Override
    public String toString() {
        return this.name().substring(0, 1);
    }

    public boolean isNone() {
        return this == NONE;
    }
}
