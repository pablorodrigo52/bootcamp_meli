package br.com.mercadolivre.pedido.entities;

import java.util.List;

public class Pedido {
    
    private String id;
    private List<Prato> pratos;

    public Pedido() {
    }

    public Pedido(List<Prato> pratos) {
        // this.id = id;
        this.pratos = pratos;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Prato> getPratos() {
        return this.pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    @Override
    public String toString() {
        StringBuilder pratos = new StringBuilder("");
        int aux = 0;
        for (Prato prato:getPratos()){
            if (aux > 0) pratos.append(",");
            pratos.append(prato.toString());
            aux++;
        }
        return "{" +
            " \"id\":\"" + getId() + "\"" +
           ", \"pratos\":[" + pratos.toString() + "]" +
            "}";
    }

}
