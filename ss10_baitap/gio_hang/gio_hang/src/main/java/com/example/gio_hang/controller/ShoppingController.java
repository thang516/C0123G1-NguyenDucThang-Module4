package com.example.gio_hang.controller;

import com.example.gio_hang.model.Shopping;
import com.example.gio_hang.service.ICartService;
import com.example.gio_hang.service.IShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopping")
@SessionAttributes("cart")
public class ShoppingController {

    @Autowired
    private IShoppingService shoppingService;
    @Autowired
    private ICartService cartService;

    @GetMapping("")
    public String index(Model model) {
        List<Shopping> shoppingList = shoppingService.findAll();
        model.addAttribute("shoppingList", shoppingList);
        return "/index";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Shopping shopping = shoppingService.findById(id);
        model.addAttribute("shopping", shopping);
        return "/views";
    }

    @ModelAttribute("cart")
    public Map<Shopping, Integer> innitCart() {
        return new LinkedHashMap<>();
    }

    @GetMapping("add-to-card/{id}")
    public String addToCard(@PathVariable("id") Integer id, @ModelAttribute("cart") Map<Shopping, Integer> cart) {
        Shopping shopping1 = shoppingService.findById(id);

        if (!cartService.checkExist(shopping1, cart)) {
            cart.put(shopping1, 1);
        } else {

            Map.Entry<Shopping, Integer> shoppingIntegerMap = cartService.shoppingEntry(shopping1, cart);
            cart.replace(shoppingIntegerMap.getKey(), shoppingIntegerMap.getValue() + 1);
        }

        return "redirect:/shopping";
    }


}
