package com.example.repository;

import com.example.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository{
    static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1, "Nam1"));
        studentList.add(new Student(2, "Nam2"));
        studentList.add(new Student(3, "Nam3"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
