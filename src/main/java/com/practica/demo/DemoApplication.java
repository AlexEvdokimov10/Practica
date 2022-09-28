package com.practica.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practica.demo.models.Doctor;
import com.practica.demo.models.Hospital;
import com.practica.demo.services.DoctorService;
import com.practica.demo.services.HospitalService;
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
	CommandLineRunner runner(HospitalService hospitalService,DoctorService doctorService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			try {
				List<Hospital> hospitalList = Arrays.asList(mapper.readValue(Paths.get("src\\main\\resources\\json\\hospital.json").toFile(), Hospital[].class));
				List<Doctor> doctorList = Arrays.asList(mapper.readValue(Paths.get("src\\main\\resources\\json\\doctors.json").toFile(), Doctor[].class)).stream().filter(doctor -> doctor.getHospital().getId().equals(1L)).collect(Collectors.toList());
				hospitalService.save(hospitalList);
				doctorService.save(doctorList);

			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}

		};
	}
}
