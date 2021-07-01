package br.com.mercadolivre.pedido.entities;

public class Caixa {
    private double total;
    private java.util.List<Mesa> mesas = new java.util.ArrayList<>();


    public Caixa() {
    }

    public java.util.List<Mesa> getMesas() {
        return this.mesas;
    }

    public void setMesas(java.util.List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public Caixa(double total) {
        this.total = total;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
