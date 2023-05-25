package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();
}
