package org.springframework.samples.petclinic.order;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends Repository<Order, Integer>{
    @Transactional(readOnly = true)
    Collection<Order> findAll() throws DataAccessException;
    Order findById(Integer id);
    void save(Order order);
    void delete(Order order);

    @Query("SELECT order FROM Order order WHERE order.owner.id =:id AND order.status = 0")
    @Transactional(readOnly = true)
    Order findOrder(@Param("id") Integer id);

    @Query("SELECT order FROM Order order WHERE order.owner.id =:id AND order.status = 2")
    @Transactional(readOnly = true)
    Collection<Order> allOrdersInProcess(@Param("id") Integer id);

    @Query("SELECT order FROM Order order WHERE order.owner.id =:id AND order.status = 1")
    @Transactional(readOnly = true)
    Collection<Order> allOrdersFinished(@Param("id") Integer id);
}

