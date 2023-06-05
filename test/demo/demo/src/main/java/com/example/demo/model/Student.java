package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    @Size(max = 100, message = "Giới hạn là 100")
    private String name;
    @Column(nullable = false, columnDefinition = "DOUBLE")
    @Min(value = 0, message = "Điểm nhỏ nhất là 0 ")
    @Max(value = 10, message = "Điểm lớn nhất là 10 ")
    private Double point;

    private Integer gender;

    @ManyToOne
    @JoinColumn
    private Clazz clazz;

    public Student(Integer id, String name, Double point, Integer gender, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.gender = gender;
        this.clazz = clazz;
    }

    public Student(String name, Double point, Integer gender, Clazz clazz) {
        this.name = name;
        this.point = point;
        this.gender = gender;
        this.clazz = clazz;
    }

    public Student() {
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

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
