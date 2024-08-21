package com.contoso.contoso_springboot.Models;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.server.CoWebFilter;

public class User {

    @NotNull(message = "ID user can´t be Null")
    private Long idUsuario;

    @NotNull(message = "Name user can´t be Null")
    private String nombre;

    @NotNull(message = "Last name user can´t be Null")
    private String apellido;

    @NotNull(message = " Job user can´t be Null")
    private String cargo;

    @NotNull(message = "Address user can´t be Null")
    private String direccion;

    @NotNull(message = "Phone number user can´t be Null")
    private String telefono;

    @NotNull(message = "City of residence user can´t be Null")
    private String ciudadResidencia;

    @NotNull(message = "Status user can´t be Null")
    private String estadoUsuario;

    @NotNull(message = "salary user can´t be Null")
    private Double salario;

    @NotNull(message = "ID departament user can´t be Null")
    private Long idDepartament;

    private Departament departament;



    /**
     *
     * Se crea el constructor de la clase usuario.
     *
     *
     * @param idUsuario
     * @param nombre
     * @param apellido
     * @param cargo
     * @param direccion
     * @param telefono
     * @param ciudadResidencia
     * @param estadoUsuario
     * @param salario
     * @param departament
     */

    public User(Long idUsuario, String nombre, String apellido, String cargo, String direccion, String telefono, String ciudadResidencia, String estadoUsuario, Double salario, Departament departament, Company company, Long idDepartament) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudadResidencia = ciudadResidencia;
        this.estadoUsuario = estadoUsuario;
        this.salario = salario;
        this.departament = departament;
        this.idDepartament = idDepartament;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre +
                ", apellido=" + apellido +", cargo=" + cargo +
                ", direccion=" + direccion + ", telefono=" + telefono +
                ", ciudadResidencia=" + ciudadResidencia +
                ", estadoUsuario=" + estadoUsuario + ", salario=" + salario +
                ", departamento=" + departament + ", compania=" + "]";
    }


    //Getters y Setters de clase Usuarios.

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Double getSalario() {
        return salario;
    }

    public @NotNull(message = "ID departament user can´t be Null") Long getIdDepartament() {
        return idDepartament;
    }

    public void setIdDepartament(@NotNull(message = "ID departament user can´t be Null") Long idDepartament) {
        this.idDepartament = idDepartament;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Departament getDepartamento() {
        return departament;
    }

    public void setDepartamento(Departament departament) {
        this.departament = departament;
    }


}


