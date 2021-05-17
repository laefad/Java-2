package com.company.JavaPractice.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
@Getter
@Setter
@ToString
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "order_date")
    Date orderDate;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, orphanRemoval = true)
    List<Item> items;
}
