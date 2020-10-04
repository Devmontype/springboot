package com.biswajit.practice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswajit.practice.daoImpl.UserDaoImpl;
import com.biswajit.practice.model.UserModel;
import com.biswajit.practice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Override
	public int logInUser(UserModel user) {
		System.out.println("Inside service");
		UserModel logUser=userDaoImpl.logUser(user);
		if(logUser.getEmail()!="") {
			return 1;
		}else {
			return 0;
		}
	}
	
	@Override
	public UserModel findUserByEmail(String email) {
		System.out.println("Inside finduserbyemail");
		UserModel user=userDaoImpl.findByEmail(email);
		System.out.println(user);
		return user;
	}

}
