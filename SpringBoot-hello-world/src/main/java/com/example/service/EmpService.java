package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.RecordNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmpRepository;
import com.example.utils.EmpUtils;

@Service
public class EmpService {
	
	
	@Autowired
	private EmpRepository empRepository;
	
	
	public String save(Employee emp) {
		
		if(emp== null) {
			throw new RecordNotFoundException("Record Data Found");
		}
		else {
			empRepository.save(emp);
			return EmpUtils.CREATED.getMsg();
		}
		
	}
	public Employee getData(int id) {
		   Optional<Employee> optional=empRepository.findById(id);
		   if(optional.get().getId()==id) {
			   return optional.get();
		   }
		   else {
			   throw new RecordNotFoundException("No Data found");
		   }
	}


}
