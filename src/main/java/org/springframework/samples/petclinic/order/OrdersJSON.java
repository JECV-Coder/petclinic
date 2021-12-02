package org.springframework.samples.petclinic.order;

import java.util.List;
import java.util.ArrayList;

public class OrdersJSON {
    private List<OrderDTO> orders;

    public List<OrderDTO> getOrderList() {
        if(orders == null) {
            orders = new ArrayList<>();
        }
        return orders;
    }
}
