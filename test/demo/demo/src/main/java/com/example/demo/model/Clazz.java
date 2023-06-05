package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100,message = "100 max")

    private String nameClazz ;

    public Clazz(Integer id, String nameClazz) {
        this.id = id;
        this.nameClazz = nameClazz;
    }

    public Clazz(String nameClazz) {
        this.nameClazz = nameClazz;
    }

    public Clazz() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameClazz() {
        return nameClazz;
    }

    public void setNameClazz(String nameClazz) {
        this.nameClazz = nameClazz;
    }
}
