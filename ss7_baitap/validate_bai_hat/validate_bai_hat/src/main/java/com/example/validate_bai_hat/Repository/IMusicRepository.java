package com.example.validate_bai_hat.Repository;

import com.example.validate_bai_hat.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
}
