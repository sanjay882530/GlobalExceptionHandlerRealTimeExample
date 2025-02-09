package com.sanjay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjay.dao.EmployeeDao;
import com.sanjay.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao empDao;
	@Override
	public List<Employee> getEmployeeById(int id) {
		return empDao.getEmployeeById(id);
		
	}
	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		return empDao.getEmployeeByFirstName(firstName);
	}
	@Override
	public List<Employee> getAllEmployee() {
		return empDao.getAllEmployee();
	}
	@Override
	public Employee addEmployee(Employee emp) {
		return empDao.addEmployee(emp);
	}

}
