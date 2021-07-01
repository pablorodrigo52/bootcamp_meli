package br.com.mercadolivre.pedido.entities;

public class Prato {

    private String id;
    private double preco;
    private String descricao;
    private int quantidade;

    public Prato() {
    }

    public Prato(double preco, String descricao, int quantidade) {
        // this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "{" +
            " \"id\":\"" + getId() + "\"" +
            ", \"preco\":" + getPreco() + "" +
            ", \"descricao\":\"" + getDescricao() + "\"" +
            ", \"quantidade\":" + getQuantidade() + "" +
            "}";
    }

}
