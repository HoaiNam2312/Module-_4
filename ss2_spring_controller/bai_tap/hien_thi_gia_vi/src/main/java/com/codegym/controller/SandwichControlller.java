package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichControlller {
    @RequestMapping()
    public String showPage() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment",required = false,defaultValue = "") String[] condiment, Model model) {
        if (condiment.length == 0) {
            model.addAttribute("mess", "No ingredients");
        }else {
            model.addAttribute("list",condiment);
        }
        return "show";
    }
}
