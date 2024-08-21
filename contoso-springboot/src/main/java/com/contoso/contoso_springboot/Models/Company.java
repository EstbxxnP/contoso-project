package com.contoso.contoso_springboot.Models;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Company {

    @NotNull(message = "ID company can´t be Null")
    private long idCompania;

    @NotNull(message = "Name company can´t be Null ")
    private String nombre;

    @NotNull(message = "Address company can´t be Null ")
    private String direccion;

    @NotNull(message = "Operation city company can´t be Null ")
    private String ciudadOperacion;

    private List<Departament> departaments;

    /**
     * Se crea el constructor para la clase compañía.
     *
     * @param idCompania
     * @param nombre
     * @param direccion
     * @param ciudadOperacion
     */

    public Company(long idCompania, String nombre, String direccion, String ciudadOperacion, List<Departament> departaments) {
        this.idCompania = idCompania;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudadOperacion = ciudadOperacion;
        this.departaments = departaments;

    }

    @Override
    public String toString() {
        return "Company [idCompania=" + idCompania +
                ", nombre=" + nombre + ", direccion=" + direccion +
                ", ciudadOperacion=" + ciudadOperacion +  ", departaments=" + departaments + "]";

    }



    // Getters y Setters de la clase compañía.

    public Long getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(long idCompania) {
        this.idCompania = idCompania;
    }

    public String getCiudadOperacion() {
        return ciudadOperacion;
    }

    public void setCiudadOperacion(String ciudadOperacion) {
        this.ciudadOperacion = ciudadOperacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Departament> getDepartaments() {
        return departaments;
    }

    public void setDepartaments(List<Departament> departaments) {
        this.departaments = departaments;
    }
}



