package com.codegym.repository.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        TypedQuery<Student> query = entityManager.createQuery("select s from Student as s", Student.class);
        studentList = query.getResultList();
        return studentList;
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Transactional
    @Override
    public void save(Student student) {
//        create
        entityManager.persist(student);
        // update
//        Student studentEdit = findById(student.getId());
//        studentEdit.setName(student.getName());
//        studentEdit.setGender(student.getGender());
//        entityManager.merge(studentEdit);// update
//        // xoá
//        Student studentDelete = findById(student.getId());
//        entityManager.remove(studentDelete);// xoá
    }
}
