package com.contoso.contoso_springboot.Repositories;

import com.contoso.contoso_springboot.DTO.DepartamentsByCompanysDTO;
import com.contoso.contoso_springboot.Models.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {

    @Query("SELECT new com.contoso.contoso_springboot.DTO.DepartamentsByCompanysDTO(c.name, COUNT(d)) " +
            "FROM Departament d " +
            "JOIN d.company c " +
            "GROUP BY c.name " +
            "ORDER BY c.name")
    List<DepartamentsByCompanysDTO> countDepartamentsByCompanys();
}
