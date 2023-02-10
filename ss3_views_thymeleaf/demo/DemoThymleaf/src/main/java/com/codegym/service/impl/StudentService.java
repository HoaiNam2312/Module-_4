package com.codegym.service.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
      studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }
}
