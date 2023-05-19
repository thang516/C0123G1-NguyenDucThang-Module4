package com.example.bai2.controller;

import com.example.bai2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/")
    public  String lookupDictionary(){

        return "form";
    }

    @PostMapping("/")
    public String wordLookup(Model model, @RequestParam(value = "englishWord") String englishWord){
       String result = dictionaryService.translation(englishWord);
        model.addAttribute("result",result);
        return "form";
    }

}
