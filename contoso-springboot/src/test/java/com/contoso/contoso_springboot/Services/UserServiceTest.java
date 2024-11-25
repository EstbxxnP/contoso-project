package com.contoso.contoso_springboot.Services;

import com.contoso.contoso_springboot.Models.User;
import com.contoso.contoso_springboot.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.doNothing;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

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
    void saveUserTest() {
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
    void deleteUserTest() {
        Long id = 1L;

        doNothing().when(userRepository).deleteById(id);
        userService.deleteUser(id);
        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    void getUsersTest() {
        User user = new User();
        user.setUserId(1L);
        user.setName("Juan");

        given(userRepository.findAll()).willReturn(Arrays.asList(user));
        List<User> users = userService.getUsers();
        assertThat(users)
                .isNotEmpty()
                .extracting(User::getName)
                .contains("Juan");
    }

    @Test
    void getUserByIdTest() {
        User user = new User();
        user.setUserId(1L);
        user.setName("Juan");

        given(userRepository.findById(user.getUserId())).willReturn(Optional.of(user));
        Optional<User> userNotFound = userService.getUserById(user.getUserId());
        assertThat(userNotFound).isPresent();
        assertThat(userNotFound.get().getName()).isEqualTo("Juan");
    }

    @Test
    void updateUserTest() {
        Long userId = 1L;
        User user = new User();
        user.setUserId(userId);
        user.setName("Juan");

        User updatedUser = new User();
        updatedUser.setUserId(userId);
        updatedUser.setName("Carlos");

        given(userRepository.findById(userId)).willReturn(Optional.of(user));
        given(userRepository.save(updatedUser)).willReturn(updatedUser);
        userService.updateUser(updatedUser);
        assertThat(updatedUser.getName()).isEqualTo("Carlos");
        verify(userRepository).save(updatedUser);
    }
}

