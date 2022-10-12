package com.practica.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practica.demo.models.Doctor;
import com.practica.demo.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void save(List<Doctor> doctorList) {
        doctorRepository.saveAll(doctorList);
    }

    public Iterable<Doctor> findByDepartmentId() throws IOException {
        try {
            return doctorRepository.findByDepartmentId(Long.valueOf((Integer) new ObjectMapper()
                    .readValue(new File("src\\main\\resources\\json\\input.json"), Map.class)
                    .get("department_id")));
        }
        catch (IOException exception){
            System.out.println("Unable to save users: " + exception.getMessage());
        }
        return doctorRepository.findAll();

    }
    public List<Doctor> readFileDoctorJson() throws IOException {
        return Arrays.asList(new ObjectMapper()
                .readValue(Paths.get("src\\main\\resources\\json\\doctors.json")
                        .toFile(), Doctor[].class));
    }





}
