package com.store.tree.shop.repository;

import com.store.tree.shop.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository <Customer, Integer> {
    @Query("SELECT p FROM Customer p WHERE p.customerName LIKE %?1%")
    public List<Customer> search(String keyword);
}
