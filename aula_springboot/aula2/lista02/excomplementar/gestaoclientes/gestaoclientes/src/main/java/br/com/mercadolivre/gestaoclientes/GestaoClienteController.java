package br.com.mercadolivre.gestaoclientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.gestaoclientes.dtos.ClienteDTO;
import br.com.mercadolivre.gestaoclientes.dtos.PedidoDTO;
import br.com.mercadolivre.gestaoclientes.dtos.ProdutoDTO;
import br.com.mercadolivre.gestaoclientes.entities.Produto;
import br.com.mercadolivre.gestaoclientes.entities.Cliente;
import br.com.mercadolivre.gestaoclientes.entities.Pedido;

/**
 * GestaoClienteController
 */

@RestController
@RequestMapping("/loja")
public class GestaoClienteController {

    List<Produto> produtosGestao = new ArrayList<>();
    List<Cliente> clientesGestao = new ArrayList<>();
    List<Pedido> pedidosGestao = new ArrayList<>();

    @GetMapping("/index/produto")
    public List<ProdutoDTO> getProdutos(){
        List<ProdutoDTO> listaProdutosGestao = new ArrayList<>();

        ProdutoDTO aux = new ProdutoDTO();
        for(Produto produto: produtosGestao){
            aux = aux.converte(produto);
            listaProdutosGestao.add(aux);
        }
        return listaProdutosGestao;
    }

    @GetMapping("/index/cliente")
    public List<ClienteDTO> getClientes(){
        List<ClienteDTO> listaProdutosGestao = new ArrayList<>();

        for(Cliente cliente: clientesGestao){
            listaProdutosGestao.add(new ClienteDTO(cliente));
        }
        return listaProdutosGestao;
    }

    @PostMapping("/produto")
    public ProdutoDTO postProduto(@RequestBody Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produto.setId(UUID.randomUUID().toString());
        produtosGestao.add(produto);
        return produtoDTO.converte(produto);
    }

    @PostMapping("/cliente")
    public ClienteDTO postCliente(@RequestBody Cliente cliente){
        cliente.setId(UUID.randomUUID().toString());
        clientesGestao.add(cliente);
        return new ClienteDTO(cliente);
    }


    @PostMapping("/pedido")
    public PedidoDTO postPedido(@RequestParam String idcliente, @RequestBody List<Produto> produtos){
        Pedido pedido = new Pedido();
        PedidoDTO pedidoDTO = new PedidoDTO();

        Optional<Cliente> clienteOptional = clientesGestao
        .stream()
        .filter(cliente -> cliente.getCpf().equals(idcliente) || cliente.getId().equals(idcliente) ).findAny();

        if (clienteOptional.isPresent()){
            double valorTotal = produtos.stream().mapToDouble(produto -> produto.getPreco() * produto.getQuantidade()).sum();
            pedido.setId(UUID.randomUUID().toString());
            pedido.setValorTotal(valorTotal);
            pedido.setProdutos(produtos);
            clienteOptional.get().getPedidos().add(pedido);
        }
        pedidoDTO = pedidoDTO.converte(pedido);
        return pedidoDTO;
    }


    @GetMapping("/pedido/{idcliente}")
    public List<PedidoDTO> getPedidosCliente(@PathVariable String idcliente){
        List<PedidoDTO> listaPedidosGestao = new ArrayList<>();
        Optional<Cliente> clienteOptional = clientesGestao
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