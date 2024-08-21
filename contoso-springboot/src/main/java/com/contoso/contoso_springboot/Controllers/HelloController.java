package com.contoso.contoso_springboot.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/saludo")
    public String saludo() {
        return "Hello World";
    }
}




/** POST localhost:8080/departaments
 Content-Type: application/json

 {
 "idDepartamento": 1,
 "descripcion": "Marketing"
 }

 ###

 POST localhost:8080/departaments
 Content-Type: application/json

 {

 "idDepartamento": 2,
 "descripcion": "Judicial"

 }



 POST localhost:8080/companys
 Content-Type: application/json

 {
 "idCompania": 2,
 "nombre": "Globant",
 "direccion": "Cra. 86 #26",
 "ciudadOperacion": "Bogotá, D.C"

 }

 ###

 POST localhost:8080/users
 Content-Type: application/json

 {

 "idUsuario": 1,
 "nombre": "Juan",
 "apellido": "Rivera",
 "cargo": "",
 "direccion": "",
 "telefono": "",
 "ciudadResidencia": "",
 "estadoUsuario": "",
 "salario": 1.00,
 "departament": {
 "idDepartamento": 1,
 "descripcion": "Judicial"
 },
 "company": {
 "idCompania": 1,
 "nombre": "Globant",
 "direccion": "Cra.86 #26",
 "ciudadOperacion": "Bogotá, D.C"

 }
 }**/



