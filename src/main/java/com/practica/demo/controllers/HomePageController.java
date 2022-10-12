package com.practica.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String showHomePage(@RequestParam(name="name", required=false) String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}