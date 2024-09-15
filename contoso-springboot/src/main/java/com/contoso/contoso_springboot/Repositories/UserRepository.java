package com.contoso.contoso_springboot.Repositories;

import com.contoso.contoso_springboot.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT c.name AS compania, d.description AS departamento, COUNT(u) AS numberOfUsers " +
            "FROM User u " +
            "JOIN u.departament d " +
            "JOIN d.company c " +
            "GROUP BY c.name, d.description " +
            "ORDER BY c.name, d.description")
    List<Object[]> usersByDepartamentAndCompany();

    @Query("SELECT c.name AS company, COUNT(d) AS numberOfDepartaments " +
            "FROM Departament d " +
            "JOIN d.company c " +
            "GROUP BY c.name " +
            "ORDER BY c.name")
    List<Object[]> countDepartamentsByCompanys();


    @Query("SELECT c.name AS compania, d.description AS departamento, SUM(u.salary) AS totalSalary " +
            "FROM User u " +
            "JOIN u.departament d " +
            "JOIN d.company c " +
            "GROUP BY c.name, d.description " +
            "ORDER BY c.name, d.description")
    List<Object[]> salaryByDepartamentAndCompany();
}

