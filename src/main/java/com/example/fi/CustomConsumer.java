package com.example.fi;

@FunctionalInterface
public interface CustomConsumer<T> {

    void consume(T element);
}
