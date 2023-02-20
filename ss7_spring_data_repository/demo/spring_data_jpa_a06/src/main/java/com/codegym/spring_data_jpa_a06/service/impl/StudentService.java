package com.codegym.spring_data_jpa_a06.service.impl;

import com.codegym.spring_data_jpa_a06.model.Student;
import com.codegym.spring_data_jpa_a06.repository.IStudentRepository;
import com.codegym.spring_data_jpa_a06.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<Student> search(String name) {
        return studentRepository.search("%"+name+"%");
    }

    @Override
    public Page<Student> search(String name, Pageable pageable) {
        return studentRepository.searchPage("%"+name+"%",pageable);
    }

    @Override
    public void save(Student student) {
      studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
