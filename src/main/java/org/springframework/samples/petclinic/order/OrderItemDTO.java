package org.springframework.samples.petclinic.order;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.product.Product;

public class OrderItemDTO extends BaseEntity {
    private int quantity;
    private int productId;
    private int orderId;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
