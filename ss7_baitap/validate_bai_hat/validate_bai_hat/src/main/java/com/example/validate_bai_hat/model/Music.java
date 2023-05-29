package com.example.validate_bai_hat.model;




import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotNull
    private String  name;
    @NotNull
    private String artis;
    @NotNull
    private String kindOfMusic;

    public Music(Integer id, String name, String artis, String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.artis = artis;
        this.kindOfMusic = kindOfMusic;
    }

    public Music(String name, String artis, String kindOfMusic) {
        this.name = name;
        this.artis = artis;
        this.kindOfMusic = kindOfMusic;
    }

    public Music() {
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

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
