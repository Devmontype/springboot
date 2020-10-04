package com.biswajit.practice.model;

import java.util.HashSet;
import java.util.Set;

import com.biswajit.practice.validannotation.Email;

public class EmployeeModel {
	
	private String fullname;
	
	@Email
	private String email;
	private String password;
	private Set<String> authoriti=new HashSet();
	private String enabled;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getAuthoriti() {
		return authoriti;
	}
	public void setAuthoriti(Set<String> authoriti) {
		this.authoriti = authoriti;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "EmployeeModel [fullname=" + fullname + ", email=" + email + ", password=" + password + ", authoriti="
				+ authoriti + ", enabled=" + enabled + "]";
	}
	
}
