package com.example.codinghub.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.codinghub.service"
        , "com.example.codinghub.web"})
public class CodinghubWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodinghubWebApplication.class, args);
    }

}
