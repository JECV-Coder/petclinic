/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.appointment;

import java.util.Collection;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author theda
 */
@Controller
public class citasEditController {
    private final AppointmentRepository appointmentRepository;
    private final SpecialtieRepository specialtieRepository;
    private static final String VIEW_PRODUCTO_REPORT_BY_SPECIALTIE = "citas/appointment-report-by-specialtie";

    public citasEditController(AppointmentRepository appointmentRepository, SpecialtieRepository specialtieRepository) {
        this.appointmentRepository = appointmentRepository;
        this.specialtieRepository = specialtieRepository;
    }
    @GetMapping("/citas/report/{specialtieId}")
    public String report(Map<String, Object> model, @PathVariable("specialtieId") int specialtieId) {
        Collection<Appointment> allAppointments = null;
        System.out.println(specialtieId);
        if (specialtieId > 0) {
            allAppointments = this.appointmentRepository.getAppointments(specialtieId);
            model.put("allAppointments", allAppointments);
            Specialties specialtie = this.specialtieRepository.getSpecialtieById(specialtieId);
            model.put("specialtie", specialtie.getNombre());

        } else {
            if (specialtieId == 0) {
                allAppointments = this.appointmentRepository.getAppointmentsByConfirmation(0);
                model.put("specialtie", "No confirmados");
            } else if(specialtieId == -1){
                allAppointments = this.appointmentRepository.getAppointmentsByConfirmation(1);
                model.put("specialtie", "Confirmados");
            }else{
                allAppointments = this.appointmentRepository.getAppointments();
                model.put("specialtie", "Todas las Citas");
            }
            model.put("allAppointments", allAppointments);
        }
        return VIEW_PRODUCTO_REPORT_BY_SPECIALTIE;
    }
}
