package com.example.tree;

public abstract class Tree {
    protected Position position;
    protected double mass;
    protected double height;

    public Tree(Position position, double mass, double height) {
        this.position = position;
        this.mass = mass;
        this.height = height;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public abstract String getName();

    public abstract Tree clone(int x, int y);
}
