package com.example.blog_restfull.service.impl;

import com.example.blog_restfull.model.Blog;
import com.example.blog_restfull.model.Category;
import com.example.blog_restfull.repository.ICategoryRepository;
import com.example.blog_restfull.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private   ICategoryRepository categoryRepository;




    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
         categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer idCate) {
        return categoryRepository.findById(idCate).get();
    }



    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer deleteId) {
        categoryRepository.delete(findById(deleteId));
    }

    @Override
    public List<Blog> findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }



}
