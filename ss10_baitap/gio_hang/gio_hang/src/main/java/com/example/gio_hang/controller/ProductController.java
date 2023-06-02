package com.example.gio_hang.controller;

import com.example.gio_hang.model.Product;
import com.example.gio_hang.service.ICartService;
import com.example.gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICartService cartService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/index";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/views";
    }

    @ModelAttribute("cart")
    public Map<Product, Integer> innitCart() {
        return new LinkedHashMap<>();
    }

    @GetMapping("add-to-card/{id}")
    public String addToCard(@PathVariable("id") Integer id, @ModelAttribute("cart") Map<Product, Integer> cart) {
        Product product = productService.findById(id);

        if (!cartService.checkExist(product, cart)) {
            cart.put(product, 1);
        } else {

            Map.Entry<Product, Integer> productIntegerEntry = cartService.shoppingEntry(product, cart);
            cart.replace(productIntegerEntry.getKey(), productIntegerEntry.getValue() + 1);
        }

        return "redirect:/product";
    }


}
