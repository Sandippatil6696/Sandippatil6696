package com.fms.faculty.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.fms.faculty.model.faculty;
import com.fms.faculty.service.FacultyService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyservice;

	//	get all list 
	@GetMapping("/alllist")
	public String getall(Model faculty) {
		faculty.addAttribute("facultylist", facultyservice.getFacultylist());
		return "facultylist";
	}
	
    // for adding   data 	
	
	@PostMapping("/add")
	public ModelAndView save(@ModelAttribute faculty f) {

		facultyservice.saveFaculty(f);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("facultylist");
		modelAndView.addObject("facultylist",facultyservice.getFacultylist());
		return modelAndView;
	}
	
//	for delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deletebyid(@ModelAttribute faculty f) {

		facultyservice.deleteByFacultyId(f.getId());
		List<faculty> Data = facultyservice.getFacultylist();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("facultylist");
		modelAndView.addObject("facultylist", Data);

		return modelAndView;

	}
//  for update 
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute faculty f1 ) {
		facultyservice.saveFaculty(f1);
		List<faculty> Data = facultyservice.getFacultylist();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("facultylist");
		modelAndView.addObject("facultylist", Data);
		return modelAndView ;
		}
	@GetMapping("/update")
	public  ModelAndView getFacultyById(@ModelAttribute  faculty f1 ) {
		faculty f = facultyservice.getFacultyId(f1.getId());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update");
		modelAndView.addObject("facultylist", f);
		return modelAndView ;
		}

}
