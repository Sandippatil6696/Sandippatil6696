package com.fms.faculty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.faculty.model.faculty;

@Repository
public interface FacultyRepository   extends JpaRepository<faculty, Integer>{
	
	List<faculty> findByName(String name);
	
	List<faculty> findByNameOrAddress(String name, String address);

	
}
