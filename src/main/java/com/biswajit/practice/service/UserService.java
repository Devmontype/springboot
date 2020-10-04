package com.biswajit.practice.service;

import com.biswajit.practice.model.UserModel;

public interface UserService {

	public abstract int logInUser(UserModel user);
	public abstract UserModel findUserByEmail(String email);
}
