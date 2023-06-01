package com.alex.teste.oop;

public class Passaro extends Animal{

    public Passaro(String cor, double tamanho, double peso) {
        super(cor, tamanho, peso);
    }

    public void voar(){
        System.out.println("VOAR COMO UM PASSARO");
    }
}
