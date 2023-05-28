package com.example.dangky.controller;

import com.example.dangky.model.User;
import com.example.dangky.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;


     @GetMapping("")
    public String index(Model model ){
        List<User> userList = userService.getAll();
        model.addAttribute("userList",userList);
        return "/index";
    }

    @GetMapping("/create")
    public  String create(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("userList",userService.getAll());
        return "/sign";
    }

    @PostMapping("/save")
    public  String save( Model model ,  @ModelAttribute("user") User user){
        String result = null ;
        if(user.getPass().equals(user.getConfirmPass())){
            try {
                userService.save(user);
                result = "redirect:/home";

            }catch (Exception e){
                result = "/error";
            }
        }


        return result;
    }
}
