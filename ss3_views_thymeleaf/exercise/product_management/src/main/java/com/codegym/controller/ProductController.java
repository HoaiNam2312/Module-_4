package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductSer iProductSer;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("productList", iProductSer.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 10000));
        iProductSer.save(product);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductSer.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        iProductSer.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Cập nhập thành công");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iProductSer.remove(id);
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/product";
    }

    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductSer.findById(id));
        return "view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String nameCheck,Model model) {
        List<Product> productList = iProductSer.findByName(nameCheck);
        model.addAttribute("productList", productList);
        return "list";
    }
}
