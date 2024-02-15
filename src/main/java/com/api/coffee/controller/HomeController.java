package com.api.coffee.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
@RequiredArgsConstructor
public class HomeController {
    

    @GetMapping
    public String home() {
        return "Hello World";
    }
}
