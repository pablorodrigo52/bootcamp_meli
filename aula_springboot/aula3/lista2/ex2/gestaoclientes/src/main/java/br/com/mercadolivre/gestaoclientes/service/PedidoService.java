package br.com.mercadolivre.gestaoclientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.gestaoclientes.dtos.PedidoDTO;
import br.com.mercadolivre.gestaoclientes.entities.Cliente;
import br.com.mercadolivre.gestaoclientes.entities.Pedido;
import br.com.mercadolivre.gestaoclientes.entities.Produto;
import br.com.mercadolivre.gestaoclientes.repository.PedidoRepository;

@Service
public class PedidoService {
    
    private final PedidoRepository repository;

    @Autowired
    public PedidoService (PedidoRepository repository){
        this.repository = repository;
    }

    public PedidoDTO add(String idcliente, List<Produto> produtos){
        Pedido pedido = new Pedido();
        PedidoDTO pedidoDTO = new PedidoDTO();

        Optional<Cliente> clienteOptional = repository.getClientList()
        .stream()
        .filter(cliente -> cliente.getCpf().equals(idcliente) || cliente.getId().equals(idcliente)).findAny();

        if (clienteOptional.isPresent())
        {
            double valorTotal = produtos.stream().mapToDouble(produto -> produto.getPreco() * produto.getQuantidade()).sum();
            pedido.setId(UUID.randomUUID().toString());
            pedido.setValorTotal(valorTotal);
            pedido.setProdutos(produtos);
            clienteOptional.get().getPedidos().add(pedido);

            repository.toConsistClient(clienteOptional.get());
        }
        return pedidoDTO.converte(pedido);
    }

    public List<PedidoDTO> getPedidosList(String idcliente) {
        List<PedidoDTO> listaPedidosGestao = new ArrayList<>();
        Optional<Cliente> clienteOptional = repository.getClientList()
            .stream()
            .filter(cliente -> cliente.getCpf().equals(idcliente) || cliente.getId().equals(idcliente) ).findAny();

        if (clienteOptional.isPresent()){
            List<Pedido> p = clienteOptional.get().getPedidos();
            for(Pedido pedido: p){
                PedidoDTO aux = new PedidoDTO();
                aux = aux.converte(pedido);
                listaPedidosGestao.add(aux);
            }
        } 
        return listaPedidosGestao;
    }
}
