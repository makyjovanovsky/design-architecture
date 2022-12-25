package com.example.springapp.controller;

import com.example.springapp.entity.GasStationEntity;
import com.example.springapp.service.GasStationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
public class PageController {

    private GasStationService gasStationService;

    public PageController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @GetMapping("/userDashboard")
    public String getUserDashboardPage(Model model) {
        model.addAttribute("stations", gasStationService.getAllStations().stream().sorted().collect(Collectors.toList()));
        return "user-dashboard";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}
