package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer , Integer> {

    @Query(value = "SELECT u FROM Customer  u WHERE u.userName LIKE :userName")
    Customer findUser(String userName);

    @Query(value = "SELECT u FROM Customer u WHERE u.password LIKE :password")
    Customer findUserPassword(String password);
}
