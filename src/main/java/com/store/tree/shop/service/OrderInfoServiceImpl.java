package com.store.tree.shop.service;

import com.store.tree.shop.model.OrderInfo;
import com.store.tree.shop.repository.OrderInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    private OrderInfoRepository orderInfoRepository;

    public OrderInfoServiceImpl(OrderInfoRepository orderInfoRepository) {
        this.orderInfoRepository = orderInfoRepository;
    }

    @Override
    public List<OrderInfo> findAll() {
        return (List<OrderInfo>) orderInfoRepository.findAll();
    }
    @Override
    public List<OrderInfo> listAll(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return (List<OrderInfo>) orderInfoRepository.search(keyword);
        }
        return (List<OrderInfo>) orderInfoRepository.findAll();
    }

    @Override
    public OrderInfo findById(int theId) {
        Optional<OrderInfo> orderInfoId = orderInfoRepository.findById(theId);

        OrderInfo theOrderInfo = null;

        if (orderInfoId.isPresent()) {
            theOrderInfo = orderInfoId.get();
        } else {
            throw new RuntimeException("OrderInfoId not found");
        }
        return theOrderInfo;
    }

    @Override
    public void save(OrderInfo orderInfo) {
        orderInfoRepository.save(orderInfo);

    }

    @Override
    public void deleteById(int id) {
        orderInfoRepository.deleteById(id);
    }


}
