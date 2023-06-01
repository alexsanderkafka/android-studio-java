package com.alex.teste.oop;

public class Animal {

    String cor;
    double tamanho;
    double peso;

    public Animal(String cor, double tamanho, double peso) {
        this.cor = cor;
        this.tamanho = tamanho;
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public double getTamanho() {
        return tamanho;
    }

    public double getPeso() {
        return peso;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void dormir(){
        System.out.println("DORMIR COMO UM ANIMAL");
    }

    public void correr(){
        System.out.println("CORRER COMO UM ");
    }
}
