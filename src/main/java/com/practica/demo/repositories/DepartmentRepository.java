package com.practica.demo.repositories;

import com.practica.demo.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Long> {
}
