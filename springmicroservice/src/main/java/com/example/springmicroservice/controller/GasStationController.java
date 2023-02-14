package com.example.springmicroservice.controller;

import com.example.springmicroservice.entity.GasStationEntity;
import com.example.springmicroservice.service.GasStationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GasStationController {

    private final GasStationService gasStationService;

    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @GetMapping(path = "/get-gas-stations", produces = "application/json")
    public List<GasStationEntity> getGasStations(@RequestParam(name = "city") String city) {
        return gasStationService.findAllGasStationsInCity(city);
    }

    @GetMapping(path = "/get-all-gas-stations", produces = "application/json")
    public List<GasStationEntity> getAllGasStations() {
        return gasStationService.getAllStations();
    }

}
