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
import java.util.ArrayList;
import java.util.List;

@Controller
public class SubmissionController {

    OrderInfo orderInfo;
    Customer customer;

    List<OrderInfo> orderInfoList;


    //get customer and order info to display on the submission page
    @GetMapping("/submission")
    public String submission(Model model) {
        model.addAttribute("customer", customer);
        model.addAttribute("orderInfo", orderInfo);

        orderInfoList = new ArrayList<>();






    }
}
