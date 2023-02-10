package com.codegym.repository.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
  static List<Student> studentList = new ArrayList<>();
   static {
      studentList.add(new Student(1,"chanh1",0,new String[]{"JS","PHP","Java"}));
      studentList.add(new Student(2,"chanh2",1,new String[]{"JS","PHP","Java"}));
      studentList.add(new Student(3,"chanh3",-1,new String[]{"JS","PHP","Java"}));
   }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(int id) {
        for (Student s: studentList) {
            if (id==s.getId()){
                return s;
            }
        }
        return null;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }
}
