package com.biswajit.practice.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.biswajit.practice.model.EmployeeModel;
import com.biswajit.practice.serviceimpl.EmployeeServiceImpl;
import com.biswajit.practice.validannotation.Email;


public class EmailValidator implements ConstraintValidator<Email, String> {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Override
	public void initialize(Email email) {
    }
	
	@Override
	public boolean isValid(String s,ConstraintValidatorContext ctc) {
		if(s!=null) {
			EmployeeModel emp=employeeServiceImpl.findEmployeeByEmail(s);
			if(emp!=null) {
				return false;
			}else {
				return true;
			}
		}else {
			return true;
		}
//		boolean result=s.contains("jtp");  
//        return result;
	}
}
