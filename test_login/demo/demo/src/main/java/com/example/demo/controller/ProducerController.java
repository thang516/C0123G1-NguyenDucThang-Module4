package com.example.demo.controller;

import com.example.demo.model.Producer;
import com.example.demo.model.Product;
import com.example.demo.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private IProducerService producerService;
    @GetMapping("")
    public String index(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        Page<Producer> producerList = producerService.getAllPage(page);
        model.addAttribute("producerList",producerList);
        return "/producer";
    }

}
