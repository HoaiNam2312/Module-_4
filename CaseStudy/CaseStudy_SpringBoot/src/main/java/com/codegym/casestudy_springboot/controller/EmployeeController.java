package com.codegym.casestudy_springboot.controller;

import com.codegym.casestudy_springboot.dto.EmployeeDto;
import com.codegym.casestudy_springboot.model.employee.Employee;
import com.codegym.casestudy_springboot.service.IDivisionService;
import com.codegym.casestudy_springboot.service.IEducationDegreeService;
import com.codegym.casestudy_springboot.service.IEmployeeService;
import com.codegym.casestudy_springboot.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IEducationDegreeService educationDegreeService;

    @GetMapping()
    public String showList(@RequestParam(required = false, defaultValue = "") String idCard,
                           @RequestParam(required = false, defaultValue = "") String divisionId,
                           @RequestParam(required = false, defaultValue = "") String positionId,
                           @RequestParam(required = false, defaultValue = "") String educationDegreeId,
                           @RequestParam(defaultValue = "0") int page,
                           Model model) {
        PageRequest pageable = PageRequest.of(page, 4, Sort.by("name").descending());
        model.addAttribute("pages", employeeService.search(idCard, divisionId, positionId, educationDegreeId, pageable));
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("idCard", idCard);
        model.addAttribute("divisionID", divisionId);
        model.addAttribute("positionId", positionId);
        model.addAttribute("educationDegreeId", educationDegreeId);
        return "employee/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String saveEmployeeNew(@Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam int id, RedirectAttributes redirectAttributes) {
        employeeService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/employee";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        Employee employee = employeeService.findById(id);
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String updateEmployee(@Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            return "/employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Chỉnh sửa thành công");
        return "redirect:/employee";
    }
}
