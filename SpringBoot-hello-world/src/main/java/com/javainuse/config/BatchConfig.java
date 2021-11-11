	package com.javainuse.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.example.model.Employee;
import com.javainuse.step.EmployeeRowMapper;
import com.javainuse.step.Processor;
import com.javainuse.step.Reader;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	@Autowired
	private DataSource dataSource;
	
	@Bean("itemreader")
	public JdbcCursorItemReader<Employee> getJdbcCursorItemReader(){
		JdbcCursorItemReader<Employee> itemReader=null;
		itemReader=new JdbcCursorItemReader<Employee>();
		itemReader.setSql("select * from employee");
		itemReader.setDataSource(dataSource);
		itemReader.setFetchSize(10);
		itemReader.setRowMapper(new EmployeeRowMapper());
		return itemReader;
	}
	@Bean
	public FlatFileItemWriter<Employee> getFileItemWriter(){
		FlatFileItemWriter<Employee> fileItemWriter=null;
		fileItemWriter=new FlatFileItemWriter<>();
		fileItemWriter.setResource(new FileSystemResource("User/mahesh.karna/Downloads/emp.txt"));
		fileItemWriter.setLineAggregator(getAggregator());
		return fileItemWriter;
		
	}
	@Bean
	public FieldExtractor<Employee> getExtractor(){
		    String[] properties= {"id","name"};
		    BeanWrapperFieldExtractor<Employee> extractor=new BeanWrapperFieldExtractor<>();
		    extractor.setNames(properties);
		    return extractor;
	}
	@Bean
	public LineAggregator<Employee> getAggregator(){
		  DelimitedLineAggregator<Employee> aggregator=new DelimitedLineAggregator<>();
		  aggregator.setDelimiter(",");
		  aggregator.setFieldExtractor(getExtractor());
		  return aggregator;
	}
	@Bean
	public Step getStep() {
		   return stepBuilderFactory.get("empstep-1")
		   .<Employee,Employee>chunk(5)
		   .reader(new Reader())
		   .processor(new Processor())
		   .writer(getFileItemWriter()).build();
	}
	
	@Bean
	public Job getJob() {
		    return jobBuilderFactory.get("empjob")
		    		.incrementer(new RunIdIncrementer())
		    		.start(getStep())
		    		.build();
	}
	

}
