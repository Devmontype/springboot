package com.biswajit.practice.validannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.biswajit.practice.validations.EmailValidator;

@Documented
@Constraint(validatedBy=EmailValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
	
	String message() default "{email}";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}
