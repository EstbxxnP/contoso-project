package com.contoso.contoso_springboot.Services;

import com.contoso.contoso_springboot.Models.Company;
import com.contoso.contoso_springboot.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getCompanys() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public void addCompany(Company company){
        companyRepository.save(company);
    }

    public void updateCompany(Company company){
        companyRepository.save(company);
    }

    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }
}


