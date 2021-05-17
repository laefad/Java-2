package com.company.JavaPractice;

import com.company.JavaPractice.models.Item;
import com.company.JavaPractice.models.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@NoArgsConstructor
@Service
public class OrderService {
    Map<Order, List<Item>> orders = new HashMap<>();

    public void addOrder(Order order)
    {
        orders.put(order, new ArrayList<Item>());
    }

    public void removeOrder(int orderId)
    {
        orders.keySet()
            .stream()
            .filter((val) -> val.getId() == orderId)
            .limit(1)
            .forEach(orders::remove);
    }

    public void addItemToOrder(int orderId, Item item)
    {
        orders.entrySet().stream()
            .filter((i) -> i.getKey().getId() == orderId)
            .limit(1)
            .forEach((i) -> i.getValue().add(item));
    }

    public void removeItemFromOrder(int orderId, int itemId)
    {
        orders.entrySet()
            .stream()
            .filter((i) -> i.getKey().getId() == orderId)
            .limit(1)
            .forEach(
                (i) -> i.getValue().removeIf(
                    (val) -> val.getId() == itemId
                )
            );
    }

    public void clear ()
    {
        orders.clear();
    }

}
