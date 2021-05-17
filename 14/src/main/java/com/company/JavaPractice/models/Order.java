package com.company.JavaPractice.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    static int ID;
    final int id = Order.ID++;
    Date orderDate;
}
