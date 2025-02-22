package com.store.tree.shop.controller;


import com.store.tree.shop.model.Customer;
import com.store.tree.shop.model.OrderInfo;
import com.store.tree.shop.service.OrderInfoServiceImpl;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    private OrderInfo orderInfo;
    private Customer customer;

    //return the webpage
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    //add the submission to customer
    @PostMapping("/registration")
    public String submitRegistration(@Valid @ModelAttribute("submit") OrderInfo orderInfo, BindingResult bindingResult, Model model) {
        model.addAttribute("orderInfo", orderInfo);
        //add validation for address later on here

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else {
            orderInfoServiceImpl.save(orderInfo);
            return "submission";

        }
    }
}
