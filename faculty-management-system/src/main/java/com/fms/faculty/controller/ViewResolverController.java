package com.fms.faculty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewResolverController {
	
	
		@RequestMapping("/")
		public String indexPage() {
			return "save";
		}
		
		@RequestMapping("/del")
		public String deletePage() {
			return "delete";
		}
		
		@RequestMapping("/update/{id}")
		public String updatepage() {
			return "update";
		}
}
