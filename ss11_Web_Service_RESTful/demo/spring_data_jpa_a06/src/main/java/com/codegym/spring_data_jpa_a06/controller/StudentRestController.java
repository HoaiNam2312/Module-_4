package com.codegym.spring_data_jpa_a06.controller;

import com.codegym.spring_data_jpa_a06.dto.StudentDto;
import com.codegym.spring_data_jpa_a06.model.Student;
import com.codegym.spring_data_jpa_a06.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;
    // trả về list
    @GetMapping("")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
    // thêm mới
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody StudentDto studentDto){
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // xoá
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Student student = studentService.findById(id);
        if (student==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
