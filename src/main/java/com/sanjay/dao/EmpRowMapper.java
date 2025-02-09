package com.sanjay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.sanjay.model.Employee;
@Service
public class EmpRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e=new Employee();
		e.setEmpId(rs.getInt(1));
		e.setEmailId(rs.getString(4));
		e.setFirstName(rs.getString(2));
		e.setLastName(rs.getString(3));
		e.setOrganazation(rs.getString(6));
		e.setContactNo(rs.getString(5));
		return e;
	}

}
