package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    void save(Blog blog);

    void delete(Integer deleteId );

    Blog findById(Integer id);

    void update(Blog blog);

    Page<Blog> getAllPage(int page);

    Page<Blog> search(String title, Pageable page);

    Page<Blog> findCategory(String categoryName,Pageable pageable );

}
