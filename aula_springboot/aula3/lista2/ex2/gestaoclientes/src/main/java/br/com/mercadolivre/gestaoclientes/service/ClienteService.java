package br.com.mercadolivre.gestaoclientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.gestaoclientes.dtos.ClienteDTO;
import br.com.mercadolivre.gestaoclientes.entities.Cliente;
import br.com.mercadolivre.gestaoclientes.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteService (ClienteRepository repository){
        this.repository = repository;
    }

    public List<ClienteDTO> getClientList(){
        List<ClienteDTO> productDTOList = new ArrayList<>();
        for (Cliente cliente : repository.getList()) {
            productDTOList.add(new ClienteDTO(cliente));            
        }
        return productDTOList;
    }

    public ClienteDTO add(Cliente cliente){
        cliente.setId(UUID.randomUUID().toString());
        repository.add(cliente);
        return new ClienteDTO(cliente);
    }
}
