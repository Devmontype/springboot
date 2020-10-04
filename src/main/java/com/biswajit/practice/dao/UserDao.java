package com.biswajit.practice.dao;

import com.biswajit.practice.model.UserModel;

public interface UserDao {

	public abstract UserModel logUser(UserModel user); 
	public abstract UserModel findByEmail(String email);
}
