package com.company.JavaPractice.repository;

import com.company.JavaPractice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
