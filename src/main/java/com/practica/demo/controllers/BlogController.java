package com.practica.demo.controllers;

import com.practica.demo.models.Doctor;
import com.practica.demo.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public String showDoctorPage(Model model){
        Iterable<Doctor>doctors=doctorRepository.findAll();
        model.addAttribute("doctors",doctors);
        return "doctors";
    }

    @GetMapping("doctors/{id}")
    public String doctorView(@PathVariable (value = "id") long id, Model model){
        Optional<Doctor> doctor=doctorRepository.findById(id);
        ArrayList<Doctor>res=new ArrayList<>();
        doctor.ifPresent(res::add);
        model.addAttribute("doctor",res);
        return "doctor-details";
    }

}
