package com.contoso.contoso_springboot.Repositories;

import com.contoso.contoso_springboot.DTO.UsersByDepartamentAndCompanyDTO;
import com.contoso.contoso_springboot.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.contoso.contoso_springboot.DTO.UsersByDepartamentAndCompanyDTO(c.name, d.description, COUNT(u)) " +
            "FROM User u " +
            "JOIN u.departament d " +
            "JOIN d.company c " +
            "GROUP BY c.name, d.description " +
            "ORDER BY c.name, d.description")
    List<UsersByDepartamentAndCompanyDTO> usersByDepartamentAndCompany();
}

