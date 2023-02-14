package com.example.springmicroservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
public class Springmicroservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springmicroservice2Application.class, args);
    }

}
