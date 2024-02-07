package com.example.javaPrueba.Controllers;
import com.example.javaPrueba.Repository.ClienteRepository;
import com.example.javaPrueba.Service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.javaPrueba.Models.Cliente;
import java.util.List;

@RestController
public class ClienteController extends ServiceCliente {

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping("cliente/clientes")
    public List<Cliente> getClientes(){
        return  clienteRepo.findAll();
    }

    @PostMapping("cliente/alta")
    public String post(@RequestBody Cliente cliente){
        edadPersona(cliente);
        clienteRepo.save(cliente);
        return "Alta realizada";
    }

    @PutMapping("cliente/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente updatecliente = clienteRepo.findById(id).get();
        updatecliente.setEdad(cliente.getEdad());
        updatecliente.setLastname(cliente.getLastname());
        updatecliente.setName(cliente.getName());
        updatecliente.setFehcanac(cliente.getFehcanac());
        return "Se realizo el cambio";
    }


}
