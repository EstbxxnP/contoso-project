package com.contoso.contoso_springboot.UnitTesting.Services;

import com.contoso.contoso_springboot.Models.Company;
import com.contoso.contoso_springboot.Repositories.CompanyRepository;
import com.contoso.contoso_springboot.Services.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.doNothing;

class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCompanyTest() {
        Company company = new Company();
        company.setCompanyId(1L);
        company.setAddress("Calle 98 # 45 - 67");
        company.setCityOfOperation("Bogotá, D.C");
        company.setName("Globant");

        when(companyRepository.save(ArgumentMatchers.any(Company.class))).thenAnswer(invocation -> invocation.getArgument(0));
        companyService.addCompany(company);
        verify(companyRepository, times(1)).save(company);
    }

    @Test
    void deleteCompanyTest() {
        Long id = 1L;

        doNothing().when(companyRepository).deleteById(id);
        companyService.deleteCompany(id);
        verify(companyRepository, times(1)).deleteById(id);
    }

    @Test
    void getCompanysTest() {
        Company company = new Company();
        company.setCompanyId(1L);
        company.setName("Globant");

        given(companyRepository.findAll()).willReturn(Arrays.asList(company));
        List<Company> companys = companyService.getCompanys();
        assertThat(companys)
                .isNotEmpty()
                .extracting(Company::getName)
                .contains("Globant");
    }

    @Test
    void getCompanyById() {
        Company company = new Company();
        company.setCompanyId(1L);
        company.setName("Globant");

        given(companyRepository.findById(company.getCompanyId())).willReturn(Optional.of(company));
        Optional<Company> userNotFound = companyService.getCompanyById(company.getCompanyId());
        assertThat(userNotFound).isPresent();
        assertThat(userNotFound.get().getName()).isEqualTo("Globant");
    }

    @Test
    void updateCompanyTest() {
        Long companyId = 1L;

        Company company = new Company();
        company.setCompanyId(1L);
        company.setName("Globant");
        Company updatedCompany = new Company();
        updatedCompany.setCompanyId(companyId);
        updatedCompany.setName("Salud");

        given(companyRepository.findById(companyId)).willReturn(Optional.of(company));
        given(companyRepository.save(updatedCompany)).willReturn(updatedCompany);
        companyService.updateCompany(updatedCompany);
        assertThat(updatedCompany.getName()).isEqualTo("Salud");
        verify(companyRepository).save(updatedCompany);
    }
}
