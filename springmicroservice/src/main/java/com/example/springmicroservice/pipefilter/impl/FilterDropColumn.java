package com.example.springmicroservice.pipefilter.impl;

import com.example.springmicroservice.pipefilter.Filter;

public class FilterDropColumn implements Filter<String> {

    @Override
    public String execute(String input) {
        String city = input.split(",")[0];
        String working_hours = input.split(",")[1];
        String location = input.split(",")[2];
        String phone_number = input.split(",")[3];
        String x_coordinate = (input.split(",")[4]).replace("\"", "");
        String y_coordinate = (input.split(",")[5]).replace("\"", "");
        return city + "|" + location + "|" + working_hours + "|" + phone_number + "|" + x_coordinate + "|" + y_coordinate;
    }
}
