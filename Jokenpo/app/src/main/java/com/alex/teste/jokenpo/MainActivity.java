package com.alex.teste.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imgTela = findViewById(R.id.telaResult);
        TextView texto = findViewById(R.id.textResult);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra":
                imgTela.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgTela.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgTela.setImageResource(R.drawable.tesoura);
                break;
        }

        if((opcaoApp == "pedra" && opcaoSelecionada == "tesoura") || (opcaoApp == "papel" && opcaoSelecionada == "pedra") || (opcaoApp == "tesoura" && opcaoSelecionada == "papel")){
            texto.setText("Você perdeu!!!");
        }
        else if ((opcaoApp == "pedra" && opcaoSelecionada == "papel") || (opcaoApp == "papel" && opcaoSelecionada == "tesoura") || (opcaoApp == "tesoura" && opcaoSelecionada == "pedra")) {
            texto.setText("Você ganhou!!!");
        }
        else{
            texto.setText("Empate!!!");
        }

    }
}