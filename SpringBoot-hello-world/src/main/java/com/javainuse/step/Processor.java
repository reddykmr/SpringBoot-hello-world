package com.javainuse.step;

import org.springframework.batch.item.ItemProcessor;

import com.example.model.Employee;

public class Processor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		System.out.println("emp data "+ item.toString());
		return item;
	}

	

}
