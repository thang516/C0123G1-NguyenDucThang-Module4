package com.example.validate_bai_hat.service;

import com.example.validate_bai_hat.dto.MusicDTO;
import com.example.validate_bai_hat.model.Music;

import java.util.List;

public interface IMusicService {


    void save(Music music);

    List<Music> findAll();

    Music findAll(Integer id);

    void update(Music music);
}
