package com.example.shape;

public abstract class Shape {
    protected int corners;

    protected void setCorners(int corners) {
        this.corners = corners;
    }

    public int getCorners() {
        return corners;
    }

    public int getTotalDegree() {
        return (corners - 2) * 180;
    }
}
