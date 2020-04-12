package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StudentServer {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student) {
        if (studentRepository.findByStudentName(student.getName()) == null) {
            studentRepository.addStudent(student.getName(), student.getGender(), student.getClassName());
            return "添加成功";
        } else {
            return "姓名重复";
        }
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByStudentName(name);
    }

    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    public int deleteStudent(String name) {
        return studentRepository.deleteByStudentName(name);
    }
}
