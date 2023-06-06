package com.example.demo.controller;

import com.example.demo.model.Clazz;
import com.example.demo.model.Student;
import com.example.demo.service.IClazzService;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClazzService clazzService;

   @GetMapping("")
    public String index(Model model){
       List<Student> studentList = iStudentService.findAll();
       model.addAttribute("studentList",studentList);
       return "/index";
   }

   @GetMapping("/create")
    public String create(Model model){
       model.addAttribute("student" ,new Student());
       model.addAttribute("classList",clazzService.findAll());
       return "/create";
   }

    //
//    @GetMapping("")
//    public String index(Model model) {
//        List<Student> studentList = iStudentService.findAll();
//        model.addAttribute("studentList", studentList);
//        return "/index";
//    }
//
//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("student", new Student());
//        model.addAttribute("clazzList", clazzService.findAll());
//        return "/create";
//    }
//
//    @PostMapping("/save")
//    public String create(@Validated @ModelAttribute("student") Student student, @ModelAttribute("clazz") Clazz clazz, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//
//        if (bindingResult.hasErrors()) {
//            return "/create";
//        }
//
//        iStudentService.save(student);
//        clazzService.save(clazz);
//        redirectAttributes.addFlashAttribute("mess", "theem mowis thanh cong");
//        return "redirect:/student";
//    }
//
//    @GetMapping("/delete")
//    public String delete(@RequestParam("id") Integer id , RedirectAttributes redirectAttributes){
//        iStudentService.delete(id);
//        redirectAttributes.addFlashAttribute("mess","xóa thành công ");
//        return "redirect:/student";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable("id") Integer id ,Model model){
//
//        model.addAttribute("student",    iStudentService.findById(id));
//        model.addAttribute("clazzList",clazzService.findAll());
//    return "/edit";
//    }
//    @PostMapping("/update")
//    public String update(@ModelAttribute("student")Student student , RedirectAttributes redirectAttributes){
//        iStudentService.update(student);
//        redirectAttributes.addFlashAttribute("mess","cập nhật thành công");
//        return "redirect:/student";
//    }

}
