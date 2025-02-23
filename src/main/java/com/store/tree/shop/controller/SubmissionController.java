package com.store.tree.shop.controller;

import com.store.tree.shop.dto.RegistrationWrapper;
import com.store.tree.shop.model.Customer;
import com.store.tree.shop.model.OrderInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SubmissionController {

    OrderInfo orderInfo;
    Customer customer;

    List<OrderInfo> orderInfoList;


    //get customer and order info to display in the submission page
    @PostMapping("/submission")
    public String submission(@Valid @ModelAttribute("registrationInfo")RegistrationWrapper registrationInfo, BindingResult bindingResult, Model model) {
        model.addAttribute("orderInfo", registrationInfo.getOrderInfo());
        model.addAttribute("customer", registrationInfo.getCustomer());
        if (orderInfo != null) {
            customer = registrationInfo.getCustomer();


        }
        return "submission";
    }
}
