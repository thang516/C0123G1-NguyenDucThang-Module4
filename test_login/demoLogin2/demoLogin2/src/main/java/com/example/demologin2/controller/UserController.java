package com.example.demologin2.controller;

import com.example.demologin2.model.User;
import com.example.demologin2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String login(Model model ){
        User user = new User();
        model.addAttribute("user",user);
        return "/login";
    }

    @PostMapping("/userLogin")
    public String LoginUser(@ModelAttribute("user") User user,Model model ) {
        String userName = user.getUserName();
        User user1 = userService.findUser(userName);
        if (user.getPass().equals(user1.getPass())) {
            model.addAttribute("mess","Đăng nhập thành công");
            return "/home";
        } else {
            model.addAttribute("mess","Đăng nhập thật bại ");

            return "/error" ;
        }
    }

}
