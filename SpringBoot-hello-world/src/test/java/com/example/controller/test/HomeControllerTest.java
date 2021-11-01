package com.example.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.controller.HelloController;
import com.example.demo.test.SpringBootHelloWorldApplicationTests;
import com.example.model.Employee;
import com.example.service.EmpService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HomeControllerTest extends SpringBootHelloWorldApplicationTests{
	@InjectMocks
	private HelloController controller;  
	
	@Mock
	private EmpService empService;

	private Employee employee;
	private ObjectMapper mapper;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		employee = new Employee();
		employee.setId(100);
		employee.setName("mahesh");
		mapper=new ObjectMapper();

	}

	@Test
	public void testShowHome(){
			 String text="";
			 text=controller.showHome();
			 assertEquals("Hello", text);
			
	}
	@Test
	public void test_saveEmp() {
		
	}

}
