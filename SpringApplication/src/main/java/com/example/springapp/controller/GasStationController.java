package com.example.springapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GasStationController {

    @PostMapping("/show-map")
    public String showMapWithGasStations(@RequestParam(name = "city") String city) {
        return "";
    }
}
