package com.practica.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practica.demo.models.Doctor;
import com.practica.demo.repositories.DoctorRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public String showDoctorPage(Model model) throws IOException, ParseException {

        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src\\main\\resources\\json\\input.json"));
            Iterable<Doctor> doctors= doctorRepository.findByDepartmentId((Long) jsonObject.get("department_id"));
            model.addAttribute("doctors",doctors);
        }
        catch (IOException e){
           return e.getMessage();
        }
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
