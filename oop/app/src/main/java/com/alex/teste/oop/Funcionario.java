package com.alex.teste.oop;

public class Funcionario {

    String nome;
    double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void recuperaSal(){
        salario = salario - (salario * 0.1);
        System.out.println(salario);
    }

    public double somaSal(){
        return salario * 1.10;
    }

    public double bonus(double bonus){
        return salario + bonus;
    }
}
