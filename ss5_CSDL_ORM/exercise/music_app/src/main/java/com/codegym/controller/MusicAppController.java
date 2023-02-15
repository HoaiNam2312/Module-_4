package com.codegym.controller;

import com.codegym.model.MusicApp;
import com.codegym.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new MusicApp());
        return "create";
    }

    @PostMapping("/save")
    public String save(MusicApp musicApp, RedirectAttributes redirectAttributes) {
        iMusicAppService.save(musicApp);
        redirectAttributes.addFlashAttribute("success", "Them moi thanh cong");
        return "redirect:/musicapp";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("music", iMusicAppService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(MusicApp music, RedirectAttributes redirectAttributes) {
        iMusicAppService.update(music.getId(), music);
        redirectAttributes.addFlashAttribute("success", "Cap nhap thanh cong");
        return "redirect:/musicapp";
    }

    @GetMapping("/delete")
    public String showDeleteFomr(@RequestParam int id, Model model) {
        model.addAttribute("music", iMusicAppService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(MusicApp music, RedirectAttributes redirectAttributes) {
        iMusicAppService.remove(music.getId());
        redirectAttributes.addFlashAttribute("success", "Xoa thanh cong");
        return "redirect:/musicapp";
    }
}
