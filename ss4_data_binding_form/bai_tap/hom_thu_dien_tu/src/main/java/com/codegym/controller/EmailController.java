package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {
    @ModelAttribute("arraylanguages")
    public String[] arrayLanguages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("arrayPageSize")
    public int[] arrayPageSize() {
        return new int[]{5, 10, 15, 25, 50, 100};
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("email", new Email());
        return "create";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Email email, Model model) {
        model.addAttribute("email", email);
        return "info";
    }
}
