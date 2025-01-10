package com.contoso.contoso_springboot.IntegrationTesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void status200whenCallingUserGET() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void status201whenCallingUserPOST() throws Exception {

        String userJson = "{ \"name\":\"Pepe\", \"lastName\":\"Rollo\", \"position\":\"Gerente\", \"address\":\"123 Calle Principal\", \"phoneNumber\":\"1234567890\", \"cityOfResidence\":\"California\", \"userStatus\":\"Activo\", \"salary\": \"124124\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/users/add")
                        .content(userJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}




