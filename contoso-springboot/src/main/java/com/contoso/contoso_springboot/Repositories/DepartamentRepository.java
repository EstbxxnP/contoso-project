package com.contoso.contoso_springboot.Repositories;

import com.contoso.contoso_springboot.Models.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {
}
