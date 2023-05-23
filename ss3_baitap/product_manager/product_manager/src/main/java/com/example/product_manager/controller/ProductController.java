package com.example.product_manager.controller;

import com.example.product_manager.model.Product;
import com.example.product_manager.service.IProductService;
import com.example.product_manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("success", "Save Product Successfully");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@ModelAttribute Product product, RedirectAttributes redirect) {
        productService.delete(product.getId());
        redirect.addFlashAttribute("success", "Removed Product Successfully");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Product> productList = productService.search(name);
        model.addAttribute("productList", productList);
        return "/index";
    }
}
