package com.fms.faculty;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FacultyManagementSystemApplication {
	
	 

	public static void main(String[] args) {
		SpringApplication.run(FacultyManagementSystemApplication.class, args);
	
	}

}
