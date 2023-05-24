package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService ;


    @GetMapping("")
    public String index(Model model ){
       List<Product> productList = productService.getAll();
       model.addAttribute("productList",productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute Product product , RedirectAttributes redirect ){

        productService.save(product);
        redirect.addFlashAttribute("mess","Thêm mới thành công ");
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id")Integer id ,RedirectAttributes request){
                productService.delete(id);
            request.addFlashAttribute("messa","Xóa Thành CÔng ");
            return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id , Model model ){
    model.addAttribute("product",productService.findById(id));
    return "/edit";
    }
    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product";
    }

}
