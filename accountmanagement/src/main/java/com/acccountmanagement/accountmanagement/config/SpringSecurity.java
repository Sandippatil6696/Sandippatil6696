package com.acccountmanagement.accountmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;


@Configuration


public class SpringSecurity{
	
	@Bean
	 public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
		
//		this is basic authentication
		http
//		.csrf().disable() allows to check our api on cross platform like postman other wise without this allows only on broser 
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/account/all").hasRole("admin")
			.antMatchers("/account/{id}").hasRole("normal")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
		  
		return http.build();
		
	}

}
