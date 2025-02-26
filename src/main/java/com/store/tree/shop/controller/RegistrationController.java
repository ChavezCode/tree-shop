package com.store.tree.shop.controller;


import com.store.tree.shop.dto.RegistrationWrapper;
import com.store.tree.shop.model.Customer;
import com.store.tree.shop.model.OrderInfo;
import com.store.tree.shop.service.CustomerServiceImpl;
import com.store.tree.shop.service.OrderInfoServiceImpl;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private ApplicationContext context;

    @Autowired
    private OrderInfoServiceImpl orderInfoServiceImpl;
    @Autowired
    private CustomerServiceImpl customerServiceImpl;




    //return the registration webpage
    @GetMapping("/registrationForm")
    public String showRegistration(Model model) {
        RegistrationWrapper registrationInfo = new RegistrationWrapper();
        registrationInfo.setCustomer(new Customer());
        registrationInfo.setOrderInfo(new OrderInfo());
        model.addAttribute("registrationForm", registrationInfo); // Add the form to the model
        return "registration";
    }
//
//    //add the submission to customer and order info tables
    @PostMapping("/orderDetails")
    public String submitRegistration(@Valid @ModelAttribute("registrationForm")RegistrationWrapper registration, BindingResult bindingResult, Model model) {
        model.addAttribute("submitOrder", registration.getOrderInfo());
        model.addAttribute("submitCustomer", registration.getCustomer());
        //add address verification later on here

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else {
            Customer customer = registration.getCustomer();
            OrderInfo orderInfo = registration.getOrderInfo();
            orderInfo.setCustomer(customer);
            customerServiceImpl.save(registration.getCustomer());
            orderInfoServiceImpl.save(registration.getOrderInfo());
            return "submission";

        }
    }
}
