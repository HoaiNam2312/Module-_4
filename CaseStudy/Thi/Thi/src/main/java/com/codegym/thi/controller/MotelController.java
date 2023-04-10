package com.codegym.thi.controller;

import com.codegym.thi.dto.MotelDto;
import com.codegym.thi.model.Motel;
import com.codegym.thi.service.IMotelService;
import com.codegym.thi.service.IPaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/motel")
public class MotelController {
    @Autowired
    IMotelService motelService;

    @Autowired
    IPaymentService paymentService;

    @GetMapping("")
    public String showListMotel(@RequestParam(required = false, defaultValue = "") String name,
                                @RequestParam(required = false, defaultValue = "") String paymentId,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                Model model) {

        Pageable pageable = PageRequest.of(page, 4, Sort.by("name").ascending());
        model.addAttribute("pages", motelService.search(name, paymentId, pageable));
        model.addAttribute("paymentList", paymentService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("paymentId", paymentId);
        return "list";
    }

    @GetMapping("/delete")
    public String deleteMotel(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        motelService.deleteById(idDelete);
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/motel";
    }

    @GetMapping("/deletes")
    public String deleteMotels(@RequestParam String idChecked, RedirectAttributes redirectAttributes) {
        String[] idDeletes = idChecked.split(",");
        for (String tmp : idDeletes) {
            int id = Integer.parseInt(tmp);
            motelService.deleteById(id);
        }
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/motel";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("motelDto", new MotelDto());
        model.addAttribute("paymentList", paymentService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String saveMotel(@Validated MotelDto motelDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new MotelDto().validate(motelDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("paymentList", paymentService.findAll());
            return "create";
        }
        Motel motel = new Motel();
        BeanUtils.copyProperties(motelDto, motel);
        motelService.save(motel);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/motel";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        MotelDto motelDto = new MotelDto();
        BeanUtils.copyProperties(motelService.findById(id), motelDto);
        model.addAttribute("motelDto", motelDto);
        model.addAttribute("paymentList", paymentService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String updateMotel(@Validated MotelDto motelDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new MotelDto().validate(motelDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("paymentList", paymentService.findAll());
            return "edit";
        }
        Motel motel = new Motel();
        BeanUtils.copyProperties(motelDto, motel);
        motelService.save(motel);
        redirectAttributes.addFlashAttribute("success", "Chỉnh sửa thành công");
        return "redirect:/motel";
    }
}
