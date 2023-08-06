package com.spring.service.impl;

import com.spring.exception.ResourceNotFoundException;
import com.spring.model.Student;
import com.spring.repository.StudentRepository;
import com.spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

        //To save the student data
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

        //To list all the student data
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    //To find student by id
    @Override
    public Student findById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student","id",id));
    }

    @PutMapping("{id}")
    @Override
    public Student updateStudent(Student student, long id) {
       Student existing = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student","id",id));
       existing.setName(student.getName());
       existing.setEmail(student.getEmail());
       studentRepository.save(existing);


        return existing;

    }

    @Override
    public void deleteStudent(long id) {
        Student exis = studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "id",id));
        studentRepository.deleteById(id);
    }
}
