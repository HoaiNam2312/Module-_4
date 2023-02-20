package com.codegym.spring_data_jpa_a06.controller;

import com.codegym.spring_data_jpa_a06.model.Student;
import com.codegym.spring_data_jpa_a06.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired

    IStudentService studentService;

    @GetMapping("/list1")
    public String showList(ModelMap model,
                           @RequestParam(required = false,defaultValue = "")String searchName){
        model.addAttribute("studentList",studentService.search(searchName));
        return "list";
    }
//    @GetMapping("/list")
//    public String showList2(Model model,
//                                  @RequestParam(required = false, defaultValue = "") String searchName,
//                                  @PageableDefault(size = 2,page = 0,sort = "name",
//                                                   direction = Sort.Direction.DESC) Pageable pageable){
//        Page<Student> pages = studentService.search(searchName,pageable);
//        model.addAttribute("pages",pages);
//        model.addAttribute("searchName",searchName);
//        return "page";
//    }

    @GetMapping("/list")
    public String showList2(Model model,
                            @RequestParam(required = false, defaultValue = "") String searchName,
                            @RequestParam Optional<Integer> page){
        int page1=0;
        if (page.isPresent()){
            page1 = page.get();
        }
        Pageable pageable = PageRequest.of(page1,2,Sort.by("name").descending());

        Page<Student> pages = studentService.search(searchName,pageable);
        model.addAttribute("pages",pages);
        model.addAttribute("searchName",searchName);
        return "page";
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
    public String showDetail2(@PathVariable int id, Model model){
        model.addAttribute("student",studentService.findById(id));
        return "detail";
    }
}
