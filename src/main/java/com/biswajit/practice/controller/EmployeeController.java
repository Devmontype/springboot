package com.biswajit.practice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biswajit.practice.model.EmployeeModel;
import com.biswajit.practice.serviceimpl.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@RequestMapping(value="/emp/empReg",method=RequestMethod.GET)
	public ModelAndView empSignUpView() {
		return new ModelAndView("employee","emp_user",new EmployeeModel());
	}
	
	@RequestMapping(value="/emp/empLogin",method=RequestMethod.GET)
	public ModelAndView empLogin() {
		return new ModelAndView("EmpLogin");
	}
	
	@RequestMapping(value="/emp/empPrivate",method=RequestMethod.GET)
	public ModelAndView empPrivate() {
		return new ModelAndView("private_user");
	}
	
	@RequestMapping(value="/emp/empSignup",method=RequestMethod.POST)
	public String empSubmit(@Valid @ModelAttribute("emp_user")EmployeeModel emp_user,BindingResult br) {
		System.out.println("emp form submitted");
		System.out.println(emp_user.toString());
		if(br.hasErrors()) {
			
			return "employee";
		}
		int addEmp=employeeServiceImpl.SignUpEmployee(emp_user);
		System.out.println("Employee added "+addEmp);
		return "home";
		
	}
}
