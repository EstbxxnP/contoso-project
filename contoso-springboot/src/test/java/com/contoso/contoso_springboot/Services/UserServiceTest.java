package com.contoso.contoso_springboot.Services;

import com.contoso.contoso_springboot.Models.User;
import com.contoso.contoso_springboot.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test1() {

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

        when(userRepository.save(ArgumentMatchers.any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));
        userService.addUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void test2() {
        Long id = 1L;

        doNothing().when(userRepository).deleteById(id);
        userService.deleteUser(id);
        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    void getUsers() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void addUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void usersByDepartamentAndCompany() {
    }
}