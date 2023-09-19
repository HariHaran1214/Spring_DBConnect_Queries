package com.MyOwn.MyOwn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.MyOwn.MyOwn.Entity.Student;
import com.MyOwn.MyOwn.EntityRepo.StudentRepo;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentRepo.save(student);
        return "Student inserted successfully";
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @GetMapping("/search/{firstName}")
    public List<Student> searchStudentsByFirstName(@PathVariable String firstName) {
        return studentRepo.findStudentsByFirstName(firstName);
    }
    
    @GetMapping("/serch/{lastName}")
    public List<Student> searchByLastName(@PathVariable String lastName){
    	return studentRepo.findByLastName(lastName);
    }
}
