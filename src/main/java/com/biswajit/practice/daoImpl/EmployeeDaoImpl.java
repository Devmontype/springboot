package com.biswajit.practice.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.biswajit.practice.dao.EmployeeDao;
import com.biswajit.practice.daoRowMapper.EmployeeRowMapper;
import com.biswajit.practice.model.EmployeeModel;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private final String InsertQuery="insert into springboot_employee(fullname,email,password,status,authority,enabled) values("
			+ ":fullname,:email,:password,:status,:authority,:enabled)";
	private final String EmpByEmail="select * from springboot_employee where email=:email";
	private final String SignInByEmail="select * from springboot_employee where email=:email and password=:password";
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public EmployeeModel signInEmployee(String email, String password) {
		SqlParameterSource parameters=new MapSqlParameterSource().addValue("email", email).addValue("password", password);
		EmployeeModel emp=namedParameterJdbcTemplate.queryForObject(SignInByEmail, parameters, new EmployeeRowMapper());
		return emp;
	}

	@Override
	public EmployeeModel findEmployeeByEmail(String email) {
		SqlParameterSource parameters=new MapSqlParameterSource().addValue("email", email);
		EmployeeModel emp=namedParameterJdbcTemplate.queryForObject(EmpByEmail, parameters, new EmployeeRowMapper());
		return emp;
	}

	@Override
	public int SignUpEmployee(EmployeeModel emp) {
		System.out.println("-------Inside  emp signup dao------");
		KeyHolder key=new GeneratedKeyHolder();
		SqlParameterSource parameters=new MapSqlParameterSource().addValue("fullname", emp.getFullname())
				.addValue("email", emp.getEmail()).addValue("password", emp.getPassword()).addValue("status", 1)
				.addValue("authority", String.join(",",emp.getAuthoriti())).addValue("enabled", emp.getEnabled());
		int addEmp=namedParameterJdbcTemplate.update(InsertQuery, parameters,key);
		System.out.println(addEmp);
		return addEmp;
	}

}
