package br.com.mercadolivre.pedido.entities;

import java.util.List;

public class Mesa {

    private String id;
    private List<Pedido> pedidos;
    private double totalConsumido;

    public Mesa() {
    }

    public Mesa(List<Pedido> pedidos, double totalConsumido) {
        // this.id = id;
        this.pedidos = pedidos;
        this.totalConsumido = totalConsumido;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getTotalConsumido() {
        return this.totalConsumido;
    }

    public void setTotalConsumido(double totalConsumido) {
        this.totalConsumido = totalConsumido;
    }

    @Override
    public String toString() {
        StringBuilder pedidos = new StringBuilder("[");
        int aux = 0;
        for (Pedido pedido:getPedidos()){
            if (aux > 0) pedidos.append(",");
            pedidos.append(pedido.toString());
            aux++;
        }
        pedidos.append("]");        
        return "{" +
            " \"id\":\"" + getId() + "\"" +
            ", \"pedidos\":" + pedidos + "" +
            ", \"totalConsumido\":\"" + getTotalConsumido() + "\"" +
            "}";
    }

}
