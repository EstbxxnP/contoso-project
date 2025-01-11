package com.contoso.contoso_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @NotNull(message = "ID user can´t be Null")
    private long userId;

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


