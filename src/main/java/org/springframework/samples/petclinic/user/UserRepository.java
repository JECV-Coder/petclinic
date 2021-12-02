package org.springframework.samples.petclinic.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends Repository<User, Integer>{

    @Query("SELECT user FROM User user WHERE user.email = :email")
    @Transactional(readOnly = true)
    User findByEmail(@Param("email") String email);
    User findById(Integer id);
    void save(User user);
}
