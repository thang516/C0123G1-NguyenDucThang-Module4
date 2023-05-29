package com.example.validate_bai_hat.service;

import com.example.validate_bai_hat.Repository.IMusicRepository;
import com.example.validate_bai_hat.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findAll(Integer id) {


        return musicRepository.findById(id).get();
    }

    @Override
    public void update(Music music) {
        musicRepository.save(music);
    }
}
