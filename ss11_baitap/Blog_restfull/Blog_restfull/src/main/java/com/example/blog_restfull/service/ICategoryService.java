package com.example.blog_restfull.service;

import com.example.blog_restfull.model.Blog;
import com.example.blog_restfull.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();

    void save(Category category);

    Category findById(Integer idCate);

    void update(Category category);

    void delete(Integer deleteId);


    List<Blog> findByCategoryName(String categoryName);
}
