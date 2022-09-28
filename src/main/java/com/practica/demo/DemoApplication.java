package com.practica.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practica.demo.models.Doctor;
import com.practica.demo.models.Department;
import com.practica.demo.services.DoctorService;
import com.practica.demo.services.DepartmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(DepartmentService departmentService, DoctorService doctorService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			try {
				List<Department> departmentList = Arrays.asList(mapper.readValue(Paths.get("src\\main\\resources\\json\\hospital.json").toFile(), Department[].class));
				departmentService.save(departmentList);
				List<Doctor> doctorList = Arrays.stream(mapper.readValue(Paths.get("src\\main\\resources\\json\\doctors.json").toFile(), Doctor[].class)).filter(doctor -> doctor.getDepartment().getId().equals(1L)).collect(Collectors.toList());
				doctorService.save(doctorList);

			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}

		};
	}
}
