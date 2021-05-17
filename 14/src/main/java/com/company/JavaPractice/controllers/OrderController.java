package com.company.JavaPractice.controllers;

import com.company.JavaPractice.OrderService;
import com.company.JavaPractice.models.Item;
import com.company.JavaPractice.models.Order;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public String orders(
            Model model
    ) {
        model.addAttribute("orders", orderService.getOrders());
        return "orders";
    }

    @PostMapping("/addOrder")
    public String addOrder (
            @DateTimeFormat(pattern = "dd-MM-yyyy")
            @RequestParam Date orderDate,
            Model model
    ) {
        if (orderDate != null)
            orderService.addOrder(new Order(orderDate));

        model.addAttribute("orders", orderService.getOrders());
        return "orders";
    }

    @PostMapping("/removeOrder")
    public String removeOrder (
            @RequestParam Integer orderId,
            Model model
    ) {
        if (orderId != null)
            orderService.removeOrder(orderId);

        model.addAttribute("orders", orderService.getOrders());
        return "orders";
    }

    @PostMapping("/addItem")
    public String addItem (
            @DateTimeFormat(pattern = "dd-MM-yyyy")
            @RequestParam Date creationDate,
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam Integer orderId,
            Model model
    ) {
        if (creationDate != null
                && name != null
                && price != null
                && orderId != null)
            orderService.addItemToOrder(orderId, new Item(name, creationDate, price));

        model.addAttribute("orders", orderService.getOrders());
        return "orders";
    }

    @PostMapping("/removeItem")
    public String removeItem (
            @RequestParam Integer orderId,
            @RequestParam Integer itemId,
            Model model
    ) {
        if (orderId != null && itemId != null)
            orderService.removeItemFromOrder(orderId, itemId);

        model.addAttribute("orders", orderService.getOrders());
        return "orders";
    }
}
