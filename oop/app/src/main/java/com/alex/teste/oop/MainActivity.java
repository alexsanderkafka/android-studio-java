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
        cs.openDoor();*/

        Funcionario fun = new Funcionario("Alexsander", 1000);

        // fun.recuperaSal();

        System.out.println(fun.somaSal());

        double salBonus = fun.bonus(1000);
        System.out.println(salBonus);
    }
}