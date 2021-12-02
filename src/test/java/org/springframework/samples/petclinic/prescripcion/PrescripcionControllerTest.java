package org.springframework.samples.petclinic.prescripcion;
import org.junit.Before;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PrescripcionControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @WithMockUser(username = "admin@admin.com", authorities = {"ADMIN_PRIVILEGE"})
    @Test
    public void getMedicamentos() throws Exception {
        this.mockMvc.perform(get("/prescripcion"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("prescripcion"))
                .andExpect(view().name("prescripcion/findPrescripcion"));
    }
    
    @WithMockUser(username = "admin@admin.com", authorities = {"ADMIN_PRIVILEGE"})
    @Test
    public void getMedicamentosFind() throws Exception {
        this.mockMvc.perform(get("/prescripcion"))
                .andExpect(status().isOk());
    }

    
    @WithMockUser(username = "admin@admin.com", authorities = {"ADMIN_PRIVILEGE"})
    @Test
    public void getProductsReport() throws Exception {
        this.mockMvc.perform(get("/prescripcion/report"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("allPrescripcion"))
                .andExpect(view().name("prescripcion/prescripcion-report"));
    }
    
    @WithMockUser(username = "admin@admin.com", authorities = {"ADMIN_PRIVILEGE"})
    @Test
    public void initNewProduct() throws Exception {
        this.mockMvc.perform(get("/prescripcion/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("prescripcion"))
                .andExpect(model().attributeExists("citas"))
                .andExpect(view().name("prescripcion/prescripcion-create"));
    }

    @WithMockUser(username = "admin@admin.com", authorities = {"ADMIN_PRIVILEGE"}) //owner
    @Test
    public void postNewProduct() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/prescripcion/new")
                .param("fecha", "02-02-2020")
                .param("medicamento", "amor-didas")
                .param("dosis", "mushas")
                .param("frecuencia","al dia")
                .param("nombre","bonery")
                .param("citaid","1")
        );
        //.andExpect(status().is3xxRedirection());
    }

    
    
    @WithMockUser(username = "admin@admin.com", authorities = {"ADMIN_PRIVILEGE"})
    @Test
    public void getUpdateMedicamento() throws Exception {
        this.mockMvc.perform(get("/prescripcion/edit/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("prescripcion/prescripcion-edit"));
         //  .andExpect(status().is3xxRedirection());
    }
    
    
    @WithMockUser(username = "admin@admin.com", authorities = {"ADMIN_PRIVILEGE"})
    @Test
    public void postUpdateMedicamento() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/prescripcion/edit/{id}", 1)
            .param("fecha", "02-02-2020")
                .param("medicamento", "amordidas")
                .param("dosis", "muchas")
                .param("frecuencia","dia")
                .param("nombre","bonaice")
                .param("citaid","1")
        )
            .andExpect(status().isOk())
//            .andExpect(model().attributeHasErrors("medicamento"))
  //          .andExpect(model().attributeHasFieldErrors("medicamento", "presentacion"))
            .andExpect(view().name("/prescripcion"));
    }
    
    
    
    
}