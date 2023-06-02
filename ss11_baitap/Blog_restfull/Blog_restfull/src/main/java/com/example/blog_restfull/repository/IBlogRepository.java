package com.example.blog_restfull.repository;

import com.example.blog_restfull.model.Blog;
import com.example.blog_restfull.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value = "select s from Blog  s where s.title  like :title ")
    Page<Blog> findAllByTitle(String title , Pageable pageable);
    @Query(value = "select s from Blog  s where category.nameCategory  like :category ")
    Page<Blog> findCategory(String category,Pageable pageable);

//    @Query(value = "SELECT * FROM blog b WHERE b.category like :category", nativeQuery = true)
//    List<Blog> findCategory(String categoryName);
}
