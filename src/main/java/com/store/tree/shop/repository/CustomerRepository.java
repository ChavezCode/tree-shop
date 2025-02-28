package com.store.tree.shop.repository;

import com.store.tree.shop.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository <Customer, String> {
    @Query("SELECT p FROM Customer p WHERE p.address LIKE %?1%")
    public List<Customer> search(String keyword);

    Optional<Customer> findByAddress(String theAddress);
}
