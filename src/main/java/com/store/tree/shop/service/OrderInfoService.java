package com.store.tree.shop.service;

import com.store.tree.shop.model.OrderInfo;

import java.util.List;

public interface OrderInfoService {
    public List<OrderInfo> findAll();
    public List<OrderInfo> listAll(String keyword);
    public OrderInfo findById(int id);
    public void save(OrderInfo orderInfo);
    public void deleteById(int id);
}
