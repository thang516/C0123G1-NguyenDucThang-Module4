package com.example.blog_restfull.controller;

import com.example.blog_restfull.model.Blog;
import com.example.blog_restfull.model.Category;
import com.example.blog_restfull.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class RESTCategoryController {

    @Autowired
    private ICategoryService categoryService ;

    @GetMapping("")
    public ResponseEntity<List<Category>> getList(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Blog>> findCategory (@PathVariable("categoryName") String categoryName){
        List<Blog> blogs = categoryService.findByCategoryName( '%'+categoryName + '%');
        return new ResponseEntity<>( blogs,HttpStatus.OK);
    }



}
