package com.codegym.demo.controller;

import com.codegym.demo.model.Smartphone;
import com.codegym.demo.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/smartphone")
public class SmartphoneController {
    @Autowired
    ISmartphoneService smartphoneService;

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("phoneList", smartphoneService.findAll());
        return "list";
    }

    @PostMapping("/create")
    public String saveSmartphone(@RequestBody Smartphone smartphone, Model model) {
        if (smartphone.getProducer().equals("") || smartphone.getModel().equals("") || (smartphone.getPrice() + "").equals("")) {
            model.addAttribute("phoneList", smartphoneService.findAll());
            return "create";
        }
        smartphoneService.save(smartphone);
        model.addAttribute("phoneList", smartphoneService.findAll());
        return "create";
    }
    @PostMapping("/update")
    public String updateSmartphone(@RequestBody Smartphone smartphone, Model model) {
//        if (smartphone.getProducer().equals("") || smartphone.getModel().equals("") || (smartphone.getPrice() + "").equals("")) {
//            model.addAttribute("phoneList", smartphoneService.findAll());
//            return "create";
//        }
        smartphoneService.save(smartphone);
        model.addAttribute("phoneList", smartphoneService.findAll());
        return "create";
    }
}
