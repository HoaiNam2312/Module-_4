package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
//    @Qualifier("studentService")
    IStudentService studentService;
    @GetMapping("student/list")
    public String showList(Model model){
        model.addAttribute("studentList",studentService.findAll());
        return "list";
    }
    @GetMapping("/student/create")
    public String showFormCreate(){
        return "create";
    }
    @PostMapping("student/create")
    public String save(@RequestParam int id, @RequestParam String name, Model model){
        studentService.save(new Student(id,name));
        model.addAttribute("studentList",studentService.findAll());
        return "list";
    }
}
