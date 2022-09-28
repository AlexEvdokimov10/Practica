package com.practica.demo.services;

import com.practica.demo.models.Doctor;
import com.practica.demo.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public Iterable<Doctor> list() {
        return doctorRepository.findAll();
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void save(List<Doctor> doctorList) {
        doctorRepository.saveAll(doctorList);
    }


}
