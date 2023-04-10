package com.codegym.thi.controller;

import com.codegym.thi.dto.MotelDto;
import com.codegym.thi.dto.ProductDto;
import com.codegym.thi.model.Motel;
import com.codegym.thi.model.Product;
import com.codegym.thi.service.IProductService;
import com.codegym.thi.service.IProductTypeService;
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
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductTypeService productTypeService;
    @Autowired
    IProductService productService;

    @GetMapping()
    public String showList(@RequestParam(required = false, defaultValue = "") String name,
                           @RequestParam(required = false, defaultValue = "") String price,
                           @RequestParam(required = false, defaultValue = "") String productTypeId,
                           @RequestParam(defaultValue = "0") int page,
                           Model model) {

        Pageable pageable = PageRequest.of(page, 5, Sort.by("id").ascending());

        model.addAttribute("pages", productService.search(name, price, productTypeId, pageable));
        model.addAttribute("productTypeList", productTypeService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("productTypeId", productTypeId);
        return "/product/list";
    }

    @GetMapping("/deletes")
    public String deleteProducts(@RequestParam String idChecked, RedirectAttributes redirectAttributes) {
        String[] idDeletes = idChecked.split(",");
        for (String tmp : idDeletes) {
            int id = Integer.parseInt(tmp);
            productService.deleteById(id);
        }
        redirectAttributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/product";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("productTypeList", productTypeService.findAll());
        return "/product/create";
    }

    @PostMapping("/create")
    public String saveNewProduct(@Validated ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("productTypeList", productTypeService.findAll());
            return "/product/create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam int id, Model model) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productService.findById(id), productDto);
        model.addAttribute("productDto", productDto);
        model.addAttribute("productTypeList", productTypeService.findAll());
        return "/product/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@Validated ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("productTypeList", productTypeService.findAll());
            return "/product/edit";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Chỉnh sửa thành công");
        return "redirect:/product";
    }
}
