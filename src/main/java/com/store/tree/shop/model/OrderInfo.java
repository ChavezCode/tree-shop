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
    int orderId;

    @Column(name = "treeName")
    @NotNull
    String treeName;


    @Column(name = "treeInv")
    int treeInv;



    // mapping relationship between customer and order info
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    Customer customer;



    // getters and setters


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
