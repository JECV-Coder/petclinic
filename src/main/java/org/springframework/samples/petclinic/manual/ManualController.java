/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.manual;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author theda
 */
@Controller
public class ManualController {
     private static final String VIEW_MANUAL = "/manual/manual";
     
     @GetMapping("/manual/manual")
     public String manual(Map<String, Object> model) {
         return VIEW_MANUAL;
     }
}
