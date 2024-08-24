package com.workshop.student.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/enroll")
public class EnrollController {
     @GetMapping({"","/"})
	public String getAll() {
		System.out.println("----- enrollController getAll() -----");
		return "index";
	}


	@GetMapping("/{enroll-id}")
	public String getByid(
        @PathVariable(name = "enroll-id") Integer enrollId
        ) {
		System.out.println("----- enrollController getById() -----");
		System.out.println("enroll-id: " + enrollId);
		return "index";
	}

	@GetMapping("/delete/{enroll-id}")
	public String getDeletById(@PathVariable(name = "enroll-id") Integer enrollId) {
		System.out.println("----- enrollController getDeleteById() -----");
		System.out.println("enroll-id: " + enrollId);
		return "index";
    
}
@PostMapping("/")
	public String postInsertAndUpdate(@RequestParam() Map<String, String> parum) {
		System.out.println("----- StudentController postInsertAndUpdate() -----");
		System.out.println("enroll-id: " + parum.get("enroll-id"));
		System.out.println("enroll-name: " + parum.get("enroll-name"));
		return "index";
	}
}
