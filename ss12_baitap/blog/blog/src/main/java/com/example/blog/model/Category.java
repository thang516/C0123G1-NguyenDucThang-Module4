package com.example.blog.model;


import com.sun.istack.NotNull;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name="category")
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "status=false")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name = "name_category",columnDefinition = "TEXT", unique = true)
    @NotNull
    private String nameCategory ;

    private  Boolean status =false;



    public Category() {
    }

    public Category(Integer id, String nameCategory,Boolean status) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.status = status;
    }


    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
