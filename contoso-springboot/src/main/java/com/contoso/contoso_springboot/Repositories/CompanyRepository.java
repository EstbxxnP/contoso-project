package com.contoso.contoso_springboot.Repositories;

import com.contoso.contoso_springboot.DTO.SalaryByDepartamentAndCompanyDTO;
import com.contoso.contoso_springboot.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT new com.contoso.contoso_springboot.DTO.SalaryByDepartamentAndCompanyDTO(c.name, d.description, SUM(u.salary)) " +
            "FROM User u " +
            "JOIN u.departament d " +
            "JOIN d.company c " +
            "GROUP BY c.name, d.description " +
            "ORDER BY c.name, d.description")
    List<SalaryByDepartamentAndCompanyDTO> salaryByDepartamentAndCompany();
}
