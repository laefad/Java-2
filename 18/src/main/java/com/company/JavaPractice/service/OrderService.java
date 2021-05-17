package com.company.JavaPractice.service;

import com.company.JavaPractice.entity.Order;
import com.company.JavaPractice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public void addOrder(Date orderDate) {
        if (orderDate != null)
            orderRepository.save(
                    Order.builder()
                    .orderDate(orderDate)
                    .build()
            );
    }

    public void removeOrderById(Long orderId) {
        if (orderId != null)
            orderRepository.deleteById(orderId);
    }

    private List<Order> getSortedBy(String field){
        return orderRepository.findAll(
                Sort.by(Sort.Direction.ASC, field)
        );
    }

    public List<Order> getSortedByDate() {
        return getSortedBy("orderDate");
    }

    public List<Order> getSortedById() {
        return getSortedBy("id");
    }
}
