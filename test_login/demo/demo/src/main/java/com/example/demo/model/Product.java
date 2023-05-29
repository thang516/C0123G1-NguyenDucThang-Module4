package com.example.demo.model;


import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id  ;
    @NotNull
    private String name ;
    @NotNull
    private Double price ;
    @NotNull
    private String description;

    @Column(name = "create_time" , updatable = false,nullable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private  LocalDateTime createTime;

    @Column(name = "update_time" , updatable = false,nullable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateTime ;

    @ManyToOne
    @JoinColumn
    private Producer producer ;
    public Product(String name, Double price, String description, LocalDateTime createTime, LocalDateTime updateTime, Producer producer) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.producer = producer;
    }



    public Product(Integer id, String name, Double price, String description, LocalDateTime createTime, LocalDateTime updateTime, Producer producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.producer = producer;
    }

    public Product(Integer id, String name, Double price, String description, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Product() {
    }

    public Product(String name, Double price, String description, LocalDateTime createTime, LocalDateTime updateTime) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Product(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
