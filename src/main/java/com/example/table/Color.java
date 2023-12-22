package com.example.table;

public enum Color {
    RED, YELLOW, NONE;

    @Override
    public String toString() {
        return this.name().substring(0, 1);
    }

    public boolean isPresent() {
        return this == RED || this == YELLOW;
    }
}
