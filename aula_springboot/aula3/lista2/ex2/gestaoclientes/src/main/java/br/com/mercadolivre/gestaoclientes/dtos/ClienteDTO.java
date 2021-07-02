package br.com.mercadolivre.gestaoclientes.dtos;


import java.util.ArrayList;
import java.util.List;

import br.com.mercadolivre.gestaoclientes.entities.Cliente;
import br.com.mercadolivre.gestaoclientes.entities.Pedido;

public class ClienteDTO {

    private String id, nome, cpf, email, telefone;
    private List<PedidoDTO> pedidos = new ArrayList<>();

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();

        List<PedidoDTO> pedidoDTOList = new ArrayList<>();
        PedidoDTO aux = new PedidoDTO();

        for (Pedido prod : cliente.getPedidos()) {
            pedidoDTOList.add(aux.converte(prod));            
        }
        this.pedidos = pedidoDTOList;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<PedidoDTO> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }
    
}
