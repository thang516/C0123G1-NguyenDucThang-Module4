package com.example.databinding.controller;

import com.example.databinding.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping
    public String index(Model model){
        model.addAttribute("user", new User());
        return "create";
    }


    @PostMapping("/create-user")
    public String createUser(Model model, @ModelAttribute User user){
            model.addAttribute("user",user);

        return "index";
    }

}
