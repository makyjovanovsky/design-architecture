package com.example.springmicroservice2.controller;

import com.example.springmicroservice2.entity.GasStationEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MapController {

    @PostMapping("/show-map")
    public String showMapWithGasStations(@RequestParam(name = "city") String city, Model model) {
        final String uri = "http://localhost:8081/get-gas-stations?city=" + city;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GasStationEntity[]> response =
                restTemplate.getForEntity(
                        uri,
                        GasStationEntity[].class);
        GasStationEntity[] gas_stations = response.getBody();
        model.addAttribute("stations", gas_stations);
        assert gas_stations != null;
        model.addAttribute("city", gas_stations[0]);
        return "map-locations";
    }
}
