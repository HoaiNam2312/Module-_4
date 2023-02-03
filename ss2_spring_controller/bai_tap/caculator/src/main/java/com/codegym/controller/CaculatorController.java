package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping()
    public String showPage() {
        return "index";
    }

    @PostMapping("/result")
    public String showResult(@RequestParam double soA, @RequestParam double soB,@RequestParam String caculation, Model model) {
        Double result = null;
        switch (caculation) {
            case "Addition(+)":
                 result = (soA + soB);
                 break;
            case "Subtraction(-)":
                 result = (soA - soB);
                 break;
            case "Multiplication(X)":
                 result = (soA * soB);
                 break;
            case "Division(/)":
                 result = (soA / soB);
                 break;

        }
        model.addAttribute("soA", soA);
        model.addAttribute("soB", soB);
        model.addAttribute("result", result);
        return "index";
    }
}
