package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog>  findAllByTitle(String title);

    @Query(value = "select s from Blog  s where category.nameCategory  like :category ")
    List<Blog> findCategory(String category);

//    @Query(value = "SELECT * FROM blog b WHERE b.category like :category", nativeQuery = true)
//    List<Blog> findCategory(String categoryName);
}
