package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blog")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getList() {
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/loadMore")
    public ResponseEntity<List<Blog>> getList(@RequestParam("number") Integer number) {
        List<Blog> blogSlice = blogService.getAllSlice(number);
        return new ResponseEntity<>(blogSlice, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> detail(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }


        @GetMapping("/search")
        public ResponseEntity<List<Blog>>  search(@RequestParam("title") String title){
            List<Blog> blogs = blogService.searchBlog('%'+title+'%');
            return new  ResponseEntity<> (blogs,HttpStatus.OK) ;
        }






    }
