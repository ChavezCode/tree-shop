package com.store.tree.shop.service;

import com.store.tree.shop.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();
    public List<Customer> listAll(String keyword);
    public Customer findByAddress(String Address);
    public void save(Customer customer);
//    public void deleteById(int id);
}
