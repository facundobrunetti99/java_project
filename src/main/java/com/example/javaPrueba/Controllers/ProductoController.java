package com.example.javaPrueba.Controllers;
import com.example.javaPrueba.Models.Producto;
import com.example.javaPrueba.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductoController {
    @Autowired
   private ProductoRepository reproductive;
    @GetMapping("products")
    public List<Producto>getProductos(){
        return reproductive.findAll();
    }

    @PostMapping("producto/alta")
    public String post(@RequestBody Producto prod){
        reproductive.save(prod);
        return "Producto almacenado";
    }
    @PutMapping("producto/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto updateProducto = reproductive.findById(id).get();
        updateProducto.setNameprod(updateProducto.getNameprod());
        updateProducto.setPrecio(updateProducto.getPrecio());
        updateProducto.setVenta(updateProducto.getVenta());
    return "producto modificado";
    }


}
