package com.example.demo5.service;

import com.example.demo5.entity.Customer;
import com.example.demo5.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerJPAService implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAllOrderByName();
    }

    @Override
    public Customer findOne(Long id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        return null;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}