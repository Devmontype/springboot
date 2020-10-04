package com.biswajit.practice.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.biswajit.practice.model.EmployeeModel;

public class EmployeePrincipal implements UserDetails {

	private EmployeeModel employeeModel;
	
	public EmployeePrincipal(EmployeeModel employeeModel) {
		this.employeeModel=employeeModel;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities=new ArrayList();
		for(String s:this.employeeModel.getAuthoriti()) {
			 GrantedAuthority authority = new SimpleGrantedAuthority(s);
	         authorities.add(authority);
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.employeeModel.getPassword();
	}

	@Override
	public String getUsername() {
		
		return this.employeeModel.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
//		if(this.employeeModel.getEnabled()=="true")
//		{
//			return true;
//		}else {
//			return false;
//		}
	}

}
