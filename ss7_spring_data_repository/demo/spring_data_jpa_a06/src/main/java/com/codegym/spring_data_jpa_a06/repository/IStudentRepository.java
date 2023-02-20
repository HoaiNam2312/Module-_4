package com.codegym.spring_data_jpa_a06.repository;



import com.codegym.spring_data_jpa_a06.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {

  List<Student> findByNameContaining(String name);
  // Câu query thuần
  @Query(value = "select * from student where name like :name",nativeQuery = true)
  List<Student> search(@Param("name") String name);

  // trả một Page<Student
  Page<Student> findByNameContaining(String name, Pageable pageable);

  @Query(value = "select * from student where name like :name",nativeQuery = true)
  Page<Student> searchPage(@Param("name") String name,Pageable pageable);
}
