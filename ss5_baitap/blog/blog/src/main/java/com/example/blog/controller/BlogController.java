package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String index(Model model){
        List<Blog> blogList = blogService.getAll();
        model.addAttribute("blogList",blogList);
        return "/index";
    }
    @GetMapping("/create")
    public  String create(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog , RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("mess","Add New Successfully");
        return "redirect:/blog";
    }
    @GetMapping("/delete")
    public  String delete(@RequestParam("deleteId") Integer deleteId){
        blogService.delete(deleteId);
        return "redirect:/blog";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id ,Model model ){
        model.addAttribute("blog",blogService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public  String update(@ModelAttribute("blog") Blog blog){
        blogService.update(blog);
        return "redirect:/blog";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") Integer id ,Model model ){
        model.addAttribute("blog",blogService.findById(id));
        return "/view";
    }

}
