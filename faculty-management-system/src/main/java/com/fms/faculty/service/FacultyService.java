package com.fms.faculty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.faculty.model.faculty;
import com.fms.faculty.repository.FacultyRepository;

@Service
public class FacultyService {
	@Autowired
	
	private FacultyRepository facultyrepository;
	
	public faculty saveFaculty( faculty f) {
		return facultyrepository.save(f);
	}
	
	public List<faculty> getFacultylist() {
		return facultyrepository.findAll();
	}
	
	public faculty getFacultyId(Integer id ) {
		return facultyrepository.findById(id).get();
	}
	

	public List<faculty> getFacultyByNameorAddressapi(String name ,String address){
		return facultyrepository.findByNameOrAddress(name,address);
	}
	
	
	public List<faculty> getFacultyByName(String name){
		return facultyrepository.findByName(name);
	}
	
	
	public List<faculty> deleteByFacultyId(Integer id) {
		facultyrepository.deleteById(id);;
		return getFacultylist();
		
	}
}
