package com.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;

@RestController
public class HelloController {
	
	@GetMapping(value="/hello",produces = MediaType.APPLICATION_JSON_VALUE)
	public String showHome() {
		return "Hello";
	}
	@GetMapping(value="/getEmpData",produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee showEmpData() {
		Employee emp=new Employee();
		emp.setId(100);
		emp.setName("mahesh");
		return emp;
		
	}
	

}
