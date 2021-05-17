package com.company.JavaPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class StaticController {

    @GetMapping
    private String getHome() {
        return "home";
    }
}
