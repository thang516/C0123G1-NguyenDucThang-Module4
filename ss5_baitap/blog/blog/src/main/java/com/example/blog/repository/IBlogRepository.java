package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog>  findAllByTitle(String title);

    List<Blog> findAllByCategory(Category category);


//   List<Blog> findAllByCategory (Category category);

//    @Query(value = "SELECT * FROM  blog AS b WHERE b.title LIKE :title ", nativeQuery = true)
//    List<Blog> search(@Param("title") String title);
}
