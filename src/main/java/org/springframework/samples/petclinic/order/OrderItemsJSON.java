package org.springframework.samples.petclinic.order;

import java.util.ArrayList;
import java.util.List;

public class OrderItemsJSON {
    private List<OrderItem> orderItems;
    public List<OrderItem> getOrderList() {
        if(orderItems == null) {
            orderItems = new ArrayList<>();
        }
        return orderItems;
    }
}
