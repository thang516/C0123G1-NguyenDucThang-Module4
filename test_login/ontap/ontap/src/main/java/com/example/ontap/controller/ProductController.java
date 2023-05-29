package com.example.ontap.controller;


import com.example.ontap.model.Product;
import com.example.ontap.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private IProductService productService ;


    @GetMapping("")
    public String index(@RequestParam(value = "page",defaultValue = "0") int page   ,  Model model){
        Page<Product> productList = productService.getAllPage(page);
        model.addAttribute("productList",productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("product")Product product , RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("mess","thêm mới thành công ");
        return "redirect:/product";
    }
    

    @GetMapping("/delete")
    public String delete(@RequestParam("deleteId") Integer deleteId,RedirectAttributes redirect){
        productService.delete(deleteId);
        redirect.addFlashAttribute("mess" , "xóa thành công ");
        return "redirect:/product";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") Integer id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("product")Product product ,RedirectAttributes redirect){
        productService.update(product);
        redirect.addFlashAttribute("mess" ,"cập nhật thành công ");
        return "redirect:/product";
    }
    @PostMapping("/search")
    public String search(Model model ,@RequestParam(value = "page",defaultValue = "0") int page , @ModelAttribute ("name")String name ){
        Pageable pageable = PageRequest.of(page,2);
        Page<Product> products = productService.search(name,pageable);
        model.addAttribute("productList" ,products);
        return "/index";
    }

}
