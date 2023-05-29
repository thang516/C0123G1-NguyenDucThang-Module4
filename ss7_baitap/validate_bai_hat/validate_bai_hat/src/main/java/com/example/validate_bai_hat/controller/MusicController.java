package com.example.validate_bai_hat.controller;

import com.example.validate_bai_hat.dto.MusicDTO;
import com.example.validate_bai_hat.model.Music;
import com.example.validate_bai_hat.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String index(Model model){
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList",musicList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("music", new MusicDTO());
        return "/sign";
    }

    @PostMapping("/save")
    public  String save(@Validated @ModelAttribute("music") MusicDTO musicDTO , BindingResult bindingResult, RedirectAttributes redirect ){
        new MusicDTO().validate(musicDTO,bindingResult);
        if(bindingResult.hasErrors()){
            return "/sign";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO,music);
        musicService.save(music);
        redirect.addFlashAttribute("mess","thêm mới thành công ");
        return "redirect:/music";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")Integer id ,Model model){
        model.addAttribute("music",musicService.findAll(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("music") MusicDTO musicDTO,Model model){
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO,music);
        musicService.save(music);
        musicService.update(music);

        model.addAttribute("mess","Cập nhập thành công");

        return "redirect:/music";
    }

}
