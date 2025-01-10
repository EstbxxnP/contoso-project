package com.contoso.contoso_springboot.UnitTesting.Repositories;

import com.contoso.contoso_springboot.Models.Departament;
import com.contoso.contoso_springboot.Repositories.DepartamentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartamentRepositoryTest {

    @Autowired
    private DepartamentRepository departamentRepository;

    @Test
    @Rollback(false)
    public void saveDepartamentTest() {
        Departament departament = new Departament();
        departament.setIdDepartament(1L);
        departament.setDescription("Marketing");

        Departament departamentSaved = departamentRepository.save(departament);
        assertThat(departamentSaved.getIdDepartament()).isNotNull();
    }

    @Test
    public void getAllUsersTest() {
        List<Departament> departaments = departamentRepository.findAll();
        assertThat(departaments).isNotEmpty();
    }
}