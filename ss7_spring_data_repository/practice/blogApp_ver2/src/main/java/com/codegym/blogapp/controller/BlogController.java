package com.codegym.blogapp.controller;

import com.codegym.blogapp.model.Blog;
import com.codegym.blogapp.service.blog.IBlogService;
import com.codegym.blogapp.service.category.ICategoryService;
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

import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(required = false,defaultValue = "") String searchName,
                           @RequestParam(required = false,defaultValue = "0") int searchCategory,
                           @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("postTime").descending());

        Page<Blog> pages = null;
        if (searchName.equals("") && searchCategory == 0) {
            pages = iBlogService.search(searchName, pageable);
        } else if (searchName.equals("")) {
            pages = iBlogService.searchCategory(searchCategory, pageable);
        } else {
            pages = iBlogService.searchNameAnhCategory(searchName, searchCategory, pageable);
        }
        model.addAttribute("pages", pages);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchCategory", searchCategory);
        model.addAttribute("categories", iCategoryService.findAll());
        return "/blog/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", iCategoryService.findAll());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String saveBlogNew(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categories", iCategoryService.findAll());

        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("success", "xóa thành công");
        return "redirect:/blog";
    }

    @GetMapping("/view")
    public String showDetail(@RequestParam int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/view";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categories", iCategoryService.findAll());
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "Chỉnh sửa thành công");
        return "redirect:/blog";
    }
}
