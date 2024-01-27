package com.example.javaPrueba.Models;
import jakarta.persistence.*;
import jakarta.persistence.Column;

@Entity
@Table
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroprod;
    @Column(name="nombre_prod")
    private String nameprod;
    @Column(name="precio_prod")
    private int precio;
    @ManyToOne
    @JoinColumn(name="venta_id")
    private Venta venta;


    public Long getNroprod() {
        return nroprod;
    }

    public void setNroprod(Long nroprod) {
        this.nroprod = nroprod;
    }

    public String getNameprod() {
        return nameprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto() {
    }

    public Producto(String nameprod, int precio, Venta venta) {
        this.nameprod = nameprod;
        this.precio = precio;
        this.venta = venta;
    }
}
