package com.store.tree.shop.model;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "orderInfo")
public class OrderInfo implements Serializable {

    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(name = "tree1")
    @NotNull
    private String tree1;

    @Column(name = "tree2")
    @NotNull
    private String tree2;


    // mapping relationship between customer and order info
    @OneToOne(mappedBy = "orderInfo")
    private Customer customer;



    // getters and setters
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTree1() {
        return tree1;
    }

    public void setTree1(String tree1) {
        this.tree1 = tree1;
    }

    public String getTree2() {
        return tree2;
    }

    public void setTree2(String tree2) {
        this.tree2 = tree2;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    // constructors


    public OrderInfo(String tree1, String tree2) {
        this.tree1 = tree1;
        this.tree2 = tree2;
    }

    public OrderInfo(int orderId, String tree1, String tree2, Customer customer) {
        this.orderId = orderId;
        this.tree1 = tree1;
        this.tree2 = tree2;
    }

    public OrderInfo() {

    }
}
