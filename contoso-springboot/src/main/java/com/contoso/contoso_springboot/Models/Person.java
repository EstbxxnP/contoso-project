package com.contoso.contoso_springboot.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPerson;
    private String name;
    private String lastName;
    private String email;
    private String address;
}
