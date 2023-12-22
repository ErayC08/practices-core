package com.example;

import com.example.calculator.operation.AlternativeCalculatorOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        AlternativeCalculator calculator = new AlternativeCalculator(2, 3, 5, 10);

        calculator.performSequentially(List.of(
                AlternativeCalculatorOperation.addition(),
                AlternativeCalculatorOperation.multiplication(),
                AlternativeCalculatorOperation.multiplication(),
                AlternativeCalculatorOperation.subtraction()
        ));
        System.out.println("Result: " + calculator.getResult());
    }
}
