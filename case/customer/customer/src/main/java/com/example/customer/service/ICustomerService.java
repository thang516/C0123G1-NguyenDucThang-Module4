package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();

    void save(Customer customer);

    void delete(Integer deleteId);

    Customer findById(Integer id);

    void update(Customer customer);

    Customer findUser(String userName);

    Customer findUserPassword(String password);
}
