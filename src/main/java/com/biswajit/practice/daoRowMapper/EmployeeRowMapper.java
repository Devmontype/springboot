package com.biswajit.practice.daoRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;

import com.biswajit.practice.model.EmployeeModel;

public class EmployeeRowMapper implements RowMapper<EmployeeModel> {

	public EmployeeModel mapRow(ResultSet rs,int rownum)throws SQLException{
		EmployeeModel emp=new EmployeeModel();				
			emp.setEmail(rs.getString("email"));
			emp.setPassword(rs.getString("password"));
			emp.setFullname(rs.getString("fullname"));
			emp.setEnabled(rs.getString("enabled"));
			String[] autharr = rs.getString("authority").split(",");
			Set<String> authoritySet=new HashSet<String>(Arrays.asList(autharr));
			emp.setAuthoriti(authoritySet);
		return emp;
	}
}
