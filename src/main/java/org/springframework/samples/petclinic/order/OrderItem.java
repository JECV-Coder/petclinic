package org.springframework.samples.petclinic.order;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.product.Product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity {
    @Column(name = "quantity")
    @NotNull
    @Positive
    private int quantity;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
