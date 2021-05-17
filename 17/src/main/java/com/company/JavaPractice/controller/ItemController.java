package com.company.JavaPractice.controller;

import com.company.JavaPractice.entity.Item;
import com.company.JavaPractice.repository.ItemRepository;
import com.company.JavaPractice.repository.OrderRepository;
import com.company.JavaPractice.util.ItemSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value = "/items")
public class ItemController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public String items (
            @RequestParam Long orderId,
            Model model
    ) {
        model.addAttribute("items", itemRepository.findAll(
                ItemSpecification.selectByOrderId(orderId)
        ))
            .addAttribute("orderId", orderId);
        return "items";
    }

    private List<Item> getSorted(
        String field,
        Long orderId
    ) {
        return itemRepository.findAll(
                ItemSpecification.selectByOrderId(orderId)
                , Sort.by(Sort.Direction.ASC, field)
        );
    }

    @GetMapping(value = "/sortById")
    public String sortById (
            @RequestParam Long orderId,
            Model model
    ) {
        model.addAttribute("items", getSorted("id", orderId))
            .addAttribute("orderId", orderId);
        return "items";
    }

    @GetMapping(value = "/sortByName")
    public String sortByName (
            @RequestParam Long orderId,
            Model model
    ) {
        model.addAttribute("items", getSorted("name", orderId))
                .addAttribute("orderId", orderId);
        return "items";
    }

    @GetMapping(value = "/sortByPrice")
    public String sortByPrice (
            @RequestParam Long orderId,
            Model model
    ) {
        model.addAttribute("items", getSorted("price", orderId))
                .addAttribute("orderId", orderId);
        return "items";
    }

    @GetMapping(value = "/sortByDate")
    public String sortByDate (
            @RequestParam Long orderId,
            Model model
    ) {
        model.addAttribute("items", getSorted("creationDate", orderId))
                .addAttribute("orderId", orderId);
        return "items";
    }

    @PostMapping("/remove")
    public String removeItem (
            @RequestParam Long itemId,
            @RequestParam Long orderId,
            Model model
    ) {
        if (itemId != null)
            itemRepository.deleteById(itemId);

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

        return "redirect:/items?orderId=" + orderId;
    }
}
