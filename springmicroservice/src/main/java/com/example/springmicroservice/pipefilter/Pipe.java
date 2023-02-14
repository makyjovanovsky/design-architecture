package com.example.springmicroservice.pipefilter;

import java.util.ArrayList;
import java.util.List;


public class Pipe<T> {
    private List<Filter<T>> filterList = new ArrayList<>();

    public void addFilter(Filter<T> filter) {
        filterList.add(filter);
    }

    public T runFilter(T input) {
        for (Filter<T> filter : filterList) {
            input = filter.execute(input);
        }
        return input;
    }
}
