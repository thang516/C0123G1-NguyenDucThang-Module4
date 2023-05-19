package com.example.bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {



    @GetMapping("/")
    public  String display(){

            return "index";
    }
    @PostMapping("/")
    public String display(@RequestParam(value = "lettuce",defaultValue = "")String  lettuce ,
                          @RequestParam(value ="tomato",defaultValue = "") String tomato,
                          @RequestParam(value ="mustard",defaultValue = "") String mustard,
                          @RequestParam(value ="sprouts",defaultValue = "") String sprouts ,
                          Model model){
//        com.example.bai1.model.SandwichCondimentsController condimentsController = new com.example.bai1.model.SandwichCondimentsController(lettuce,tomato,mustard,sprouts);
        if(!lettuce.equals("")){
            model.addAttribute("lettuce",lettuce);
        }
        if(!tomato.equals("")){
            model.addAttribute("tomato",tomato);
        }
        if(!mustard.equals("")){
            model.addAttribute("mustard",mustard);
        }
        if(!sprouts.equals("")){
            model.addAttribute("sprouts",sprouts);
        }
                         return "index";
    }
}
