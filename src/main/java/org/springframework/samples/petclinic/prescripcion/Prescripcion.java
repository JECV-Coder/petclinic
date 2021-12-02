/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.prescripcion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.petclinic.model.BaseEntity;

/**
 *
 * @author legad
 */

@Entity
@Table(name = "prescripcion")

public class Prescripcion extends BaseEntity{
    @Column(name = "fecha")
    @NotEmpty
    private String fecha;
    
    @Column(name = "medicamento")
    @NotEmpty
    private String medicamento;
    
    @Column(name = "dosis")
    @NotEmpty
    private String dosis;
    
    @Column(name = "frecuencia")
    @NotEmpty
    private String frecuencia;
    
    @Column(name = "nombre")
    @NotEmpty
    public String nombre;
    
    @Column(name = "citaid")
    @NotNull
    private Integer citaid;
 
    public Integer getCitaid(){
        return this.citaid;
    }
    public void setCitaid(Integer citaid){
        this.citaid=citaid;
    }  
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }   
    
    public String getFecha(){
        return this.fecha;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    
    public String getMedicamento(){
        return this.medicamento;
    }
    
    public void setMedicamento(String medicamento){
        this.medicamento = medicamento;
    }
    
    public String getDosis(){
        return this.dosis;
    }
    
    public void setDosis(String dosis){
        this.dosis = dosis;
    }
    
    public String getFrecuencia(){
        return this.frecuencia;
    }
    
    public void setFrecuencia(String frecuencia){
        this.frecuencia=frecuencia;
    }
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("cita", this.citaid)
                .append("nombre", this.nombre)
                .append("fecha", this.fecha)
                .append("medicamento", this.medicamento)
                .append("dosis",this.dosis)
                .append("frecuencia",this.frecuencia)
                .toString();
    }

    boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
