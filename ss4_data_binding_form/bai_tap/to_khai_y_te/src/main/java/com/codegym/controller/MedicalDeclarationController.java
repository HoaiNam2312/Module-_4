package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicalDeclarationController {
    @RequestMapping()
    public ModelAndView showPage() {
        ModelAndView mav = new ModelAndView("form", "medicalDeclaration", new MedicalDeclaration());
        mav.addObject("yearOfBirth", new int[]{1996, 1997, 1998, 1999, 2001, 2002, 2003, 2004, 2005});
        mav.addObject("nationality", new String[]{"Việt Nam", "Anh Quốc", "Hoa Kỳ", "Nhật Bản", "Hàn Q uốc"});
        mav.addObject("transportVehicle", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác (Ghi rõ)"});
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView showDetail(@ModelAttribute MedicalDeclaration medicalDeclaration) {
        ModelAndView mav = new ModelAndView("detail");
        mav.addObject("medicalDeclaration", medicalDeclaration);
        return mav;
    }
}
