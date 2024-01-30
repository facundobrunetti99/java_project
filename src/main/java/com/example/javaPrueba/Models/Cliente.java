package com.example.javaPrueba.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dni;


    @Column(name="apellido")
    private String lastname;
    @Column(name="edad")
    private  int edad;
    @Column(name="nombre")
    private String name;
    @Column(name="fecha_nac")
    private LocalDate fehcanac;

    @OneToMany(mappedBy="cliente")
    @JsonIgnore
    private List<Venta> ventaList;


    public Cliente() {
    }

    public Cliente(String lastname, int edad, String name, LocalDate fehcanac, List<Venta> ventaList) {
        this.lastname = lastname;
        this.edad = edad;
        this.name = name;
        this.fehcanac = fehcanac;
       this.ventaList = ventaList;
    }

    public LocalDate getFehcanac() {
        return fehcanac;
    }

    public void setFehcanac(LocalDate fehcanac) {
        this.fehcanac = fehcanac;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
