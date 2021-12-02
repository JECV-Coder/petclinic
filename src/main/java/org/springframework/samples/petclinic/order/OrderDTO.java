package org.springframework.samples.petclinic.order;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.OwnerDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class OrderDTO extends BaseEntity {
    private LocalDate date;
    private Double total;
    private String method_payment;

    private Set<OrderItemDTO> items;
    private int ownerId;

    private int status;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getMethod_payment() {
        return method_payment;
    }

    public void setMethod_payment(String method_payment) {
        this.method_payment = method_payment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(Set<OrderItemDTO> items) {
        this.items = items;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}

