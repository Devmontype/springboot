package com.biswajit.practice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biswajit.practice.daoImpl.EmployeeDaoImpl;
import com.biswajit.practice.model.EmployeeModel;
import com.biswajit.practice.service.EmployeeService;

@Repository
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDaoImpl employeeDaoImpl;

	@Override
	public EmployeeModel signInEmployee(String email, String password) {
		EmployeeModel emp=employeeDaoImpl.signInEmployee(email, password);
		return emp;
	}

	@Override
	public EmployeeModel findEmployeeByEmail(String email) {
		EmployeeModel emp=employeeDaoImpl.findEmployeeByEmail(email);
		return emp;
	}

	@Override
	public int SignUpEmployee(EmployeeModel emp) {
		int addEmp=employeeDaoImpl.SignUpEmployee(emp);
		// TODO Auto-generated method stub
		return addEmp;
	}

}
