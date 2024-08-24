package com.workshop.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.student.entity.EnrollEntity;
import com.workshop.student.repository.EnrollRepository;

@Service
public class EnrollService {
    
    @Autowired
    private EnrollRepository enrollRepository;
    
    public List<EnrollEntity> getenrollAll(){
        return enrollRepository.findAll();
    }

    public EnrollEntity getenrollById(Integer enrollId){
        Optional<EnrollEntity> enroll = enrollRepository.findById(enrollId);
        if(enroll.isPresent()){
            return enroll.get();
        }
        return null;
    }
    public EnrollEntity saveenroll(EnrollEntity enrollEntity){
        EnrollEntity enroll = enrollRepository.save(enrollEntity);
        return enroll;
    }
    public void deleteFacultyById(Integer enrollId){
        enrollRepository.deleteById(enrollId);
    }
}

    
