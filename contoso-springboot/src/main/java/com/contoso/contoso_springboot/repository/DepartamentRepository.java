package com.contoso.contoso_springboot.repository;

import com.contoso.contoso_springboot.dto.DepartamentsByCompanysDTO;
import com.contoso.contoso_springboot.model.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {

    @Query("SELECT new com.contoso.contoso_springboot.dto.DepartamentsByCompanysDTO(c.name, COUNT(d)) " +
            "FROM Departament d " +
            "JOIN d.company c " +
            "GROUP BY c.name " +
            "ORDER BY c.name")
    List<DepartamentsByCompanysDTO> countDepartamentsByCompanys();
}
