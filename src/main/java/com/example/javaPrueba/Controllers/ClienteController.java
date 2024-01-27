package com.example.javaPrueba.Controllers;
import com.example.javaPrueba.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.javaPrueba.Models.Cliente;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping("cliente/client")
    public List<Cliente> getClientes(){
        return  clienteRepo.findAll();
    }
    @PostMapping("cliente/nuevo")
    public String post(@RequestBody Cliente cliente){
        clienteRepo.save(cliente);
        return "Clientenuevo";
    }

    @PutMapping("cliente/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente updatecliente=clienteRepo.findById(id).get();
        updatecliente.setEdad(updatecliente.getEdad());
       updatecliente.setLastname(updatecliente.getLastname());
       updatecliente.setName(updatecliente.getName());
       updatecliente.setVenta(updatecliente.getVenta());
        return "Se realizo el cambio";
    }


}
