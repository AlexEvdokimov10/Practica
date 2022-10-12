package com.practica.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practica.demo.models.Department;
import com.practica.demo.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public List<Department> readFileHospitalJson() throws IOException {
        return Arrays.asList(new ObjectMapper()
                .readValue(Paths.get("src\\main\\resources\\json\\hospital.json")
                        .toFile(), Department[].class));
    }
    public void save(List<Department> departmentList) {
        departmentRepository.saveAll(departmentList);
    }

}
