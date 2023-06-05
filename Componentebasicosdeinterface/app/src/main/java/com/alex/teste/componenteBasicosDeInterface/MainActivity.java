package com.alex.teste.componenteBasicosDeInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText nomeText;
    private TextInputEditText emailText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeText = findViewById(R.id.textNome);
        emailText = findViewById(R.id.textEmail);
        textView = findViewById(R.id.textResultado);
    }

    @SuppressLint("SetTextI18n")
    public void enviar(View view){
        String nome = nomeText.getText().toString();
        String email = emailText.getText().toString();

        textView.setText("Nome: " + nome + "--- Email: " + email);
    }

    public void limpar(View view){
        nomeText.setText("");
        emailText.setText("");
    }

}