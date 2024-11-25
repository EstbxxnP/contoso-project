package com.contoso.contoso_springboot.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_departament")
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "ID departament can´t be Null")
    private long idDepartament;

    @Column
    @NotNull(message = "Description company can´t be Null ")
    private String description;

    @ManyToOne
    @JoinColumn(name = "IdCompany")
    private Company company;

    @OneToMany(mappedBy = "departament")
    private List<User> users;
}


