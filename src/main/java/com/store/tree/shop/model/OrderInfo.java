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

    @Column(name = "treeName")
    @NotNull
    private String treeName;


    @Column(name = "treeInv")
    private int treeInv;



    // mapping relationship between customer and order info(orderinfo owner of relationship)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerAddress")
    private Customer customer;



    // getters and setters


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public int getTreeInv() {
        return treeInv;
    }

    public void setTreeInv(int treeInv) {
        this.treeInv = treeInv;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }





    // constructors

    public OrderInfo(int treeInv, String treeName, int orderId) {
        this.treeInv = treeInv;
        this.treeName = treeName;
        this.orderId = orderId;
    }

    public OrderInfo( int orderId, int treeInv, String treeName) {
        this.treeInv = treeInv;
        this.treeName = treeName;
        this.orderId = orderId;
    }

    public OrderInfo() {}
}
