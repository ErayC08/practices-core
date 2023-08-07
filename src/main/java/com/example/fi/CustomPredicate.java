package com.example.fi;

@FunctionalInterface
public interface CustomPredicate<T> {

    boolean test(T element);
}
