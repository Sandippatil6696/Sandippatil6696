package com.fms.faculty.controller;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fms.faculty.model.faculty;
import com.fms.faculty.service.FacultyService;

@RestController
@CrossOrigin("*")
public class FacultyRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(FacultyRestController.class);
	
	@Autowired
	private FacultyService facultyService;
	
		//add data  by post method & update data
		@RequestMapping(value= "/faculty", method=RequestMethod.POST)
		@CacheEvict( value="faculty_info" ,allEntries=true)
		public faculty saveFacultydata(@RequestBody faculty fac) {
			return facultyService.saveFaculty(fac);
		}
	
	
		// get data
		@RequestMapping(value= "/faculty", method=RequestMethod.GET)
		@Cacheable(value="faculty_info") 
		
		public ResponseEntity<?> getFacultyData(){
			logger.info("application started");
			List <faculty> list = facultyService.getFacultylist();
			List <RepresentationModel<?>> l = new ArrayList<>();
			
			for(faculty f:list) {
				Links link = f.getLinks().merge(Links.MergeMode.REPLACE_BY_REL,
						linkTo(methodOn(FacultyRestController.class).getFacultyById(f.getId())).withSelfRel());
				l.add(ResponseEntity.ok(CollectionModel.of(f, link)).getBody());
			}
			
			return ResponseEntity.ok(
					CollectionModel.of(l, linkTo(methodOn(FacultyRestController.class).getFacultyData()).withSelfRel()));
			
		}
		 
		//get by id 
		@RequestMapping(value= "/faculty/{id}", method=RequestMethod.GET)
		public ResponseEntity<?>getFacultyById(@PathVariable("id") Integer id) {
			faculty f1 = facultyService.getFacultyId(id);
			
			Links link = f1.getLinks().merge(Links.MergeMode.REPLACE_BY_REL,
					linkTo(methodOn(FacultyRestController.class).getFacultyById(id)).withSelfRel());
			
			return ResponseEntity.ok(CollectionModel.of(f1, link));
			}
		
		//get by name
		@GetMapping("/faculty/name")
		public List<faculty> getByName(@RequestParam("name") String name) {
			return facultyService.getFacultyByName(name);
			}
		
		
		// delete by id 
		@DeleteMapping("/faculty/{id}")
		public List <faculty> deleteById(@PathVariable Integer id) {
			return facultyService.deleteByFacultyId(id);
			}
		
		//search name by post method WITH OR WITHOUT UPPER LOWER CASe
		@RequestMapping(value= "/faculty/search", method=RequestMethod.POST)
		public faculty searchFaculty(@RequestBody faculty faculty) {
			List <faculty> list = facultyService.getFacultylist();
			return list.stream().filter(n -> n.getName().toLowerCase().contains(faculty.getName().toLowerCase())).findFirst().get() ;	
		}
		
		
		//update data
		@PatchMapping("/faculty")
		public faculty updateFacultydata(@RequestBody faculty f){
			return facultyService.saveFaculty(f);
			}
		
		
		//search by both name or address
		@RequestMapping(value= "/faculty/nameadrr/{str}", method=RequestMethod.GET)
		public faculty getByNameandAddress(@PathVariable("str") String str) {
			
			List <faculty> list =  facultyService.getFacultylist();
			
			for(faculty f:list){
				if(f.getName().toLowerCase().contains(str)){
					return f;
				}
			}
			
			for(faculty f:list) {
				if(f.getAddress().toLowerCase().contains(str)) {
					return f;
				}
			}
			
			return null;
			}
		//search by both name or address by postmapping
		@PostMapping("/faculty/api")
		public List<faculty> getByNameOrAddressByPost(@RequestBody faculty fac ) {
			return facultyService.getFacultyByNameorAddressapi(fac.getName(),fac.getAddress());
		}
		
		
		//insert data using Jdbc template
		
		@Autowired  
	    JdbcTemplate jdbc;    
	    @RequestMapping("/insert")  
	    public String index(){  
	        jdbc.execute("insert into faculty_table(id,faculty_name,faculty_address)values(8,'javatpoint','java@javatpoint.com')");  
	        return"data inserted Successfully";  
	    }  
		
		
		
		
		
		
		
		
		
		
		
	//get all list
	
