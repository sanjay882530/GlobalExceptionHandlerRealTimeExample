package com.sanjay.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanjay.model.Employee;
import com.sanjay.service.EmployeeService;

@RestController
public class EmployeeController {
	
	EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	@GetMapping("/emp/id/{id}")
	public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable int id){
		return new ResponseEntity<>(service.getEmployeeById(id),HttpStatus.OK);
	}
	@GetMapping("/emp/{firstName}")
	public ResponseEntity<List<Employee>> getEmployeeByFirstName(@PathVariable String firstName){
		return new ResponseEntity<>(service.getEmployeeByFirstName(firstName),HttpStatus.OK);
	}
	@GetMapping("/emp")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<>(service.getAllEmployee(),HttpStatus.OK);
	}
	@PostMapping("/emp")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<>(service.addEmployee(emp),HttpStatus.OK);
		
	}
}
