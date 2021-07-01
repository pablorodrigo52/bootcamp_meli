package br.com.mercadolivre.gestaoclientes.dtos;

import java.util.List;

import br.com.mercadolivre.gestaoclientes.entities.Pedido;
import br.com.mercadolivre.gestaoclientes.entities.Produto;

public class PedidoDTO {

    private String id;
    List<Produto> produtos;
    double valorTotal;


    public PedidoDTO(){}

    private PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.produtos = pedido.getProdutos();
        this.valorTotal = pedido.getValorTotal();
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PedidoDTO converte (Pedido pedido){
        return new PedidoDTO(pedido);
    }

}
