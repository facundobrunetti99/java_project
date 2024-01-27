package com.example.javaPrueba.Controllers;
import java.util.List;
import com.example.javaPrueba.Models.Venta;
import com.example.javaPrueba.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VentaController {
    @Autowired private VentaRepository ventarepo;
    @GetMapping("ventas")
    public List<Venta> getVent(){
        return ventarepo.findAll();
    }

    @PostMapping("ventasrepo/alta")
    public String post(@RequestBody Venta venta){
        ventarepo.save(venta);
        return "Alta realizada";
    }
    @PutMapping("venta/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Venta ventaq){
       Venta updateVenta=ventarepo.findById(id).get();
       updateVenta.setTipoVenta(ventaq.getTipoVenta());
       updateVenta.setFecha_venta(ventaq.getFecha_venta());
     return "Se realizo el cambio";
    }




}
