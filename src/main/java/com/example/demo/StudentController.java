package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentServer studentRepository;

    @PostMapping("/post")
    public String post(@RequestBody Student student) {
        return studentRepository.addStudent(student);
    }

    @GetMapping("/student/{name}")
    public Student getStudent(@PathVariable String name) {
        return studentRepository.getStudentByName(name);
    }

    @GetMapping("/students")
    public Iterable<Student> getStudents() {
        return studentRepository.getStudents();
    }

    @GetMapping("/delete/{name}")
    public int deleteStudent(@PathVariable String name) {
        return studentRepository.deleteStudent(name);
    }
}
