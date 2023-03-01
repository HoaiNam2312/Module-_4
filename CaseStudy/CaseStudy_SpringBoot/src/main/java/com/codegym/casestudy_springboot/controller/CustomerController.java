package com.codegym.casestudy_springboot.controller;

import com.codegym.casestudy_springboot.model.customer.Customer;
import com.codegym.casestudy_springboot.service.ICustomerService;
import com.codegym.casestudy_springboot.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping()
    public String showList(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 4, Sort.by("name").ascending());
        Page<Customer> pages = iCustomerService.search(pageable);
        model.addAttribute("pages", pages);
        return "/customer/list";
    }

    @GetMapping("/create")
    private String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/save")
    private String saveCustomerNew(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/customer";
    }
}
