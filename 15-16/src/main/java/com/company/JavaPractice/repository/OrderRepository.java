package com.company.JavaPractice.repository;

import com.company.JavaPractice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
