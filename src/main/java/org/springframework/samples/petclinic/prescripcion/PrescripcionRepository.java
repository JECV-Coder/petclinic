/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.prescripcion;


import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author zictcian
 */
public interface PrescripcionRepository extends Repository<Prescripcion, Long>{
    
    @Query("SELECT prescripcion FROM Prescripcion prescripcion WHERE prescripcion.id =:id")
    @Transactional(readOnly = true)
    Prescripcion findById(@Param("id") Integer id);
    
    @Query("SELECT prescripcion FROM Prescripcion prescripcion WHERE prescripcion.medicamento LIKE %:medicamento%")
    @Transactional(readOnly = true)
    Collection<Prescripcion> findByMedicamento(@Param("medicamento") String medicamento);
  
    @Query("SELECT prescripcion FROM Prescripcion prescripcion INNER JOIN Citas cita ON cita.id=prescripcion.citaid")
    Collection<Prescripcion> getAllPrescripcion();
    
    @Query("SELECT prescripcion FROM Prescripcion prescripcion WHERE prescripcion.nombre !=:nombre")
    @Transactional(readOnly = true)
    Collection<Prescripcion> validateNewPrescripcion(@Param("nombre") String nombre);
    
    void save(Prescripcion prescripcion); 
       
    void delete(Prescripcion prescripcion);
}
