package com.example.springapp.controller;

import com.example.springapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam(name = "name") String name, @RequestParam(name = "surname") String surname,
                               @RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        if (userService.registerNewUser(name, surname, email, password)) {
            return "login";
        }
        return "register";
    }
}
