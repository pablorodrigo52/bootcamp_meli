package br.com.mercadolivre.gestaoclientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.gestaoclientes.dtos.ClienteDTO;
import br.com.mercadolivre.gestaoclientes.entities.Cliente;
import br.com.mercadolivre.gestaoclientes.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    public List<ClienteDTO> getClientes(){
        return clienteService.getClientList();
    }

    @PostMapping("/create")
    public ClienteDTO postCliente(@RequestBody Cliente cliente){
        return clienteService.add(cliente);
    }
}
