package com.contoso.contoso_springboot.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void test1() {
        UserService userService = new UserService();
    }

    @BeforeEach
    void setUp() {
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