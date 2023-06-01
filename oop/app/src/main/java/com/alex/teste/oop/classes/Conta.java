package com.alex.teste.oop.classes;

public class Conta {

    private int numConta;
    private double saldo;

    public Conta(int numConta, double saldo) {
        this.numConta = numConta;
        this.saldo = saldo;
    }

    public int getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }


    public void depositar(double valorDeposito){
        saldo += valorDeposito;
    }

    public void sacar(double valorSaque){
        if(saldo >= valorSaque){
            saldo -= valorSaque;
        }
        else{
            System.out.println("Não foi possivel, valor de saque maior que valor na conta");
        }
    }

    public double recuperarSaldo(){
        return this.saldo;
    }
}
