package com.example.validate_bai_hat.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class MusicDTO implements Validator {


    private Integer id ;

    @Size(max = 800 ,message = "Tên bài nhạc không được quá 800 ký tự  ")
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[A-Za-z0-9 ]{1,800}$" , message = "Tên bài hát  Không được chứa kí tự đặc biệt")
    private String  name;
    @Size(max = 300 ,message = " Tên Nghệ sĩ không được quá 300 ký tự  ")
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[A-Za-z0-9 ]{1,300}$" , message = "Tên nghệ sĩ  Không được chứa kí tự đặc biệt")
    private String artis;
    @Size(max = 1000 ,message = " Thể loại nhạc  không được quá 1000 ký tự  ")
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[A-Za-z0-9, ]{1,1000}$" , message = "Thể loại nhạc  Không được chứa kí tự đặc biệt và dấu phẩy")
    private String kindOfMusic;

    public MusicDTO(Integer id, String name, String artis, String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.artis = artis;
        this.kindOfMusic = kindOfMusic;
    }

    public MusicDTO(String name, String artis, String kindOfMusic) {
        this.name = name;
        this.artis = artis;
        this.kindOfMusic = kindOfMusic;
    }

    public MusicDTO() {
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



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDTO musicDTO = (MusicDTO) target;
        String regex = "^[A-Za-z0-9 ]{1,800}$";

        if(!musicDTO.name.matches(regex)){
            errors.rejectValue("name" , "","tên bài hát không hợp lệ");
        }

    }
}
