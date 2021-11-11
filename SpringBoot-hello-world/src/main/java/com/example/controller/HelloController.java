package com.example.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.RecordNotFoundException;
import com.example.model.Employee;
import com.example.service.EmpService;

@RestController
public class HelloController {
	
	@Autowired
	private EmpService empService;
	
	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job job;

	@GetMapping(value = "/hello")
	public String showHome() {
		String text = "Hello";
		return text;
	}

	@PostMapping(value = "/saveEmpData", produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveEmpData() throws RecordNotFoundException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		  JobParameters jobParameter=new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
		  jobLauncher.run(job, jobParameter);
		  Employee emp = null;
		String text = empService.save(emp);
		return text;

	}

	@GetMapping(value = "/getEmpData")
	public Employee showEmpData() throws RecordNotFoundException {
		Employee emp = empService.getData(100);

		return emp;
	}

}
