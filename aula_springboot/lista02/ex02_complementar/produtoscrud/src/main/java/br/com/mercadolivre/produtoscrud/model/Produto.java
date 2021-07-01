package br.com.mercadolivre.produtoscrud.model;

/**
 * Produto
 */
public class Produto {

    private int id;
    private int ammount;
    private String name;
    private double value;


    public Produto() {}

    public Produto(int ammount, String name, double value) {
        this.ammount = ammount;
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmmount() {
        return this.ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
            " \"id\":\"" + getId() + "\"" +
            ", \"ammount\":\"" + getAmmount() + "\"" +
            ", \"name\":\"" + getName() + "\"" +
            ", \"value\":\"" + getValue() + "\"" +
            "}";
    }
}