package com.contoso.contoso_springboot.Models;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Departament {


    private Long idDepartamento;

    private String descripcion;

    private List<User> users;

    private Long idCompany;

    private Company company;




    // Constructor de clase Departamento.

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    /**
     *
     * @param idDepartamento
     * @param descripcion
     * @param company
     * @param users
     */
    public Departament(Long idDepartamento, String descripcion, Company company, List<User> users, Long idCompany) {
        this.idDepartamento = idDepartamento;
        this.descripcion = descripcion;
        this.company = company;
        this.users = users;
        this.idCompany = idCompany;
    }

    @Override
    public String toString() {
        return "Departamento [idDepartamento=" + idDepartamento +
                ", descripcion=" + descripcion + ", company=" + company +
                ", users=" + users +  "]";

    }


    // Getters y Setters de la clase Departamento.


    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}


