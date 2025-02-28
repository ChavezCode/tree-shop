package com.store.tree.shop.service;

import com.store.tree.shop.model.Customer;
import com.store.tree.shop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public List<Customer> listAll(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return (List<Customer>) customerRepository.search(keyword);
        }
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findByAddress(String theAddress) {
        Optional<Customer> customerAddress = customerRepository.findByAddress(theAddress);

        Customer theCustomer=null;

        if (customerAddress.isPresent()) {
            theCustomer=customerAddress.get();
        }
        else {
            throw new RuntimeException("Customer not found");
        }
        return theCustomer;

    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }
//
//    @Override
//    public void deleteById(int id) {
//        customerRepository.deleteById(id);
//    }
}
