/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.citas;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 *
 * @author theda
 */
public interface CitaHistoryRepository extends Repository<CitaHistory, Long>{
    @Query("SELECT citas FROM CitaHistory citas")
    Collection<CitaHistory> getAllCitas();
}
