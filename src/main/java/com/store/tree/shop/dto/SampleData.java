package com.store.tree.shop.dto;

import com.store.tree.shop.model.Customer;
import com.store.tree.shop.model.OrderInfo;
import com.store.tree.shop.repository.CustomerRepository;

import com.store.tree.shop.repository.OrderInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SampleData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final OrderInfoRepository orderInfoRepository;


    public SampleData(CustomerRepository customerRepository, OrderInfoRepository orderInfoRepository) {
        this.customerRepository = customerRepository;
        this.orderInfoRepository = orderInfoRepository;

    }
    @Override
    public void run(String... args) throws Exception {

        //if statement to prevent the db from duplicating everytime it runs
        if (customerRepository.count() == 0) {

            //create a customer
            Customer customer = new Customer();
            customer.setCustomerName("Jorge");
            customer.setAddress("123 Main St");
            customer.setEmail("jorge@gmail.com");
            customer.setPhoneNumber("+49 55 55 55");
            customerRepository.save(customer);
        }

            if (orderInfoRepository.count() == 0) {
                //create a tree
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setTreeInv(1);
                orderInfo.setTreeName("douglas");

                // Link the OrderInfo with the Customer

                orderInfoRepository.save(orderInfo);
            }
            List <OrderInfo> orderInfos = (List<OrderInfo>) orderInfoRepository.findAll();
            for (OrderInfo orderInfo : orderInfos) {
                System.out.println(orderInfo.getTreeName());
            }

        }


}
