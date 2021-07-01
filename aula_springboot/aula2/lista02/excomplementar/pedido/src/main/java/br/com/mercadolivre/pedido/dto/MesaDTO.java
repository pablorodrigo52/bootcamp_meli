package br.com.mercadolivre.pedido.dto;

import java.util.List;

import br.com.mercadolivre.pedido.entities.Mesa;
import br.com.mercadolivre.pedido.entities.Pedido;
import br.com.mercadolivre.pedido.entities.Prato;

public class MesaDTO {
    private String id;
    private List<Pedido> pedidos;
    private double totalConsumido;

    public MesaDTO() {
    }

    public MesaDTO(Mesa mesa) {
        this.id = mesa.getId();
        this.pedidos = mesa.getPedidos();

        for (Pedido pedido:this.pedidos){
            for(Prato prato:pedido.getPratos()){
                this.totalConsumido += prato.getPreco();
            }
        }
        mesa.getPedidos().clear();
    }

    public String getId() {
        return this.id;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public double getTotalConsumido() {
        return this.totalConsumido;
    }


    @Override
    public String toString() {
        StringBuilder pedidos = new StringBuilder("");
        int aux = 0;
        for (Pedido pedido:getPedidos()){
            if (aux > 0) pedidos.append(",");
            pedidos.append(pedido.toString());
            aux++;
        }

        return "{" +
            " \"id\":'" + getId() + "'" +
            ", \"totalConsumido\":'" + getTotalConsumido() + "'" +
            "}";
    }


}
