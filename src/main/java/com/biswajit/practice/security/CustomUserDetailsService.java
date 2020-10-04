package com.biswajit.practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biswajit.practice.model.UserModel;
import com.biswajit.practice.serviceimpl.UserServiceImpl;


public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel userData=userServiceImpl.findUserByEmail(username);
		System.out.println(userData);
		System.out.println("---------userdata-------");
		if(userData==null) {
						
			throw new UsernameNotFoundException(username);
		}
		UserDetails userDetail=User.withUsername(userData.getEmail()).password(userData.getPswd()).authorities("ROLE_USER").build();
		// TODO Auto-generated method stub
		return userDetail;
	}

}
