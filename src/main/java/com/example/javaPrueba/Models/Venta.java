package com.example.javaPrueba.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="tipo_venta")
    private String tipoVenta;
    @Column(name="fecha_venta")
    private String fecha_venta;
    @OneToMany(mappedBy="venta")
    @JsonIgnore
    private List<Producto> productoList;

    public Venta() {
    }

    public Venta(String tipoVenta, String fecha_venta, List<Producto> productoList) {
        this.tipoVenta = tipoVenta;
        this.fecha_venta = fecha_venta;
        this.productoList = productoList;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }




}
