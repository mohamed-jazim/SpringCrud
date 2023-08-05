package com.spring.controller;

import com.spring.model.Student;
import com.spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stu")
public class EmployeeController {

    private StudentService studentService;

    public EmployeeController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //build create student rest api
    @PostMapping()
    public ResponseEntity<Student> saveStudent(@RequestBody  Student student){

        return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);



    }
}
