package com.example.validating_form_input.controller;

import com.example.validating_form_input.dto.UserDto;
import com.example.validating_form_input.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }


}
