package com.biswajit.practice.dao;

import com.biswajit.practice.model.EmployeeModel;

public interface EmployeeDao {
	public abstract EmployeeModel signInEmployee(String email,String password); 
	public abstract EmployeeModel findEmployeeByEmail(String email);
	public abstract int SignUpEmployee(EmployeeModel emp); 
	
}

