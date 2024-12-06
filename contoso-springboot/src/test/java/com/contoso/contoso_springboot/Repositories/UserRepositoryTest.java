package com.contoso.contoso_springboot.Repositories;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import com.contoso.contoso_springboot.Models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository usuarioRepository;

    @Test
    @Rollback(false)
    public void saveUserTest() {
        User user = new User();
        user.setName("Esteban");
        user.setAddress("Cra45H");
        user.setPhoneNumber("312214125");
        user.setUserStatus("Activo");
        user.setLastName("Rambo");
        user.setPosition("Gerente");
        user.setCityOfResidence("Cali");
        user.setSalary(22.1211);

        User savedUser = usuarioRepository.save(user);
        assertThat(savedUser.getUserId()).isNotNull();
    }

    @Test
    public void getAllUsersTest() {
        List<User> users = usuarioRepository.findAll();
        assertThat(users).isNotEmpty();
    }
}