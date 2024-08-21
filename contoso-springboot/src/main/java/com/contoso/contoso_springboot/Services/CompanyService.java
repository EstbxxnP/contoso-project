package com.contoso.contoso_springboot.Services;

import com.contoso.contoso_springboot.Models.Company;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    private List<Company> companys = new ArrayList<>();

    public List<Company> getCompanys() {
        return companys;
    }

    public Company getCompanyById(Long id) {
        return companys.stream().filter(company -> company.getIdCompania().equals(id)).findFirst().orElse(null);
    }

    public void addCompany(Company company) {
        companys.add(company);
    }

    public void updateCompany(Long id, Company updatedCompany) {
        Company company = getCompanyById(id);
        if (company != null) {
            company.setNombre(updatedCompany.getNombre());
            company.setNombre(updatedCompany.getDireccion());
            company.setNombre(updatedCompany.getCiudadOperacion());

        }
    }

    public void deleteCompany(Long id) {
        companys.removeIf(company -> company.getIdCompania().equals(id));
    }
}


