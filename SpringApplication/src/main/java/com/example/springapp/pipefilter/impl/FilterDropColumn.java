package com.example.springapp.pipefilter.impl;

import com.example.springapp.pipefilter.Filter;

public class FilterDropColumn implements Filter<String> {

    @Override
    public String execute(String input) {
        String name = input.split(",")[1];
        String working_hours = input.split(",")[2];
        String location = input.split(",")[3];
        String phone_number = input.split(",")[4];
        String city = input.split(",")[0];
        return name + "|" + location + "|" + working_hours + "|" + phone_number + "|" + city;
    }
}
