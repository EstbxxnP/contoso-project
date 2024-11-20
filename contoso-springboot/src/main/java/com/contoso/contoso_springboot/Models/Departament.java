package com.contoso.contoso_springboot.Models;

import jakarta.persistence.*;
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


