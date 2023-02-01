package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.BindException;

@Controller
public class ConverController {
    @GetMapping()
    public String showPage() {
        return "index";
    }

    @PostMapping("/index")
    public String conver(@RequestParam String usd, Model model) {
        double rerult = Integer.parseInt(usd) * 23000;
        model.addAttribute("result", rerult);
        model.addAttribute("usd", usd);
        return "index";
    }

}
