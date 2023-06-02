package com.alex.teste.oop;

public class Alexsander extends Cidadao implements Presidente{
    @Override
    public void ganharEleicao() {
        System.out.println("Ganhar uma eleição no Brasil");
    }
}
