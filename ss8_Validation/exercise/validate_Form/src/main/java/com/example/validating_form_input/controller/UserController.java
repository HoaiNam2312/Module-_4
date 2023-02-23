package com.example.validating_form_input.controller;

import com.example.validating_form_input.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/user")
    public String check(@Validated User user, BindingResult bindingResult) {
        new User().validate(user,bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }
        return "result";
    }
}
