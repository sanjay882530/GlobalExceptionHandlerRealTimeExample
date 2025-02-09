package com.sanjay.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sanjay.model.Employee;

import io.micrometer.common.util.StringUtils;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	JdbcTemplate template;

	@Override
	public List<Employee> getEmployeeById(int id) {
		String sql = "Select * from employee where empId=?";

		@SuppressWarnings("deprecation")
		List<Employee> listOfEmploye = template.query(sql, new Object[] { id }, new EmpRowMapper());
		return listOfEmploye;
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		String sql = "Select * from employee where firstName=?";
		@SuppressWarnings("deprecation")
		List<Employee> queryForList = template.query(sql, new Object[] { firstName }, new EmpRowMapper());
		System.out.println(queryForList);
		return queryForList;
	}

	@Override
	public List<Employee> getAllEmployee() {
		String sql = "Select * from employee";
		List<Employee> queryForObject = template.query(sql, new EmpRowMapper());
		System.out.println(queryForObject);
		return queryForObject;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		if (emp.getPassword() == null || emp.getPassword().trim().isEmpty()) {
		    throw new IllegalArgumentException("Password cannot be null or empty");
		}
		if(getEmployeeById(emp.getEmpId()).isEmpty()){
			
		
		
	    String sql = "INSERT INTO employee (EMPID, PASSWORD, FIRSTNAME, LASTNAME, EMAILID, CONTACTNO, ORGANAZATION) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    
	    int status = template.update(sql, emp.getEmpId(), emp.getPassword(), emp.getFirstName(), 
	                                 emp.getLastName(), emp.getEmailId(), emp.getContactNo(), emp.getOrganazation());

	    return (status == 1) ? emp : null;
      
	}else {
		throw new DuplicateKeyException("Employee id allready exist");
	}
	}

}
