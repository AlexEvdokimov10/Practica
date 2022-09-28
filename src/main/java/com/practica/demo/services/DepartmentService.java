package com.practica.demo.services;

import com.practica.demo.models.Department;
import com.practica.demo.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Iterable<Department> list() {
        return departmentRepository.findAll();
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public void save(List<Department> departmentList) {
        departmentRepository.saveAll(departmentList);
    }

    public Optional<Department> findById(Long id) {

        return departmentRepository.findById(id);
    }
}
