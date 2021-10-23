package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import javax.annotation.security.RunAs;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



@SpringBootTest
class SpringBootHelloWorldApplicationTests {

	
	@Mock
	RestTemplate restTemplate;
	
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
		   assertEquals(responseEntity.getStatusCodeValue(),200);
		   	   
		   
	}
	
	

}
