package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {



    @Autowired
    private ICustomerRepository customerRepository ;


    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer deleteId) {
        customerRepository.deleteById(deleteId);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findUser(String userName) {

        return customerRepository.findUser(userName);
    }

    @Override
    public Customer findUserPassword(String password) {
        return customerRepository.findUserPassword(password);
    }
}
