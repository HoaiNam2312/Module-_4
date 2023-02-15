package com.codegym.service.impl;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService2 implements IStudentService {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }
}
