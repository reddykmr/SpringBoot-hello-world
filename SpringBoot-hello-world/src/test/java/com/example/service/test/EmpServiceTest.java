package com.example.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.test.SpringBootHelloWorldApplicationTests;
import com.example.exception.RecordNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmpRepository;
import com.example.service.EmpService;

public class EmpServiceTest extends SpringBootHelloWorldApplicationTests {

	@InjectMocks
	private EmpService empService;

	@Mock
	private EmpRepository empRepository;

	private Employee emp;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		emp = new Employee();
		emp.setId(100);
		emp.setName("mahesh");

	}

	@Test
	public void test_saveEmp() {
		when(empRepository.save(emp)).thenReturn(emp);
		String text = empService.save(emp);
		assertNotNull(text);
		assertEquals(text, "Data created in database successfully");

	}

	@Test
	public void test_saveEmp_fail() {
		try {
			Employee emp = null;
			String text = empService.save(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void getEmpData() {
		Optional<Employee> optional = Optional.of(emp);
		when(empRepository.findById(100)).thenReturn(optional);
		assertThat(optional.isPresent());
		Employee empdata = empService.getData(100);
		assertNotNull(empdata);
		assertEquals(100, empdata.getId());
	}

	@Test(expected = RecordNotFoundException.class)
	public void getEmpData_fail() {
		Employee emp = new Employee();
		Optional<Employee> optional = Optional.of(emp);
		when(empRepository.findById(101)).thenReturn(optional);
		Employee empdata = empService.getData(101);
		assertEquals(empdata.getId(), 101);

	}

}
