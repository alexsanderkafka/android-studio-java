package com.alex.teste.componenteBasicosDeInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText nomeText;
    private TextInputEditText emailText;
    private TextView textView;
    private CheckBox checkVerde, checkBranco, checkVermelho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeText = findViewById(R.id.textNome);
        emailText = findViewById(R.id.textEmail);
        textView = findViewById(R.id.textResultado);

        checkVerde = findViewById(R.id.checkVerde);
        checkBranco = findViewById(R.id.checkBranco);
        checkVermelho = findViewById(R.id.checkVermelho);
    }

    @SuppressLint("SetTextI18n")
    public void checbox(){

        String texto = "";
        if (checkVerde.isChecked()){
            //String cor = checkVerde.getText().toString();
            //texto = cor;

            texto = "Verde selecionado - ";
        }
        if (checkBranco.isChecked()){
            texto += "Branco selecionado - ";
        }
        if(checkVermelho.isChecked()){
            texto += "Vermelho selecionado";
        }

        textView.setText(texto);
    }

    public void enviar(View view){
        /*
        String nome = nomeText.getText().toString();
        String email = emailText.getText().toString();

        textView.setText("Nome: " + nome + "--- Email: " + email);
         */

        checbox();

    }

    public void limpar(View view){
        nomeText.setText("");
        emailText.setText("");
    }

}