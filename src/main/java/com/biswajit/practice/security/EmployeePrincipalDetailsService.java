package com.biswajit.practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biswajit.practice.model.EmployeeModel;
import com.biswajit.practice.serviceimpl.EmployeeServiceImpl;

@Service
public class EmployeePrincipalDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EmployeeModel emp=employeeServiceImpl.findEmployeeByEmail(username);
		EmployeePrincipal empPrincipal=new EmployeePrincipal(emp);
		return empPrincipal;
	}

}
