package com.biswajit.practice.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.biswajit.practice.validannotation.Password;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	@Override
	public void initialize(Password password) {
    }
	
	@Override
	public boolean isValid(String s,ConstraintValidatorContext ctc) {
		boolean result=s.contains("jtp");  
        return result;
	}
}
