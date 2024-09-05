package com.contoso.contoso_springboot.Repositories;

import com.contoso.contoso_springboot.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
