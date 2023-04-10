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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                           @RequestParam(required = false, defaultValue = "") String customerTypeId,
                           @RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 4, Sort.by("birthday").ascending());

        model.addAttribute("pages", customerService.search("%" + name + "%", "%" + idCard + "%", "%" + customerTypeId + "%", pageable));
        model.addAttribute("seachName", name);
        model.addAttribute("seachIdCard", idCard);
        model.addAttribute("seachCustomerTypeId", customerTypeId);
        model.addAttribute("customerEdit", new Customer());
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

    @PostMapping("/create")
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

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam int id, Model model) {
        CustomerDto customerDto = new CustomerDto();
        Customer customer = customerService.findById(id);
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String saveCustomerEdit(@Validated CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Chỉnh sửa thành công");
        return "redirect:/customer";
    }
}
