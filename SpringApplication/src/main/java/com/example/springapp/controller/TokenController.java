package com.example.springapp.controller;

import com.example.springapp.service.ConfirmationTokenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TokenController {

    private final ConfirmationTokenService confirmationTokenService;

    public TokenController(ConfirmationTokenService confirmationTokenService) {
        this.confirmationTokenService = confirmationTokenService;
    }

    @GetMapping("/confirm")
    public String confirmToken(@RequestParam("token") String token) throws Exception {
        confirmationTokenService.confirmToken(token);
        return "redirect:/login";
    }
}
