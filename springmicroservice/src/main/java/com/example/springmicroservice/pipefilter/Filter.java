package com.example.springmicroservice.pipefilter;

public interface Filter<T> {

    T execute(T input);
}
