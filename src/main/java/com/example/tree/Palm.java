package com.example.tree;

public class Palm extends Tree {
    public Palm(Position position, double mass, double height) {
        super(position, mass, height);
    }

    @Override
    public String getName() {
        return "Palm";
    }

    @Override
    public Tree clone(int x, int y) {
        return new Palm(new Position(x, y), super.mass, super.height);
    }
}
