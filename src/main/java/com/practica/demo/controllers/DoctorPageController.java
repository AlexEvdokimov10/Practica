package com.practica.demo.controllers;

import com.practica.demo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.io.IOException;

@Controller
public class DoctorPageController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public String showDoctorPage(Model model) {

        try {
            model.addAttribute("doctors",doctorService.findByDepartmentId());
        }
        catch (IOException e){
            return e.getMessage();
        }
        return "doctors";
    }

}

