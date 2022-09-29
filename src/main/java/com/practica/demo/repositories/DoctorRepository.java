package com.practica.demo.repositories;

import com.practica.demo.models.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor,Long> {
    List<Doctor> findByDepartmentId(Long id);
}
