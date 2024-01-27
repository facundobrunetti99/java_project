package com.example.javaPrueba.Repository;
import com.example.javaPrueba.Models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
}
