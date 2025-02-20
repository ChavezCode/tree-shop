package com.store.tree.shop.model;


import jakarta.persistence.*;


import javax.validation.constraints.NotNull;


import java.io.Serializable;


@Entity
@Table(name = "customer")
public class Customer implements Serializable {

// getters and setters
    //    creating a table for customer information
    @Id
    @Column(name = "customerId")
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

    // mapping relationship between customer and order info (order owns relationship)
    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
    private OrderInfo orderInfo;




//    Getters and setters

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }



    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public @NotNull String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotNull String getAddress() {
        return address;
    }

    public void setAddress(@NotNull String address) {
        this.address = address;
    }

    public @NotNull String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(@NotNull String customerName) {
        this.customerName = customerName;
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
