package com.sanjay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee
{
	private int empId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String contactNo;
	
	private String organazation;
	@JsonIgnoreProperties
	private String password;

}
