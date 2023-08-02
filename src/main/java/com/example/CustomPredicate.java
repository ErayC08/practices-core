package com.example;

@FunctionalInterface
public interface CustomPredicate<T> {

    boolean test(T element);
}
