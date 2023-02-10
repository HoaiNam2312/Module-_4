package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicalDeclarationController {
    @RequestMapping("/showForm")
    public ModelAndView showPage() {
        ModelAndView mav = new ModelAndView("form", "medicalDeclaration", new MedicalDeclaration());
        mav.addObject("yearOfBirth", new int[]{1996, 1997, 1998, 1999, 2001, 2002, 2003, 2004, 2005});
        mav.addObject("nationality", new String[]{"Việt Nam", "Anh Quốc", "Hoa Kỳ", "Nhật Bản", "Hàn Q uốc"});
        mav.addObject("cityOfAddress", new String[]{"Đà Nẵng", "Hà Nội", "Hải Phòng", "Hồ Chí Minh", "Cần thơ"});
        mav.addObject("transportVehicle", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác (Ghi rõ)"});
        mav.addObject("districtOfAddress", new String[]{"Hải Châu", "Liên Chiểu", "Thanh Khê", "Sơn Trà", "Ngũ Hành Sơn", "Hòa Vang"});
        mav.addObject("wardOfAddress", new String[]{"Hòa Cường Bắc", "Hòa Thuận Tây", "Hòa Thuận Đông", "Hòa Cường Nam"});
        mav.addObject("symptom", new String[]{"Sốt", "Ho", "Khó thở", "Đau họng", "Nôn/buồn nôn", "Tiêu chảy", "Xuất huyết ngoài da", "Nổi ban ngoài da"});
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView showDetail(@ModelAttribute MedicalDeclaration medicalDeclaration) {
        ModelAndView mav = new ModelAndView("detail");
        mav.addObject("medicalDeclaration", medicalDeclaration);
        return mav;
    }
}
