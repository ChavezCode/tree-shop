package com.store.tree.shop.dto;

import com.store.tree.shop.model.Customer;
import com.store.tree.shop.model.OrderInfo;

public class RegistrationWrapper {
    private Customer customer;
    private OrderInfo orderInfo;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
