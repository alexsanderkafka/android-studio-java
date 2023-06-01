package com.alex.teste.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Casa cs = new Casa();
        cs.openDoor();

        Funcionario fun = new Funcionario("Alexsander", 1000);

        fun.recuperaSal();

        System.out.println(fun.somaSal());

        double salBonus = fun.bonus(1000);
        System.out.println(salBonus);
         */

        // Animal animal = new Animal("Vermelho", 1.20, 30);

        Cao cao = new Cao("Vermelho", 1.20, 30.0);
        cao.dormir();
        cao.correr();

        Passaro passaro = new Passaro("Vermelho", 1.20, 30.0);
        passaro.dormir();
        passaro.correr();

        System.out.println(cao.getTamanho());
        System.out.println(passaro.getCor());

        cao.latir();
        passaro.voar();

        cao.setCor("Azul");
        System.out.println(cao.getCor());

    }
}