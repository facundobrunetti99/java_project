package com.example.javaPrueba.Controllers;
import com.example.javaPrueba.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.javaPrueba.Models.Cliente;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;


@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping("cliente/client")
    public List<Cliente> getClientes(){
        return  clienteRepo.findAll();
    }

    @GetMapping("cliente/edad")
    public void clienteEdad(){



    }
    @PostMapping("cliente/nuevo")
    public String post(@RequestBody Cliente cliente){

        int diaNac=cliente.getFehcanac().getDayOfMonth();
        Month mes;
        mes = cliente.getFehcanac().getMonth();
        int mesNac=mes.getValue();
        int añoNac=cliente.getFehcanac().getYear();



        LocalDate fechaActual = LocalDate.now();
        int añoActual=fechaActual.getYear();
        Month mesActualMonth=fechaActual.getMonth();
         int mesActual=mesActualMonth.getValue();
         int diaActual=fechaActual.getDayOfMonth();


       /*12/1/1999 29/1/2024*/

        int edadOp=0;
        int mesOp=mesActual-mesNac;
        int diaOp=diaActual-diaNac;

        if(mesOp==0){
            if(diaOp>0){
                edadOp=añoActual-añoNac-1;

            }if(diaOp==0 || diaOp<0){
                edadOp=añoActual-añoNac;
            }
            }if(mesOp<0){
            edadOp=añoActual-añoNac-1;
        }if(mesOp>0){
            edadOp=añoActual-añoNac;
        }
        cliente.setEdad(edadOp);
        clienteRepo.save(cliente);
        return "Alta realizada";
    }

    @PutMapping("cliente/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente updatecliente = clienteRepo.findById(id).get();
        updatecliente.setEdad(cliente.getEdad());
        updatecliente.setLastname(cliente.getLastname());
        updatecliente.setName(cliente.getName());
        updatecliente.setVenta(cliente.getVenta());
        updatecliente.setFehcanac(cliente.getFehcanac());
        return "Se realizo el cambio";
    }


}
