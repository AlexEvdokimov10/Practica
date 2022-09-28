package com.practica.demo.repositories;

import com.practica.demo.models.Doctor;
import com.practica.demo.models.Hospital;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor,Long> { }
