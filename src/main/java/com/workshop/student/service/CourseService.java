package com.workshop.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.student.entity.CourseEntity;
import com.workshop.student.repository.CourseRepository;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    
    public List<CourseEntity> getcourseAll(){
        return courseRepository.findAll();
    }

    public CourseEntity getcourseById(Integer courseId){
        Optional<CourseEntity> course = courseRepository.findById(courseId);
        if(course.isPresent()){
            return course.get();
        }
        return null;
    }
    public CourseEntity saveCourse(CourseEntity courseEntity){
        CourseEntity course= courseRepository.save(courseEntity);
        return course;
    }
    public void deleteFacultyById(Integer courseId){
        courseRepository.deleteById(courseId);
    }
}

    
