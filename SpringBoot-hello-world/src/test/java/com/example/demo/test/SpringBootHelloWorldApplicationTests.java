package com.example.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.controller.test.HomeControllerTest;
import com.example.service.EmpService;
import com.example.service.test.EmpServiceTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HomeControllerTest.class,EmpServiceTest.class})
public class SpringBootHelloWorldApplicationTests {
	
	@Test
	public void contextLoads() {
		
	}

}
