package com.example.customer.controller;

import com.example.customer.dto.CustomerDTO;
import com.example.customer.model.Customer;
import com.example.customer.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService ;

    @GetMapping()
    public String index(Model model){
        List<Customer> customerList = customerService.getAll();
        model.addAttribute("customerList",customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new CustomerDTO());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") CustomerDTO customerDTO, RedirectAttributes redirect){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customerService.save(customer);
        redirect.addFlashAttribute("mess","Add New Successfully");
        return "redirect:/customer";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("deleteId") Integer deleteId ,RedirectAttributes redirect ){
        customerService.delete(deleteId);
        redirect.addFlashAttribute("mess" , "Delete Successfully");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id , Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("customer") CustomerDTO customerDTO ,RedirectAttributes redirect){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customerService.update(customer);
        redirect.addFlashAttribute("mess","Update Successfully");
        return "redirect:/customer";
    }

    // ------> login
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("customer" , new Customer());
        return "/login";
    }
    @PostMapping("/customerLogin")
    public String loginUser(@ModelAttribute("customer") Customer customer , Model model){
        String userName = customer.getUserName();
        String password = customer.getPassword();
        Customer customer1 = customerService.findUser(userName);
        if(userName.equals(customer1.getUserName()) && password.equals(customer1.getPassword())){
            model.addAttribute("mess", "Login Successfully");
            return "redirect:/customer";
        }else{
            model.addAttribute("mess","login failed");
            return "/login";
        }

    }

}
