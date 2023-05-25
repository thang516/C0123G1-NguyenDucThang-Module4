package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    void save(Blog blog);

    void delete(Integer deleteId );

    Blog findById(Integer id);

    void update(Blog blog);
}
