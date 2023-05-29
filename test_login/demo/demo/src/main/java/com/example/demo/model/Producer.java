package com.example.demo.model;




import javax.persistence.*;

@Entity

public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT", unique = true)
    private String producerName;

    public Producer() {
    }

    public Producer(Integer id, String producerName) {
        this.id = id;
        this.producerName = producerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
}
