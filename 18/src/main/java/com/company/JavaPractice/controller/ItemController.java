package com.company.JavaPractice.controller;

import com.company.JavaPractice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping(value = "/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String items (
            @RequestParam Long orderId,
            Model model
    ) {
        model.addAttribute("items", itemService.getItemsByOrderId(orderId))
             .addAttribute("orderId", orderId);
        return "items";
    }

    @GetMapping(value = "/sortById")
    public String sortById (
            @RequestParam Long orderId,
            Model model
    ) {
        model.addAttribute("items", itemService.getSortedById(orderId))
             .addAttribute("orderId", orderId);
        return "items";
    }

    @GetMapping(value = "/sortByName")
    public String sortByName (
            @RequestParam Long orderId,
            Model model
    ) {
        model.addAttribute("items", itemService.getSortedByName(orderId))
             .addAttribute("orderId", orderId);
        return "items";
    }

    @GetMapping(value = "/sortByPrice")
    public String sortByPrice (
            @RequestParam Long orderId,
            Model model
    ) {
        model.addAttribute("items", itemService.getSortedByPrice(orderId))
             .addAttribute("orderId", orderId);
        return "items";
    }

    @GetMapping(value = "/sortByDate")
    public String sortByDate (
            @RequestParam Long orderId,
            Model model
    ) {
        model.addAttribute("items", itemService.getSortedByDate(orderId))
             .addAttribute("orderId", orderId);
        return "items";
    }

    @PostMapping("/remove")
    public String removeItem (
            @RequestParam Long itemId,
            @RequestParam Long orderId,
            Model model
    ) {
        itemService.removeItemById(itemId);

        return "redirect:/items?orderId=" + orderId;
    }

    @PostMapping("/add")
    public String addItem (
            @DateTimeFormat(pattern = "dd-MM-yyyy")
            @RequestParam Date creationDate,
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam Long orderId,
            Model model
    ) {
        itemService.addItem(orderId, creationDate, name, price);

        return "redirect:/items?orderId=" + orderId;
    }
}
