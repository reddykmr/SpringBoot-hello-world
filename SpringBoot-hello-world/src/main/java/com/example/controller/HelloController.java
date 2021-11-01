package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.RecordNotFoundException;
import com.example.model.Employee;
import com.example.service.EmpService;

@RestController
public class HelloController {
	
	@Autowired
	private EmpService empService;

	@GetMapping(value = "/hello")
	public String showHome() {
		String text = "Hello";
		return text;
	}

	@PostMapping(value = "/saveEmpData", produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveEmpData() throws RecordNotFoundException {
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("mahesh");
		String text = empService.save(emp);
		return text;

	}

	@GetMapping(value = "/getEmpData")
	public Employee showEmpData() throws RecordNotFoundException {
		Employee emp = empService.getData(100);

		return emp;
	}

}
