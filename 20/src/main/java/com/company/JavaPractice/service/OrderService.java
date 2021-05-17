package com.company.JavaPractice.service;

import com.company.JavaPractice.entity.Order;
import com.company.JavaPractice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll(){
        log.info("get all orders");
        return orderRepository.findAll();
    }

    public void addOrder(Date orderDate) {
        log.info(String.format("Add order, orderDate = %tF", orderDate));
        if (orderDate != null)
            orderRepository.save(
                    Order.builder()
                    .orderDate(orderDate)
                    .build()
            );
    }

    public void removeOrderById(Long orderId) {
        log.info(String.format("Remove order, id = %d", orderId));
        if (orderId != null)
            orderRepository.deleteById(orderId);
    }

    private List<Order> getSortedBy(String field){
        return orderRepository.findAll(
                Sort.by(Sort.Direction.ASC, field)
        );
    }

    public List<Order> getSortedByDate() {
        log.info("get sorted by date");
        return getSortedBy("orderDate");
    }

    public List<Order> getSortedById() {
        log.info("get sorted by id");
        return getSortedBy("id");
    }
}
