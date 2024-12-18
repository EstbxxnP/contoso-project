package com.contoso.contoso_springboot.UnitTesting.Repositories;

import com.contoso.contoso_springboot.Models.Company;
import com.contoso.contoso_springboot.Repositories.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    @Rollback(false)
    public void saveDepartamentTest() {
        Company company = new Company();
        company.setCompanyId(1L);
        company.setAddress("Calle 98 # 45 - 67");
        company.setCityOfOperation("Bogotá, D.C");
        company.setName("Globant");

        Company companySaved = companyRepository.save(company);
        assertThat(companySaved.getCompanyId()).isNotNull();
    }

    @Test
    public void getAllUsersTest() {
        List<Company> companies = companyRepository.findAll();
        assertThat(companies).isNotEmpty();
    }
}