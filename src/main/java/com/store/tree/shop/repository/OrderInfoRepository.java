package com.store.tree.shop.repository;

import com.store.tree.shop.model.OrderInfo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrderInfoRepository extends CrudRepository <OrderInfo, Long> {
    @Query("SELECT p FROM OrderInfo p WHERE p.treeName LIKE %?1%")
        public List<OrderInfo> findOrderInfoBy(String keyword);

}
