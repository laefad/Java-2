package com.company.JavaPractice.util;

import com.company.JavaPractice.entity.Item;
import org.springframework.data.jpa.domain.Specification;

public class ItemSpecification {

    public static Specification<Item> selectByOrderId (
            Long orderId
    ) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("order"), orderId);
    }

}
