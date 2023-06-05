package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
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
