package com.alex.teste.passandoDadosDeUmaActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity2 extends AppCompatActivity {

    private TextView textNome;
    private TextView textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda2);

        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);

        //Recuperar os dados que foram enviados
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");
        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        //Configurar valores recuperados
        //textNome.setText(nome);
        //textIdade.setText(String.valueOf(idade));

        textNome.setText(usuario.getNome());
        textIdade.setText(usuario.getEmail());
    }
}