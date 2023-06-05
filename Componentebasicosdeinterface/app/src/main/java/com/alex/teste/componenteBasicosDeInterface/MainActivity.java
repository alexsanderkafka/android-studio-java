package com.alex.teste.componenteBasicosDeInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText nomeText;
    private TextInputEditText emailText;
    private TextView textView;
    private CheckBox checkVerde, checkBranco, checkVermelho;
    private RadioButton sexoMasculino, sexoFemenino;
    private RadioGroup opcaoSexo;

    @SuppressLint("MissingInflatedId")
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

        sexoMasculino = findViewById(R.id.sexoMasc);
        sexoFemenino = findViewById(R.id.sexoFemi);

        opcaoSexo = findViewById(R.id.sexo);
        radioButton();
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

    @SuppressLint("SetTextI18n")
    public void radioButton(){

        /*
        if(sexoMasculino.isChecked()){
            textView.setText("Masculino");
        }
        else if (sexoFemenino.isChecked()){
            textView.setText("Femenino");
        }*/

        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.sexoMasc){
                    textView.setText("Masculino");
                }else if (checkedId == R.id.sexoFemi){
                    textView.setText("Femenino");
                }
            }
        });

    }


    public void enviar(View view){
        /*
        String nome = nomeText.getText().toString();
        String email = emailText.getText().toString();

        textView.setText("Nome: " + nome + "--- Email: " + email);
         */

        // checbox();
        // radioButton();

    }

    public void limpar(View view){
        nomeText.setText("");
        emailText.setText("");
    }

}