package com.company.JavaPractice.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    static int ID;
    final int id = Order.ID++;
    String name;
    Date creationDate;
    double price;
}
