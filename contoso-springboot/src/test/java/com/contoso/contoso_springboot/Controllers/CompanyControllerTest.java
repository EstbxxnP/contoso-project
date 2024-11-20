package com.contoso.contoso_springboot.Controllers;

import com.contoso.contoso_springboot.Models.Company;
import com.contoso.contoso_springboot.Repositories.CompanyRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyRepository companyRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllCompanysController() throws Exception {
        Company company = new Company();
        company.setCompanyId(1L);
        company.setAddress("Calle 98 # 45 - 67");
        company.setCityOfOperation("Bogotá, D.C");
        company.setName("Globant");

        given(companyRepository.findAll()).willReturn(Arrays.asList(company));

        mockMvc.perform(get("/companys"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(company.getName()));
    }

    @Test
    public void testAddCompanyController() throws Exception {
        Company company = new Company();
        company.setCompanyId(1L);
        company.setAddress("Calle 98 # 45 - 67");
        company.setCityOfOperation("Bogotá, D.C");
        company.setName("Globant");

        given(companyRepository.save(company)).willReturn(company);

        mockMvc.perform(post("/companys")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(company)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(company.getName()));
    }

    @Test
    public void testGetCompanyByIdController() throws Exception {
        Company company = new Company();
        company.setCompanyId(1L);
        company.setAddress("Calle 98 # 45 - 67");
        company.setCityOfOperation("Bogotá, D.C");
        company.setName("Globant");


        given(companyRepository.findById(company.getCompanyId())).willReturn(Optional.of(company));

        mockMvc.perform(get("/companys/{id}", company.getCompanyId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(company.getName()));
    }

    @Test
    public void testDeleteCompanyController() throws Exception {
        Company company = new Company();
        company.setCompanyId(1L);
        company.setAddress("Calle 98 # 45 - 67");
        company.setCityOfOperation("Bogotá, D.C");
        company.setName("Globant");

        given(companyRepository.findById(company.getCompanyId())).willReturn(Optional.of(company));
        doNothing().when(companyRepository).delete(company);

        mockMvc.perform(delete("/companys/{id}", company.getCompanyId()))
                .andExpect(status().isOk());
    }
}

