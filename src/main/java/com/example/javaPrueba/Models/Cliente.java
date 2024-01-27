package com.example.javaPrueba.Models;
import jakarta.persistence.Column;
import jakarta.persistence.*;


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

    @OneToOne
    private Venta  venta;

    public Cliente() {
    }

    public Cliente(String lastname, int edad, String name, Venta venta) {
        this.lastname = lastname;
        this.edad = edad;
        this.name = name;
        this.venta = venta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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
