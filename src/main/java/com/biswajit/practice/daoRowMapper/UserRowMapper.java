package com.biswajit.practice.daoRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.biswajit.practice.model.UserModel;


public class UserRowMapper implements RowMapper<UserModel> {

	public UserModel mapRow(ResultSet rs,int rownum)throws SQLException{
		UserModel user=new UserModel();
				
			user.setEmail(rs.getString("email"));
			user.setPswd(rs.getString("pswd"));
		
		
		return user;
	}
}
