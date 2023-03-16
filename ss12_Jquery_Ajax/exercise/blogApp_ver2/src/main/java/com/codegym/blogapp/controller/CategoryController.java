package com.codegym.blogapp.controller;

import com.codegym.blogapp.model.Category;
import com.codegym.blogapp.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("categories", iCategoryService.findAll());
        return "/category/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/save")
    public String saveCategoryNew(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/category";
    }

    @GetMapping("/edit")
    public String showCategoryEdit(@RequestParam int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "/category/edit";
    }

    @PostMapping("/update")
    public String updateCategory(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("success", "Chỉnh sửa thành công");
        return "redirect:/category";
    }

    @GetMapping("/delete")
    public String showDeteleForm(@RequestParam int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "/category/delete";
    }

    @PostMapping("/delete")
    public String deleteCategory(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/category";
    }
}
