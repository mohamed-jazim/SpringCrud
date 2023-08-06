package com.spring.controller;

import com.spring.model.Student;
import com.spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stu")
public class EmployeeController {

    private final StudentService studentService;

    public EmployeeController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //build create student rest api
    @PostMapping()
    public ResponseEntity<Student> saveStudent(@RequestBody  Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("{id}")
    public  ResponseEntity<Student> findById(@PathVariable("id") long stid){
        return new ResponseEntity<Student>(studentService.findById(stid),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long ids , @RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student,ids),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long ide){
        studentService.deleteStudent(ide);
        return new ResponseEntity<String>("deleted sucessfully",HttpStatus.OK);
    }

}
