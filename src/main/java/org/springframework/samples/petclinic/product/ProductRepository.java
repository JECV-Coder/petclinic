package org.springframework.samples.petclinic.product;

import java.util.Collection;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;


public interface ProductRepository extends Repository<Product, Integer> {
    @Transactional(readOnly = true)
    Collection<Product> findAll() throws DataAccessException;
    Product findById(Integer id);
    void save(Product product);
    void delete(Product product);
}
