package com.example;

@FunctionalInterface
public interface CustomConsumer<T> {

    void consume(T element);
}
