package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService ;

    @GetMapping("")
    public String index(@RequestParam(value = "page", defaultValue = "0") int page, Model model, HttpServletResponse response){
//        Page<Blog> blogList = blogService.getAllPage(page);
//        model.addAttribute("blogList",blogList);
////        model.addAttribute("mess", null);
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, private, o-age=0");
        return "list";
    }
    @GetMapping("/create")
    public  String create(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList",categoryService.getAll());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog ,@ModelAttribute Category category, RedirectAttributes redirect, Model model){
        blogService.save(blog);
        categoryService.save(category);
        model.addAttribute("flagUpdated", true);
        redirect.addFlashAttribute("mess","Add New Successfully");
        return "redirect:/blog";
    }
    @GetMapping("/delete")
    public  String delete(@RequestParam("deleteId") Integer deleteId, RedirectAttributes redirect){
        blogService.delete(deleteId);

        redirect.addFlashAttribute("mess","Delete Successfully");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id ,Model model, RedirectAttributes redirectAttributes ){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("categoryList",categoryService.getAll());
        return "/edit";
    }
    @PostMapping("/update")
    public  String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect){
        blogService.update(blog);
        redirect.addFlashAttribute("mess","Update  Successfully");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") Integer id ,Model model ){
        model.addAttribute("blog",blogService.findById(id));
        return "/view";
    }
    @PostMapping("/search")
    public  String search( @RequestParam(value = "page", defaultValue = "0")int  page,@RequestParam("title") String title, Model model){
        Pageable pageable = PageRequest.of(page,2);
      Page<Blog> blogList = blogService.search(title,pageable);
      model.addAttribute("blogList",blogList);
        return "/index";
    }


    @PostMapping("/findCategory")
    public  String findCategory( @RequestParam(value = "page", defaultValue = "0")int  page,@RequestParam("categoryName") String categoryName, Model model){
        Pageable pageable = PageRequest.of(page,2);
        Page<Blog> blogList = blogService.findCategory(categoryName,pageable);
        model.addAttribute("blogList",blogList);
        return "/index";
    }



}
