package com.workshop.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.workshop.student.entity.FacultyEntity;
import com.workshop.student.entity.StudentEntity;
import com.workshop.student.service.FacultyService;
import com.workshop.student.service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private FacultyService facultyService;

	@GetMapping({"","/"})
	public String getAll() {
		System.out.println("----- StudentController getAll() -----");
		
		List<StudentEntity> students = studentService.getstudentAll();
		System.out.println("----- StudentController getAll() Result -----");
		System.out.println("size: "+ students.size());
		return "index";
	}

	@GetMapping("/{student-id}")
	public String getByid(@PathVariable(name = "student-id") Integer studentId) {
		System.out.println("----- StudentController getById() -----");
		System.out.println("student-id: " + studentId);

		StudentEntity entity = studentService.getstudentById(studentId);
		System.out.println("----- StudentController getById() Result -----");
		System.out.println("Student First Name: "+ entity.getStudentFirstName());
		System.out.println("Student Last Name: "+ entity.getStudentLastName());
		return "index";
	}

	@GetMapping("/delete/{student-id}")
	public String getDeletById(@PathVariable(name = "student-id") Integer studentId) {
		System.out.println("----- StudentController getDeleteById() -----");
		System.out.println("student-id: " + studentId);

		System.out.println("----- StudentController getDeleteById() Result-----");
		studentService.deleteFacultyById(studentId);
		return "index";
	}

	@PostMapping("/")
	public String postInsertAndUpdate(@RequestParam() Map<String, String> parum) {
		System.out.println("----- StudentController postInsertAndUpdate() -----");
		System.out.println("student-id: " + param.get("student-id"));
		System.out.println("student-code: " + param.get("student-code"));
		System.out.println("student-fname: " + param.get("student-fname"));
		System.out.println("student-lname: " + param.get("student-lname"));

		System.out.println("faculty-id: " + param.get("faculty-id"));

		System.out.println("----- StudentController postInsertAndUpdate() Result -----");
		Integer facultyId = Integer.parseInt(param.get("faculty-id"));
		FacultyEntity facultyEntity = facultyService.getFacultyById(facultyId);
		System.out.println(facultyEntity.getFacultyId());

		StudentEntity entity = new StudentEntity();
		if(null != param.get("student=id")){
			entity.setStudentId(Integer.parseInt(param.get("student-id")));
		}
		entity.setStudentCode(param.get("student-code"));
		entity.setStudentFirstName(param.get("student-fname"));
		entity.setStudentLastName(param.get("student-lname"));
		entity.setFaculty(facultyEntity);
		StudentEntity result = studentService.saveStudent(entity);
		System.out.println("Student ID: "+ result.getStudentId());
		System.out.println("Student First Name: "+ result.getStudentFirstName());
		System.out.println("Student Last Name: "+ result.getStudentLastName());
		return "index";
	}
	
	
	
	
}
