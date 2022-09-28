package com.practica.demo.repositories;

import com.practica.demo.models.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital,Long> {
}
