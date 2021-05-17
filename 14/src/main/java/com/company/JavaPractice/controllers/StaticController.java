package com.company.JavaPractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class StaticController {

    @GetMapping
    private String getHome() {
        return "home";
    }
}