//	@RequestMapping(value= "/faculty", method=RequestMethod.GET)
//	public List <faculty> getfacultydata() {
//		
//		List <faculty> list = new ArrayList<faculty>();
//		
//		list.add(new faculty(1,"sandip","vadodara"));
//		list.add(new faculty(2,"kartik","vadodara"));
//		list.add(new faculty(3,"mayur","vadodara"));
//		return list;
//	}
//	
//	//filter data  get data by id 
//	
//	@RequestMapping(value= "/faculty/{id}", method=RequestMethod.GET)
//	public faculty getById(@PathVariable("id") Integer id) {
//		
//		List <faculty> list = Getfacultylist();
//		Optional<faculty> faculty =list.stream().filter(n -> n.getId().equals(id)).findFirst();
//		return faculty.get();
//		}
	
	//filter data get by name
	
//	@GetMapping("/faculty/name")
//	public faculty getByName(@RequestParam("name") String name) {
//		
//		List <faculty> list = Getfacultylist();
//		
//		Optional<faculty> faculty =list.stream().filter(n -> n.getName().equals(name)).findFirst();
//		
//		return faculty.get();
//		}
	
//	//filter data get by name without any upper lower case & search with 2,3 letters
//	
//	@GetMapping("/faculty/filter")
//	public faculty getByNameFilter(@RequestParam("name") String name) {
//		
//		List <faculty> list = Getfacultylist();
//		Optional<faculty> faculty =list.stream().filter(n -> n.getName().toLowerCase().contains(name.toLowerCase())).findFirst();
//		
//		return faculty.get();
//		}
	
	//add data  by post method
	
//	@RequestMapping(value= "/faculty", method=RequestMethod.POST)
//	public List <faculty> getfacultydataByPost(@RequestBody faculty faculty) {
//		
//		List <faculty> list = Getfacultylist();
//		
//		list.add(faculty);
//		return list;
//	}
	
	//search data in post method
	
//	@RequestMapping(value= "/faculty/search", method=RequestMethod.POST)
//	public faculty searchFaculty(@RequestBody faculty faculty) {
//		
//		List <faculty> list = Getfacultylist();
//		
//		return list.stream().filter(n -> n.getName().toLowerCase().contains(faculty.getName().toLowerCase())).findFirst().get() ;
//		
//		
//	}
	
	
	//search by both name or address
//	@RequestMapping(value= "/faculty/nameadrr/{str}", method=RequestMethod.GET)
//	public faculty getByNameandAddress(@PathVariable("str") String str) {
//		
//		List <faculty> list = Getfacultylist();
//		
//		for(faculty f:list){
//			if(f.getName().toLowerCase().contains(str)){
//				return f;
//			}
//		}
//		
//		for(faculty f:list) {
//			if(f.getAddress().toLowerCase().contains(str)) {
//				return f;
//			}
//		}
//		
//		return null;
//		}
//	
//	//edit list by put method
//	@RequestMapping(value= "/faculty", method=RequestMethod.PUT)
//	public List <faculty> updateFaculty(@RequestBody faculty faculty) {
//		
//		List <faculty> list = Getfacultylist();
//		Optional<faculty> data =list.stream().filter(n -> n.getId().equals(faculty.getId())).findFirst();
//		list.set(data.get().getId()-1, faculty);
//		return list;
//		
//		
//	}
	
	// delete a data by delete method
//	@DeleteMapping("/faculty/delete/{id}")
//	public List <faculty> deleteById(@PathVariable Integer id) {
//		
//		List <faculty> list = Getfacultylist();
//		
//		Optional<faculty> data =list.stream().filter(n -> n.getId().equals(id)).findFirst();
//		list.remove(data.get());
//		return list;
//		}
	
//	public List <faculty> Getfacultylist() {
//		List <faculty> list = new ArrayList<faculty>();
//		list.add(new faculty(1,"sandip","vadodara"));
//		list.add(new faculty(2,"kartik","vadodara"));
//		list.add(new faculty(3,"mayur","vadodara"));
//		return list;
//		
//	}
}
