package com.practica.demo.repositories;

import com.practica.demo.models.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor,Long> { }
