package com.example.tree;

public class Pine extends Tree {
    public Pine(Position position, double mass, double height) {
        super(position, mass, height);
    }

    @Override
    public String getName() {
        return "Pine";
    }

    @Override
    public Tree clone(int x, int y) {
        return new Pine(new Position(x, y), super.mass, super.height);
    }
}
