package com.MyOwn.MyOwn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyOwn.MyOwn.Entity.Student;
import com.MyOwn.MyOwn.EntityRepo.StudentRepo;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> findStudentsByFirstName(String firstName) {
        return studentRepo.findStudentsByFirstName(firstName);
    }
    
    public List<Student> findStudentByLastName(String lastName){
    	return studentRepo.findByLastName(lastName);
    }
}

