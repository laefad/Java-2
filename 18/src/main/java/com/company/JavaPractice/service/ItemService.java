package com.company.JavaPractice.service;

import com.company.JavaPractice.entity.Item;
import com.company.JavaPractice.repository.ItemRepository;
import com.company.JavaPractice.repository.OrderRepository;
import com.company.JavaPractice.util.ItemSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    private List<Item> getSortedBy(String field, Long orderId){
        return itemRepository.findAll(
                ItemSpecification.selectByOrderId(orderId)
                , Sort.by(Sort.Direction.ASC, field)
        );
    }

    public List<Item> getItemsByOrderId(Long orderId) {
       return itemRepository.findAll(
                ItemSpecification.selectByOrderId(orderId)
        );
    }

    public void removeItemById(Long itemId) {
        if (itemId != null)
            itemRepository.deleteById(itemId);
    }

    public void addItem(
            Long orderId,
            Date creationDate,
            String name,
            Double price
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
    }

    public List<Item> getSortedById(Long orderId) {
        return getSortedBy("id", orderId);
    }

    public List<Item> getSortedByName(Long orderId) {
        return getSortedBy("name", orderId);
    }

    public List<Item> getSortedByPrice(Long orderId) {
        return getSortedBy("price", orderId);
    }

    public List<Item> getSortedByDate(Long orderId) {
        return getSortedBy("creationDate", orderId);
    }

}
