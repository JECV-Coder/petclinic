/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.prescripcion;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.citas.CitaHistory;
import org.springframework.samples.petclinic.citas.CitaHistoryRepository;
import org.springframework.samples.petclinic.citas.Citas;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.Pets;
import org.springframework.samples.petclinic.prescripcion.PrescripcionRepository;
import org.springframework.samples.petclinic.user.RoleRepository;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author legad
 */
@Controller
public class PrescripcionController {
    private final PrescripcionRepository prescripcionRepository;
    private final CitaHistoryRepository citaHistory;
    @Autowired
    private static final String VIEW_PRESCRIPCION = "prescripcion/findPrescripcion";
    private static final String VIEW_PRESCRIPCION_REPORT = "prescripcion/prescripcion-report"; 
    private static final String VIEW_PRESCRIPCION_NEW = "prescripcion/prescripcion-create"; 
    private static final String VIEW_PRESCRIPCION_EDIT = "prescripcion/prescripcion-edit";
    public PrescripcionController(PrescripcionRepository prescripcion, CitaHistoryRepository cita) {
        this.prescripcionRepository = prescripcion;
        this.citaHistory=cita;
    }
    
    @GetMapping("/prescripcion")
    public String prescripcionFind(Map<String, Object> model) {
        Prescripcion prescripcion = new Prescripcion();
        model.put("prescripcion", prescripcion);
        return VIEW_PRESCRIPCION;
    }
    
    @PostMapping("/prescripcion")
    public String prescripcionFindMedicamento(@Valid Prescripcion prescripcion, BindingResult result,Map<String, Object> model) {
        if (prescripcion.getMedicamento() == null) {
            prescripcion.setMedicamento(""); // empty string signifies broadest possible search
        }
        System.out.println("Buscar "+prescripcion.getMedicamento());
        Collection<Prescripcion> allPrescripcion = this.prescripcionRepository.findByMedicamento(prescripcion.getMedicamento());
        model.put("allPrescripcion", allPrescripcion);
        return VIEW_PRESCRIPCION_REPORT;
    }
    
    @GetMapping("/prescripcion/report")
    public String report(Map<String, Object> model) {
        Collection<Prescripcion> allPrescripcion = this.prescripcionRepository.getAllPrescripcion();
        model.put("allPrescripcion", allPrescripcion);
        System.out.println(allPrescripcion.toString());
        return VIEW_PRESCRIPCION_REPORT;
    }
    
    @GetMapping("/prescripcion/new")
    public String initCreationForm(Map<String, Object> model) {
        Prescripcion prescripcion = new Prescripcion();
        Collection<CitaHistory> citas = this.citaHistory.getAllCitas();
        model.put("citas",citas);
        model.put("prescripcion", prescripcion);
        return VIEW_PRESCRIPCION_NEW;
    }
    
    @PostMapping("/prescripcion/new")
    public String processCreationForm(@Valid Prescripcion prescripcion, BindingResult result) {
        if (result.hasErrors()) {
            return VIEW_PRESCRIPCION_NEW;
        } else {
            this.prescripcionRepository.save(prescripcion);
            return "redirect:/prescripcion";
        }

    }
    
    @GetMapping("/prescripcion/edit/{id}")
    public ModelAndView showOwner(@PathVariable("id") int id,Map<String, Object> model) {
        ModelAndView mav = new ModelAndView("prescripcion/prescripcion-edit");
        Collection<CitaHistory> citas = this.citaHistory.getAllCitas();
        model.put("citas",citas);
        mav.addObject(this.prescripcionRepository.findById(id));
        return mav;
    }
    
    @PostMapping("/prescripcion/edit/{id}")
    public String processUpdateOwnerForm(@Valid Prescripcion prescripcion, BindingResult result, @PathVariable("id") int id) {
        System.out.println("valor");
        if (result.hasErrors()) {
            return VIEW_PRESCRIPCION_EDIT;
        } else {  
            this.prescripcionRepository.save(prescripcion);
            return "redirect:/prescripcion";
        }
    }
    
    @GetMapping("/prescripcion/delete/{id}")
    public String deletePrescripcion(@PathVariable("id") int id) {
        Prescripcion prescripcion = this.prescripcionRepository.findById(id);
        System.out.println("eliminate PRESCRIPCION " +prescripcion);
        this.prescripcionRepository.delete(prescripcion);
        return "redirect:/prescripcion";
    }
}
