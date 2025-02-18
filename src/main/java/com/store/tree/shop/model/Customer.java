package com.store.tree.shop.model;


import jakarta.persistence.*;
import javax.validation.constraints.NotNull;


import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

//    creating a table for customer information
    @Id
    @Column(name = "customerID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;

    @Column(name = "customerName")
    @NotNull
    private String customerName;

    @Column(name = "customerAddress")
    @NotNull
    private String address;

    @Column(name = "phoneNumber")
    @NotNull
    private String phoneNumber;

    @Column(name = "email")
    @NotNull
    private String email;

// mapping relationship between customer and order info
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerID", referencedColumnName = "orderId")
    private OrderInfo orderInfo;


    // getters and setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }




    // constructors


    public Customer(String email, String phoneNumber, String address, String customerName, int customerID) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.customerName = customerName;
        this.customerID = customerID;
    }

    public Customer(int customerID, String customerName, String address, String phoneNumber, String email) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Customer() {}
}
