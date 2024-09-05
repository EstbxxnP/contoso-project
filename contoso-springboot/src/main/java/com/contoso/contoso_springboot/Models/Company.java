package com.contoso.contoso_springboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "ID company can´t be Null")
    private long idCompany;

    @Column
    @NotNull(message = "Name company can´t be Null ")
    private String name;

    @Column
    @NotNull(message = "Address company can´t be Null ")
    private String address;

    @Column
    @NotNull(message = "Operation city company can´t be Null ")
    private String cityOfOperation;

    @OneToMany(mappedBy = "company")
    private List<Departament> departaments;
}



