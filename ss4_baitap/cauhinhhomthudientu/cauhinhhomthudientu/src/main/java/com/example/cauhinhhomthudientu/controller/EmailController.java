package com.example.cauhinhhomthudientu.controller;

import com.example.cauhinhhomthudientu.model.Email;
import com.example.cauhinhhomthudientu.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @GetMapping("/email")
    public String home(Model model) {
        Email email = emailService.getAll();
        model.addAttribute("email", email);
        return "index";

    }

    @PostMapping("/email/update")
    public String update(@ModelAttribute("email") Email email, Model model) {

        emailService.update(email);
        String mess = "update successfully";
        model.addAttribute("mess", mess);
        return "index";
    }
}
