package com.codegym.controller;

import com.codegym.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/musicapp")
public class MusicAppController {
    @Autowired
    IMusicAppService iMusicAppService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("musicList", iMusicAppService.findAll());
        return "list";
    }
}
