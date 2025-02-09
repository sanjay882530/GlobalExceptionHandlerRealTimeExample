package com.sanjay.service;

import java.util.List;

import com.sanjay.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployeeById(int id);
	public List<Employee> getEmployeeByFirstName(String firstName);
	public List<Employee> getAllEmployee();
	public Employee addEmployee(Employee emp);
	

}
