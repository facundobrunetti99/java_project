package com.example.javaPrueba.Repository;
import com.example.javaPrueba.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
