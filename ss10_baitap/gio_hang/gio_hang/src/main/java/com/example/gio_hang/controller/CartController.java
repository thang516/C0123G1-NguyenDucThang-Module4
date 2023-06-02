package com.example.gio_hang.controller;

import com.example.gio_hang.model.Product;
import com.example.gio_hang.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @GetMapping("/cart")
    public String cart(@SessionAttribute("cart") Map<Product, Integer> cart, Model model) {
        model.addAttribute("cart", cart);

        model.addAttribute("total", cartService.getTotal(cart));
        return "shopping-cart";
    }


}
