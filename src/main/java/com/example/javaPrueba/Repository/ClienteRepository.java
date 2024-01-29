package com.example.javaPrueba.Repository;
import com.example.javaPrueba.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
