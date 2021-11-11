package com.javainuse.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.example.model.Employee;

public class Writer implements ItemWriter<Employee> {

	@Override
	public void write(List<? extends Employee> items) throws Exception {
		    
		
	}

}