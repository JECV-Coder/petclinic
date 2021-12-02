package org.springframework.samples.petclinic.order;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrderItemRepository extends Repository<OrderItem, Integer>{
    @Query("SELECT orderItem FROM OrderItem orderItem WHERE orderItem.order.id =:id")
    @Transactional(readOnly = true)
    Collection<OrderItem> getOrderItem(@Param("id") Integer id);

    @Query("SELECT orderItem FROM OrderItem orderItem WHERE orderItem.order.id =:id")
    @Transactional(readOnly = true)
    ArrayList<OrderItem> getListOrderItem(@Param("id") Integer id);

    @Query("SELECT orderItem FROM OrderItem orderItem WHERE orderItem.product.id= ?1 and orderItem.order.id = ?2")
    @Transactional(readOnly = true)
    OrderItem getOrderItemDuplicated(Integer id, Integer ownerId);

    @Transactional(readOnly = true)
    Collection<OrderItem> findAll() throws DataAccessException;
    OrderItem findById(Integer id);
    void save(OrderItem order);
    void delete(OrderItem order);


}
