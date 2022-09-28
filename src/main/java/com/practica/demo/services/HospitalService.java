package com.practica.demo.services;

import com.practica.demo.models.Hospital;
import com.practica.demo.repositories.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public Iterable<Hospital> list() {
        return hospitalRepository.findAll();
    }

    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public void save(List<Hospital> hospitalList) {
        hospitalRepository.saveAll(hospitalList);
    }

    public Optional<Hospital> findById(Long id) {

        return hospitalRepository.findById(id);
    }
}
