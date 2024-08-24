package com.workshop.student.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/course")
public class CourseController {
    @GetMapping({"","/"})
	public String getAll() {
		System.out.println("----- CourseController getAll() -----");
		return "index";
	}


	@GetMapping("/{coure-id}")
	public String getByid(
        @PathVariable(name = "course-id") Integer courseId
        ) {
		System.out.println("----- StudentController getById() -----");
		System.out.println("course-id: " + courseId);
		return "index";
	}

	@GetMapping("/delete/{course-id}")
	public String getDeletById(@PathVariable(name = "course-id") Integer courseId) {
		System.out.println("----- courseController getDeleteById() -----");
		System.out.println("course-id: " + courseId);
		return "index";
    
}
@PostMapping("/")
	public String postInsertAndUpdate(@RequestParam() Map<String, String> parum) {
		System.out.println("----- StudentController postInsertAndUpdate() -----");
		System.out.println("course-id: " + parum.get("course-id"));
		System.out.println("course-name: " + parum.get("course-name"));
		return "index";
	}
	
}