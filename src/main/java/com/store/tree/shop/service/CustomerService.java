package com.store.tree.shop.service;

import com.store.tree.shop.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();
    public Customer findById(int id);
    public void save(Customer customer);
    public void deleteById(int id);
    public List<Customer> listAll(String keyword);
}
