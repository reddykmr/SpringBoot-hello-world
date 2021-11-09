package com.example.service;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.RecordNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmpRepository;
import com.example.utils.EmpUtils;

@Service
public class EmpService {
	
	
	@Autowired
	private EmpRepository empRepository;
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly =false,rollbackFor = {SQLException.class,RecordNotFoundException.class},timeout = 20)
	public String save(Employee emp) {
		
		if(emp== null) {
			throw new RecordNotFoundException("Record Data Found");
		}
		else {
			empRepository.save(emp);
			return EmpUtils.CREATED.getMsg();
		}
		
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly =true,rollbackFor = {SQLException.class,NullPointerException.class},timeout = 20)
	public Employee getData(int id) {
		
		   Optional<Employee> optional=empRepository.findById(id);
		   if(optional.get()==null) {
			   throw new RecordNotFoundException("No Data found");
		   }
		   else {
			   return optional.get();
		   }
	}


}
