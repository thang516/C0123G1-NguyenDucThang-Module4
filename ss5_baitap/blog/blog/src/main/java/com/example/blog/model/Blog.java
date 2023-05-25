package com.example.blog.model;


import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Blog {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NotNull
    private String title ;
    @Column(name="content",columnDefinition = "TEXT" , nullable = false)
    private String content ;
    @NotNull
    private String author ;


    @Column(name = "createTime", nullable = false,updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(name = "updateTime", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateTime;
    public Blog() {
    }

    public Blog(Integer id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Blog(String title, String content, String author, LocalDateTime createTime, LocalDateTime updateTime) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Blog(Integer id, String title, String content, String author, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
