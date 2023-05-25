package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

        @Autowired
        private IBlogRepository blogRepository ;
    @Override
    public List<Blog> getAll() {
        return   blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Integer deleteId) {
        blogRepository.deleteById(deleteId);
    }

    @Override
    public Blog findById(Integer id) {
        Blog blog = blogRepository.findById(id).get();
        return blog;
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }
}
