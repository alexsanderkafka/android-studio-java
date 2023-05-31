package com.alex.teste.frasedodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){

        new Random();

        String[] frases = {
                "Esse texto era uma frase do dia.",
                "",
                "Frase 3",
                "Frase 4",
                "Frase 5"
        };

        int ale = new Random().nextInt(5);

        TextView texto = findViewById(R.id.textResultado);
        texto.setText(frases[ale]);
    }
}