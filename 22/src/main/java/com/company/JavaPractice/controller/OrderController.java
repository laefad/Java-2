package com.company.JavaPractice.controller;

import com.company.JavaPractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String orders(
            Model model
    ) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @PostMapping("/addOrder")
    public String addOrder (
            @DateTimeFormat(pattern = "dd-MM-yyyy")
            @RequestParam Date orderDate,
            Model model
    ) {
        orderService.addOrder(orderDate);

        return "redirect:/orders";
    }

    @PostMapping("/removeOrder")
    public String removeOrder (
            @RequestParam Long orderId,
            Model model
    ) {
        orderService.removeOrderById(orderId);

        return "redirect:/orders";
    }

    @GetMapping("/sortByDate")
    public String sortByDate (
            Model model
    ) {
        model.addAttribute("orders", orderService.getSortedByDate());
        return "orders";
    }

    @GetMapping("/sortById")
    public String sortById (
            Model model
    ) {
        model.addAttribute("orders", orderService.getSortedById());
        return "orders";
    }

}
