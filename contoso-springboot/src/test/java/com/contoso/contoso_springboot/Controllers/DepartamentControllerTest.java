package com.contoso.contoso_springboot.Controllers;

import com.contoso.contoso_springboot.Models.Departament;
import com.contoso.contoso_springboot.Repositories.DepartamentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.Optional;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class DepartamentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartamentRepository departamentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllDepartamentsController() throws Exception {
        Departament departament = new Departament();
        departament.setIdDepartament(1L);
        departament.setDescription("Seguridad");

        given(departamentRepository.findAll()).willReturn(Arrays.asList(departament));
        mockMvc.perform(get("/departaments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value(departament.getDescription()));
    }

    @Test
    public void testAddDepartamentController() throws Exception {
        Departament departament = new Departament();
        departament.setIdDepartament(1L);
        departament.setDescription("Seguridad");

        given(departamentRepository.save(departament)).willReturn(departament);
        mockMvc.perform(post("/departaments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(departament)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value(departament.getDescription()));
    }

    @Test
    public void testGetDepartamentByIdController() throws Exception {
        Departament departament = new Departament();
        departament.setIdDepartament(1L);
        departament.setDescription("Seguridad");

        given(departamentRepository.findById(departament.getIdDepartament())).willReturn(Optional.of(departament));
        mockMvc.perform(get("/departaments/{id}", departament.getIdDepartament()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value(departament.getDescription()));
    }

    @Test
    public void testDeleteDepartamentController() throws Exception {
        Departament departament = new Departament();
        departament.setIdDepartament(1L);
        departament.setDescription("Seguridad");

        given(departamentRepository.findById(departament.getIdDepartament())).willReturn(Optional.of(departament));
        doNothing().when(departamentRepository).delete(departament);
        mockMvc.perform(delete("/departaments/{id}", departament.getIdDepartament()))
                .andExpect(status().isOk());
    }
}
