package com.spring.service;

import com.spring.model.Student;

import java.util.List;

public interface StudentService {

    //To save the student data
    Student saveStudent(Student student);

    //To list all the saved student data
    List<Student> getAllStudent();

    //To find a student by id
    Student findById(long id);

    Student updateStudent(Student student , long id);

    void deleteStudent(long id);

}
