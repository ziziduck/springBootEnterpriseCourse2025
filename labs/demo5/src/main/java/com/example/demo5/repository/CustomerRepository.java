package com.example.demo5.repository;

import com.example.demo5.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT x FROM Customer x ORDER BY x.lastName, x.firstName")
    List<Customer> findAllOrderByName();
}
