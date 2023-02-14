package com.example.springmicroservice2.controller;

import com.example.springmicroservice2.entity.GasStationEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class PageController {


    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @GetMapping("/userDashboard")
    public String getUserDashboardPage(Model model) {
        final String uri = "http://localhost:8081/get-all-gas-stations";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GasStationEntity[]> response =
                restTemplate.getForEntity(
                        uri,
                        GasStationEntity[].class);
        GasStationEntity[] gas_stations = response.getBody();
        assert gas_stations != null;
        System.out.println(gas_stations.length);
        Set<String> set = new HashSet<>();
        for (GasStationEntity g : gas_stations) {
            set.add(g.getCity());
        }
        model.addAttribute("stations", set.stream().sorted().collect(Collectors.toList()));
        return "user-dashboard";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}