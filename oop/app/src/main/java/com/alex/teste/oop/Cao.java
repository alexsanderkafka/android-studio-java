package com.alex.teste.oop;

public class Cao extends Animal{

    public Cao(String cor, double tamanho, double peso) {
        super(cor, tamanho, peso);
    }

    public void latir(){
        System.out.println("LATIR COMO UM CACHORRO");
    }

}
