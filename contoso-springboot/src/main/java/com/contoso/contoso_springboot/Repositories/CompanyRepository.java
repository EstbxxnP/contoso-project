package com.contoso.contoso_springboot.Repositories;

import com.contoso.contoso_springboot.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT c.name AS compania, d.description AS departamento, SUM(u.salary) AS totalSalary " +
            "FROM User u " +
            "JOIN u.departament d " +
            "JOIN d.company c " +
            "GROUP BY c.name, d.description " +
            "ORDER BY c.name, d.description")
    List<Object[]> salaryByDepartamentAndCompany();
}
