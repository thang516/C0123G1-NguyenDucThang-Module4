package com.example.validate_form_sign.controller;

import com.example.validate_form_sign.dto.UserDTO;
import com.example.validate_form_sign.model.User;
import com.example.validate_form_sign.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String index(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new UserDTO());
        return "/sign";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirect) {
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/sign";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.save(user);
        redirect.addFlashAttribute("mess", "thêm mới thành công ");
        return "redirect:/user";
    }


}
