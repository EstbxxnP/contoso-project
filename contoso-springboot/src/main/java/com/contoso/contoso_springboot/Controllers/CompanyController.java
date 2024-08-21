package com.contoso.contoso_springboot.Controllers;

import com.contoso.contoso_springboot.Models.Company;
import com.contoso.contoso_springboot.Services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;


@RestController
@RequestMapping("/companys")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanys() {
        return companyService.getCompanys();
    }

    @GetMapping("/{id}")
    public Company getIdCompany(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @PostMapping
    public void addCompany(@Valid @RequestBody Company company) {
        companyService.addCompany(company);
    }

    @PutMapping("/{id}")
    public void updateCompany(@PathVariable Long id, @RequestBody Company company) {
        companyService.updateCompany(id, company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }


}
