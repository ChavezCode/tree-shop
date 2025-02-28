package com.store.tree.shop.controller;


import com.store.tree.shop.dto.RegistrationWrapper;
import com.store.tree.shop.model.Customer;
import com.store.tree.shop.model.OrderInfo;
import com.store.tree.shop.repository.CustomerRepository;
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
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class RegistrationController {

    private ApplicationContext context;

    @Autowired
    private OrderInfoServiceImpl orderInfoServiceImpl;
    @Autowired
    private CustomerServiceImpl customerServiceImpl;
    @Autowired
    private CustomerRepository customerRepository;


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

        Customer customer = registration.getCustomer();
        OrderInfo orderInfo = registration.getOrderInfo();

        //add address verification later on here











        if (bindingResult.hasErrors()) {
            return "registration";
        }
//check to see if any of the addresses on file matches the address that was used for registration
        String address = registration.getCustomer().getAddress();
        if (customerRepository.findByAddress(address).isPresent()) {
            orderInfo.setCustomer(customer);
//            customerServiceImpl.save(registration.getCustomer());
//            orderInfoServiceImpl.save(registration.getOrderInfo());
            System.out.println("Address exists");
            return "duplicate";

        }else {


            orderInfo.setCustomer(customer);
            customerServiceImpl.save(registration.getCustomer());
            orderInfoServiceImpl.save(registration.getOrderInfo());
            System.out.println("Address does not exist");
//            System.out.println(address);

//            System.out.println(customerServiceImpl.listAll(address));
////
//            System.out.println(customerRepository.findByAddress(address));
            return "submission";

        }

    }
}
