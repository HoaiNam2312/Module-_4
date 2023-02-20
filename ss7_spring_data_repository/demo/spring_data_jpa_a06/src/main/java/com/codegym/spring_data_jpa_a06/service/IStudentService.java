package com.codegym.spring_data_jpa_a06.service;

import com.codegym.spring_data_jpa_a06.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student> search(String name);
    Page<Student> search(String name, Pageable pageable);
    void save(Student student);
    Student findById(int id);
}
