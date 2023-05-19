package com.example.bai2.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class DictionaryRepository implements IDictionaryRepository{
    static  Map<String,String> listWord = new HashMap<>();
    static {
        listWord.put("hello","xin chào");
        listWord.put("tree","cây");
        listWord.put("ask","hỏi");
        listWord.put("be","là");
        listWord.put("become","trở nên");
        listWord.put("begin","bắt đầu");
        listWord.put("call","gọi");
        listWord.put("can","có thể");
        listWord.put("come","đến");
        listWord.put("could","có thể");
        listWord.put("do","làm");
        listWord.put("feel","cảm thấy");
        listWord.put("find","tìm kiếm");
        listWord.put("get","lấy");
        listWord.put("give","đưa");
        listWord.put("go","đến");
        listWord.put("have","có");
        listWord.put("hear","nghe");
        listWord.put("help","giúp");
        listWord.put("keep","giữ");
        listWord.put("know","biết");
        listWord.put("leave","rời");
        listWord.put("let","đi");
        listWord.put("like","thích");
        listWord.put("live","sống");
        listWord.put("look","tìm");

    }


    @Override
    public String translation(String englishWord) {
                 if ((listWord.get( englishWord ))!=null){
                     return listWord.get( englishWord);
                 }else {
                     return "Không tìm thấy";
                 }
    }
}
