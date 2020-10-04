package com.biswajit.practice.security;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	DataSource datasource;
	
	@Autowired
	//private CustomUserDetailsService userDetailService;
	private EmployeePrincipalDetailsService employeePrincipalDetailsService;
	
	public WebSecurityConfig(EmployeePrincipalDetailsService employeePrincipalDetailsService) {
		this.employeePrincipalDetailsService=employeePrincipalDetailsService;
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(userDetailService);
		daoAuthenticationProvider.setUserDetailsService(this.employeePrincipalDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return daoAuthenticationProvider;
	}
	
	public  void configure(AuthenticationManagerBuilder auth)throws Exception{
		
		auth.authenticationProvider(authProvider());
//		auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(NoOpPasswordEncoder.getInstance()).usersByUsernameQuery("select email as username,pswd,enabled "
//				+ "from springboot_users where email = ?").authoritiesByUsernameQuery("select email as username,authority "
//						+ "from springboot_users where email = ?");
		//auth.inMemoryAuthentication().withUser("biswajit").password("biswajit").roles("USER");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()throws Exception{
		 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	public void configure(HttpSecurity http)throws Exception{
		
		http.authorizeRequests().antMatchers("/emp/empPrivate").hasRole("EMPLOYEE").and().formLogin().loginPage("/emp/empLogin").loginProcessingUrl("/signin")
		.usernameParameter("email").passwordParameter("password")
		.successHandler((req,res,auth)->{
			 for (GrantedAuthority authority : auth.getAuthorities()) {
		            System.out.println(authority.getAuthority());
		         }
		         System.out.println(auth.getName());
		         res.sendRedirect("/SpringPractice/emp/empPrivate");    
		}).failureHandler((req,res,exp)->{
			 String errMsg="";
//			 System.out.println("i am from configuration");
//			 System.out.println(exp.getClass().isAssignableFrom(InternalAuthenticationServiceException.class));
	         if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
	            errMsg="Invalid username or password.";
	         }else{
	            errMsg="Unknown error - "+exp.getMessage();
	         }
	         req.getSession().setAttribute("message", errMsg);
	         res.sendRedirect("/SpringPractice/emp/empLogin");
		})
		.permitAll().and()
	      .csrf().disable();
	}
}
