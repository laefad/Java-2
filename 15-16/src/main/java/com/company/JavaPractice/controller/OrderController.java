package com.company.JavaPractice.controller;

import com.company.JavaPractice.entity.Item;
import com.company.JavaPractice.entity.Order;
import com.company.JavaPractice.repository.ItemRepository;
import com.company.JavaPractice.repository.OrderRepository;
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
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public String orders(
            Model model
    ) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }

    @PostMapping("/addOrder")
    public String addOrder (
            @DateTimeFormat(pattern = "dd-MM-yyyy")
            @RequestParam Date orderDate,
            Model model
    ) {
        if (orderDate != null)
            orderRepository.save(Order.builder()
                    .orderDate(orderDate)
                    .build());

        model.addAttribute("orders", orderRepository.findAll());
        return "redirect:/orders";
    }

    @PostMapping("/removeOrder")
    public String removeOrder (
            @RequestParam Long orderId,
            Model model
    ) {
        if (orderId != null)
            orderRepository.deleteById(orderId);

        model.addAttribute("orders", orderRepository.findAll());
        return "redirect:/orders";
    }

    @PostMapping("/addItem")
    public String addItem (
            @DateTimeFormat(pattern = "dd-MM-yyyy")
            @RequestParam Date creationDate,
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam Long orderId,
            Model model
    ) {
        if (creationDate != null
                && name != null
                && price != null
                && orderId != null)

            itemRepository.save(
                    Item.builder()
                            .creationDate(creationDate)
                            .name(name)
                            .price(price)
                            .order(orderRepository.getOne(orderId))
                            .build()
            );

        model.addAttribute("orders", orderRepository.findAll());
        return "redirect:/orders";
    }

    @PostMapping("/removeItem")
    public String removeItem (
            @RequestParam Long orderId,
            @RequestParam Long itemId,
            Model model
    ) {
        if (orderId != null && itemId != null)
            itemRepository.deleteById(itemId);

        model.addAttribute("orders", orderRepository.findAll());
        return "redirect:/orders";
    }

}
