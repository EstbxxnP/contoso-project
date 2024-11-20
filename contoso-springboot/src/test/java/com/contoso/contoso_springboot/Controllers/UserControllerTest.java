package com.contoso.contoso_springboot.Controllers;

import com.contoso.contoso_springboot.Models.User;
import com.contoso.contoso_springboot.Repositories.UserRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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

@WebMvcTest(UserController.class)
class UserControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private UserRepository userRepository;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        public void testGetAllUsersController() throws Exception {
            User user = new User();
            user.setUserId(1L);
            user.setName("Esteban");
            user.setAddress("Cra45H");
            user.setPhoneNumber("312214125");
            user.setUserStatus("Activo");
            user.setLastName("Rambo");
            user.setPosition("Gerente");
            user.setCityOfResidence("Cali");
            user.setSalary(22.1211);

            given(userRepository.findAll()).willReturn(Arrays.asList(user));

            mockMvc.perform(get("/users"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].name").value(user.getName()));
        }

        @Test
        public void testAddUserController() throws Exception {
            User user = new User();
            user.setName("Esteban");
            user.setAddress("Cra45H");
            user.setPhoneNumber("312214125");
            user.setUserStatus("Activo");
            user.setLastName("Rambo");
            user.setPosition("Gerente");
            user.setCityOfResidence("Cali");
            user.setSalary(22.1211);

            given(userRepository.save(user)).willReturn(user);

            mockMvc.perform(post("/users")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(user)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value(user.getName()));
        }

        @Test
        public void testGetUserByIdController() throws Exception {
            User user = new User();
            user.setUserId(1L);
            user.setName("Esteban");
            user.setAddress("Cra45H");
            user.setPhoneNumber("312214125");
            user.setUserStatus("Activo");
            user.setLastName("Rambo");
            user.setPosition("Gerente");
            user.setCityOfResidence("Cali");
            user.setSalary(22.1211);

            given(userRepository.findById(user.getUserId())).willReturn(Optional.of(user));

            mockMvc.perform(get("/users/{id}", user.getUserId()))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value(user.getName()));
        }

        @Test
        public void testDeleteUserController() throws Exception {
            User user = new User();
            user.setUserId(1L);
            user.setName("Esteban");
            user.setAddress("Cra45H");
            user.setPhoneNumber("312214125");
            user.setUserStatus("Activo");
            user.setLastName("Rambo");
            user.setPosition("Gerente");
            user.setCityOfResidence("Cali");
            user.setSalary(22.1211);

            given(userRepository.findById(user.getUserId())).willReturn(Optional.of(user));
            doNothing().when(userRepository).delete(user);

            mockMvc.perform(delete("/users/{id}", user.getUserId()))
                    .andExpect(status().isOk());
        }
    }

