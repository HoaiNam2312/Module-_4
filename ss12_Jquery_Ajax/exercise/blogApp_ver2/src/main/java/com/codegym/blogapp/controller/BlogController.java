package com.codegym.blogapp.controller;

import com.codegym.blogapp.model.Blog;
import com.codegym.blogapp.service.blog.IBlogService;
import com.codegym.blogapp.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService iCategoryService;

    private int row = 2;
    
    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("blogList", blogService.findAll(row));
        return "/blog/list";
    }

    @GetMapping("/search/{nameBlog}")
    public String searchBlog(@PathVariable String nameBlog, Model model) {
        if (nameBlog.equals("")) {
            model.addAttribute("blogList", blogService.findAll(row));
            return "/blog/search";
        }
        model.addAttribute("blogList", blogService.findByNameContaining(nameBlog));
        return "/blog/search";
    }

    @GetMapping("/more")
    public String moreBlog(Model model) {
        row += 2;
        model.addAttribute("blogList", blogService.findAll(row));
        return "/blog/more";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", iCategoryService.findAll());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String saveBlogNew(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", iCategoryService.findAll());
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/blog";
    }

    @GetMapping("/view")
    public String showDetail(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/view";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", iCategoryService.findAll());
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "Chỉnh sửa thành công");
        return "redirect:/blog";
    }
}
