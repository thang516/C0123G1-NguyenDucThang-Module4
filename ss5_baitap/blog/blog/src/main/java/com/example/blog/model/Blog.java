package com.example.blog.model;


import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

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

    @NotNull
    private  String dateOfWriting ;

    public Blog() {
    }

    public Blog(Integer id, String title, String content, String author, String dateOfWriting) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateOfWriting = dateOfWriting;
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

    public String getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(String dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }
}
