package com.example.springapp.pipefilter;

public interface Filter<T> {

    T execute(T input);
}
