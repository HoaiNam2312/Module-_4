package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
//    @Qualifier("studentService")
    IStudentService studentService;

    @ModelAttribute("languages")
    public String[] listLanguage(){
        return new String[]{"JS","PHP","JAVA","RUBY"};
    }

    @GetMapping("/list")
    public String showList(ModelMap model){
        model.addAttribute("studentList",studentService.findAll());
        return "list";
    }
    @GetMapping("/list2")
    public ModelAndView showList2(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("studentList",studentService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
     model.addAttribute("student", new Student());
//     model.addAttribute("languages", new String[]{"JS","PHP","JAVA","RUBY"});
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Student student, Model model, RedirectAttributes attributes){
        studentService.save(student);
        model.addAttribute("studentList",studentService.findAll());
        attributes.addFlashAttribute("mess","them moi thanh cong");
        return "redirect:/student/list";
    }
    @GetMapping("/detail")
    public String showDetail(@RequestParam(value = "id",required = false,defaultValue = "3") int id, Model model){
        model.addAttribute("student",studentService.findById(id));
        return "detail";
    }
    @GetMapping("/detail/{id}")
    // sử regex trên đường dẫn
//    @GetMapping("/detail/{id:[1-2]}")
    public String showDetail2(@PathVariable int id, Model model){
        model.addAttribute("student",studentService.findById(id));
        return "detail";
    }
}
