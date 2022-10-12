package com.practica.demo;

import com.practica.demo.services.DoctorService;
import com.practica.demo.services.DepartmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(DepartmentService departmentService, DoctorService doctorService){
		return args -> {
			try {
				departmentService.save(departmentService.readFileHospitalJson());
				doctorService.save(doctorService.readFileDoctorJson());
			} catch (IOException e){
				System.out.println("Unable to save dates " + e.getMessage());
			}

		};
	}
}
