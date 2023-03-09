package com.codegym.casestudy_springboot.controller;

import com.codegym.casestudy_springboot.dto.CustomerDto;
import com.codegym.casestudy_springboot.model.customer.Customer;
import com.codegym.casestudy_springboot.service.ICustomerService;
import com.codegym.casestudy_springboot.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping()
    public String showList(@RequestParam(required = false, defaultValue = "") String name,
                           @RequestParam(required = false, defaultValue = "") String idCard,
                           @RequestParam(required = false, defaultValue = "0") int customerTypeId,
                           @RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 4, Sort.by("birthday").ascending());

        Page<Customer> pages = null;

        if (customerTypeId == 0) {
            pages = customerService.paginationByNameAndIdCard(name, idCard, pageable);
        } else {
            pages = customerService.paginationByNameAndIdCardAndCustomerType_Id(name, idCard, customerTypeId, pageable);
        }

        model.addAttribute("seachName", name);
        model.addAttribute("seachIdCard", idCard);
        model.addAttribute("seachCustomerTypeId", customerTypeId);
        model.addAttribute("customerEdit", new Customer());
        model.addAttribute("pages", pages);
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/list";
    }

    @GetMapping("/create")
    private String showCreateForm(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/save")
    private String saveCustomerNew(@Validated CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/customer";
    }



    @PostMapping("/edit")
    public String editCustomer(Customer customerEdit, RedirectAttributes redirectAttributes) {
        return "redirect:/customer";
    }
}
