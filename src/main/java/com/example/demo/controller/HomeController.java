package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @GetMapping("")
    public String home() {
        return "home";                  // Questo cerca /WEB-INF/jsp/home.jsp
    }



}
