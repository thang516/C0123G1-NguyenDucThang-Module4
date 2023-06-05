package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService ;

    @GetMapping("")
    public String index(Model model){
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        return "/category";
    }
    @GetMapping("/create")
    public  String create( @ModelAttribute("category") Category category){
        return "/create-category";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("mess","Add New Successfully");
        return "redirect:/category";
    }
    @GetMapping("/delete")
    public  String delete(@RequestParam("deleteId") Integer deleteId, RedirectAttributes redirect){
        categoryService.delete(deleteId);
        redirect.addFlashAttribute("mess","Delete Successfully");
        return "redirect:/category";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id , Model model ){
        model.addAttribute("category",categoryService.findById(id));
        return "/edit-category";
    }
    @PostMapping("/update")
    public  String update(@ModelAttribute("category") Category category , RedirectAttributes redirect){
        categoryService.update(category);
        redirect.addFlashAttribute("mess","Update  Successfully");
        return "redirect:/category";
    }


}
