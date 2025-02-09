package com.sanjay.dao;

import java.util.List;

import com.sanjay.model.Employee;

public interface EmployeeDao {

	
	public List<Employee> getEmployeeById(int id);
	public List<Employee> getEmployeeByFirstName(String firstName);
	public List<Employee> getAllEmployee();
	public Employee addEmployee(Employee emp);
}
