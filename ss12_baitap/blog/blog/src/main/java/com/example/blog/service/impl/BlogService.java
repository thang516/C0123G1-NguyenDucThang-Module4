package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Override
    public Page<Blog> getAllPage(int page) {
        return blogRepository.findAll(PageRequest.of(page,3, Sort.by("createTime").descending()));
    }


    @Override
    public Page<Blog> search(String title,Pageable pageable) {

        return blogRepository.findAllByTitle(title,pageable);
    }



    @Override
    public Page<Blog> findCategory(String categoryName,Pageable pageable) {

        return blogRepository.findCategory(categoryName,pageable) ;
    }

    @Override
    public List<Blog> searchBlog(String title) {
        return blogRepository.searchBlog(title);
    }

    @Override
    public Slice<Blog> getAllSlice(Pageable page) {
        return blogRepository.findAll(page);
    }

//    @Override
//    public List<Blog> getAllSlice(Integer number) {
//        int numb = 0;
//        List<Blog> blogList = blogRepository.findAll();
//        List<Blog> blogs = new ArrayList<>();
//        for (int i = 0; i < blogList.size() && i<number*5; i++) {
//            if(i>=(number-1)*5){
//                blogs.add(numb,blogList.get(i));
//                numb++;
//            }
//        }
//        return blogs;
//    }
}
