package com.example.bai2.service;

import com.example.bai2.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService{
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String translation(String englishWord) {
        return dictionaryRepository.translation(englishWord);
    }
}
