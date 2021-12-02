package org.springframework.samples.petclinic.order;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column(name = "order_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "total")
    private Double total;

    @Column(name = "method_payment")
    @NotNull
    private String method_payment;

    @Column(name = "status")
    @PositiveOrZero
    private int status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Owner owner;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> items;

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }
}
