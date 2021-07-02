package br.com.mercadolivre.gestaoclientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.gestaoclientes.dtos.ClienteDTO;
import br.com.mercadolivre.gestaoclientes.entities.Cliente;
import br.com.mercadolivre.gestaoclientes.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/create")
    public ClienteDTO postCliente(Cliente cliente){
        return clienteService.add(cliente);
    }

}
