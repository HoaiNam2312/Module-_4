package com.codegym.smartphone_manager.controller;

import com.codegym.smartphone_manager.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/smartphone")
public class SmartphoneController {
    @Autowired
    ISmartphoneService smartphoneService;

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("phoneList", smartphoneService.findAll());
        return "/smartphone/alo";
    }
}
