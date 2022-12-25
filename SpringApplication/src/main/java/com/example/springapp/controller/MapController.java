package com.example.springapp.controller;

import com.example.springapp.service.GasStationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MapController {

    private final GasStationService gasStationService;

    public MapController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @PostMapping("/show-map")
    public String showMapWithGasStations(@RequestParam(name = "city") String city, Model model) {
        model.addAttribute("stations", gasStationService.findAllGasStationsInCity(city));
        model.addAttribute("city", gasStationService.findAllGasStationsInCity(city).get(0));
        return "map-locations";
    }
}
