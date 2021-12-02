/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.citas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.petclinic.model.BaseEntity;

/**
 *
 * @author theda
 */
@Entity
@Table(name = "citas")
public class CitaHistory extends BaseEntity{
    @Column(name = "fecha")
    @NotEmpty
    private String fecha;
    @Column(name = "hora")
    @NotEmpty
    private String hora;
    @Column(name = "mascota")
    @NotEmpty
    private String mascota;
    @Column(name = "especialidad")
    @NotEmpty
    private String especialidad;
    @Column(name = "confirmacion")
    @NotEmpty
    private String confirmacion;

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("fecha", this.fecha)
                .append("hora", this.hora)
                .append("mascota", this.mascota)
                .append("especialidad",this.especialidad)
                .append("confirmacion",this.confirmacion)
                .toString();
    }
}
