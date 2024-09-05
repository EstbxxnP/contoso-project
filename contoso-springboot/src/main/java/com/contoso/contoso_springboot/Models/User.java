package com.contoso.contoso_springboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.server.CoWebFilter;

@Data
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @NotNull(message = "ID user can´t be Null")
    private long idUser;

    @Column
    @NotNull(message = "Name user can´t be Null")
    private String name;

    @Column
    @NotNull(message = "Last name user can´t be Null")
    private String lastName;

    @Column
    @NotNull(message = " Job user can´t be Null")
    private String position;

    @Column
    @NotNull(message = "Address user can´t be Null")
    private String address;

    @Column
    @NotNull(message = "Phone number user can´t be Null")
    private String phoneNumber;

    @Column
    @NotNull(message = "City of residence user can´t be Null")
    private String cityOfResidence;

    @Column
    @NotNull(message = "Status user can´t be Null")
    private String userStatus;

    @Column
    @NotNull(message = "salary user can´t be Null")
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "IdDepartament")
    private Departament departament;
}


