package com.biswajit.practice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biswajit.practice.model.UserModel;
import com.biswajit.practice.serviceimpl.UserServiceImpl;

@Controller
public class User {

	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(value="/user/private",method=RequestMethod.GET)
	public ModelAndView privateuser() {
		System.out.println("fbfbfghfhfh");
		return new ModelAndView("private_user");
		//return "private_user";
	}
	
	@RequestMapping(value="/userlogin",method=RequestMethod.GET)
	public ModelAndView showLogin() {
		return new ModelAndView("login_new","logUser",new UserModel());
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("logUser")UserModel logUser,BindingResult br) {
		System.out.println("value recived");
		System.out.println(logUser.toString());
		if(br.hasErrors()) {
			return "login";
		}
		int login=userService.logInUser(logUser);
		System.out.println(login);
		return "home";
	}
}
