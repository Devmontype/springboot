package com.biswajit.practice.service;

import com.biswajit.practice.model.EmployeeModel;

public interface EmployeeService {
	
	public abstract EmployeeModel signInEmployee(String email,String password); 
	public abstract EmployeeModel findEmployeeByEmail(String email);
	public abstract int SignUpEmployee(EmployeeModel emp); 
}
