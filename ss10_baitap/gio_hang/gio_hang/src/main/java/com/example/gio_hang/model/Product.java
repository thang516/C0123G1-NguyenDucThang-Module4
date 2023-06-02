package com.example.gio_hang.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @NotNull
    @Column(unique = true)
    private Integer productCode ;
    @NotNull
    private  String name ;
    @NotNull
    private  Double price;
    @NotNull
    private String description ;
    private String img;
    public Product() {
    }

    public Product(Integer id, Integer productCode, String name, Double price, String description , String img) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.description = description;
        this.img = img;
    }

    public Product(Integer productCode, String name, Double price, String description, String img) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.description = description;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
