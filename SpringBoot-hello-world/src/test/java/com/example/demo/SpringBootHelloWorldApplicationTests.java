package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import javax.xml.ws.Response;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.example.controller.HelloController;
import com.example.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;



@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootHelloWorldApplicationTests {
	

	@InjectMocks
	private HelloController controller;
	
	
	@Mock
	RestTemplate restTemplate;
	
	
	private ObjectMapper mapper=new ObjectMapper();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		
	}
	
	
	@Test
	public void test_showHello() {
		   String msg="hello";
		   ResponseEntity<String> responseEntity=new ResponseEntity<>(msg,HttpStatus.OK);
		   doReturn(responseEntity).when(restTemplate).getForEntity(ArgumentMatchers.anyString(), ArgumentMatchers.any());
		   assertNotNull(responseEntity.getBody());
		   assertEquals(200,responseEntity.getStatusCodeValue());
		   	   
		   
	}
	@Test
	public void test_controllerShowhome() throws Exception {
		    String text="";
		    text=controller.showHome();
		    System.out.println(text);
		    assertEquals("Hello",text);
		
	}
	@Test
	public void test_empData() throws Exception {
		   Employee emp=null;
		    emp=controller.showEmpData();
		    System.out.println(emp.getId());
		    assertNotNull(emp.getName());
		
	}
	
	
	

}
