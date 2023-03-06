package com.returners.apiLab.controller;

//package definition omitted for brevity
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @GetMapping(value = "/")
    public String home(){
        return "Welcome to the Drinks API!";
    }
}