package com.biswajit.practice.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.biswajit.practice.dao.UserDao;
import com.biswajit.practice.daoRowMapper.UserRowMapper;
import com.biswajit.practice.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserModel logUser(UserModel user) {
		System.out.println("Inside dao");
		String sql="Select * from springboot_users where email=? AND password=?";
		UserModel datauser=jdbcTemplate.queryForObject(sql,new UserRowMapper(), user.getEmail(),user.getPswd());
		return datauser;
	}
	
	@Override
	public UserModel findByEmail(String email) {
		System.out.println("Inside findbyemail meth");
		String sql="Select * from springboot_users where email=?";
		//UserModel datauser=jdbcTemplate.queryForObject(sql,new UserRowMapper(), email);
		
		List<UserModel> datauser=jdbcTemplate.query(sql,new String[] {email},new UserRowMapper());
		System.out.println(datauser);
		if(datauser.size()>0) {
			return datauser.get(0);
		}else {
			
			return null;
		}
		
	}

}
