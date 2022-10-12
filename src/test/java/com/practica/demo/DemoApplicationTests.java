package com.practica.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practica.demo.models.Department;
import com.practica.demo.models.Doctor;
import com.practica.demo.services.DepartmentService;
import com.practica.demo.services.DoctorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	private MockMvc mockMvc;
	@Autowired
	DoctorService doctorService;

	@Autowired
	DepartmentService departmentService;
	@Autowired
	private WebApplicationContext wac;


	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}


	@Test
	@Transactional
	public void testSaveDepartmentList() {
		try {
			List<Department> departmentList = departmentService.readFileHospitalJson();
			this.departmentService.save(departmentList);
		} catch (IOException e) {
			System.out.println("Unable to save data " + e.getMessage());
		}
	}


	@Test
	@Transactional
	public void testSaveDoctorList() {
		try {
			List<Doctor> doctorList = doctorService.readFileDoctorJson();
			this.doctorService.save(doctorList);
		} catch (IOException e) {
			System.out.println("Unable to save data " + e.getMessage());
		}
	}

	@Test
	public void testDoctorAttribute() throws Exception {
		mockMvc.perform(
						MockMvcRequestBuilders.get("/doctors")
								.contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers
						.model().attributeExists("doctors"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testFindByDepartmentId() throws IOException {
		Iterable<Doctor> doctors = doctorService.findByDepartmentId();
		Assert.assertNotNull(doctors);
		doctors.forEach(doctor -> {
			try {
				Assert.assertEquals(doctor.getDepartment().getId(),
						Long.valueOf((Integer) new ObjectMapper()
								.readValue(new File("src\\main\\resources\\json\\input.json"), Map.class)
								.get("department_id")));
			} catch (IOException exception) {
				System.out.println("Unable to find users " + exception.getMessage());
			}
		});
	}
}
