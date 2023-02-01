package com.codegym.controller;

import com.codegym.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {
    @Autowired
    ITranslateService TranslateService;

    @GetMapping()
    public String showPage() {
        return "index";
    }

    @PostMapping("/index")
    public String findWord(@RequestParam String english, Model model) {
        String result = TranslateService.result(english);
        model.addAttribute("english", english);
        model.addAttribute("vietnamese", result);
        return "index";
    }
}
