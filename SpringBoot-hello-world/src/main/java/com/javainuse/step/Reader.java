package com.javainuse.step;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.batch.item.database.JdbcCursorItemReader;

import com.example.model.Employee;

public class Reader extends JdbcCursorItemReader<Employee> {

	private int count = 0;

	@Override
	public Employee readCursor(ResultSet rs, int currentRow) throws SQLException {
		Employee employee=new Employee();
	      employee.setId(rs.getInt("id"));
	      employee.setName("name");
	     return employee;
	}
	

}