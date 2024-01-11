package com.example.calculator;

public class Calculator {
    private double result = 0.0;

    public double get() {
        return this.result;
    }

    public void add(double n) {
        this.result += n;
    }

    public void subtract(double n) {
        this.result -= n;
    }

    public void multiply(double n) {
        this.result *= n;
    }

    public void divide(double n) {
        if (n == 0) {
            throw new RuntimeException("The divisor must be different than 0.");
        }
        this.result /= n;
    }

    public void reset() {
        this.result = 0;
    }
}
