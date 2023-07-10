package com.example.kafkatech.appfirebase;

public class Produto {

    private String descricao;
    private String marca;
    private double price;

    public Produto() {
    }

    public Produto(String descricao, String marca, double price) {
        this.descricao = descricao;
        this.marca = marca;
        this.price = price;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
